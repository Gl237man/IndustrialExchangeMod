package com.gl237.Iexchange;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

import static net.minecraft.tileentity.TileEntityFurnace.getItemBurnTime;

/**
 * Created by gl237 on 21.09.2014.
 */
public class MatterGeneratorMachineTileEntity extends TileEntity implements IInventory, IFluidTank, IFluidHandler {
    private ItemStack[] InvItemStacks;//Предметы в контейнере

    public int FluidLevel;//Уровень жидкости в машине
    public int Progress;//Текущее состояние счетчика работы
    public int ProgressMax;//Максимальное состояния счетчика работы

    public MatterGeneratorMachineTileEntity() {
        super();
        InvItemStacks = new ItemStack[1];//Создаем пустой список предметов
    }

    //Событие при закрытии инвентаря
    @Override
    public void closeInventory() {
        // Нечего не делать
    }

    //Получение предметов из инвентаря stackNum номер стака amount Количество
    @Override
    public ItemStack decrStackSize(int stackNum, int amount) {
        if (InvItemStacks[stackNum] != null)//Если слот не пуст
        {
            if (InvItemStacks[stackNum].stackSize <= amount)//Если текущее количество меньше или равно запрашиваемому
            {
                ItemStack itemstack = InvItemStacks[stackNum];//Берем копию всех предметов
                InvItemStacks[stackNum] = null;//Очищяем слот
                markDirty();//Маркируем что ентити изменился
                return itemstack;//Возвращяем стак
            }
            ItemStack itemstack1 = InvItemStacks[stackNum].splitStack(amount);//Берем часть стака и копируем в новый обьект
            if (InvItemStacks[stackNum].stackSize == 0)//Если в стаке нечего не осталось
            {
                InvItemStacks[stackNum] = null;//Очищяем стак
            }
            markDirty();//Маркируем что ентити изменился
            return itemstack1;//Возврощем часть стака
        } else {
            return null;//Возврощяем пустоту
        }
    }

    public boolean CanRemoveBucketLiquid(){
        return FluidLevel>=1000;
    }

    public void RemoveBuckedLiquid()
    {
        FluidLevel-=1000;//Удаляем Ведерко Жидкоси
        markDirty();//Маркируем что ентити изменился
    }

    public boolean CanAddBucketLiquid(){
        return FluidLevel<=(getCapacity()-1000);
    }

    public void AddBuckedLiquid()
    {
        FluidLevel+=1000;//Добовляем Ведерко Жидкости
        markDirty();//Маркируем что ентити изменился
    }


    //Получение имени инвентаря
    @Override
    public String getInventoryName() {
        return "Matter Generator";
    }

    // Получаем мксимальное количество прдметов в стаке
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    //Получаем количество стаков в инвентаре
    @Override
    public int getSizeInventory() {

        return this.InvItemStacks.length;
    }

    //Получаем стак в заданном слоте
    @Override
    public ItemStack getStackInSlot(int slotNum) {
        return this.InvItemStacks[slotNum];
    }

    //Получаем стак при закрытии
    @Override
    public ItemStack getStackInSlotOnClosing(int slotNum) {
        if (this.InvItemStacks[slotNum] != null) {
            ItemStack itemstack = this.InvItemStacks[slotNum];
            this.InvItemStacks[slotNum] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    // Имеет ли инвентарь свое название
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    //Подходит ли стак в определенный слот
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        //Только то что можем сжечь
        //TODO Надо сделать таблицу ценностей предметов
        return MatterValueCalculator.GetMatterValue(stack)>0;
        //return getItemBurnTime(stack) > 0;
    }

    //Можно ли использовать игроком?
    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return worldObj == null ||
                (worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
                        entityplayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D);
    }

    //При открытии инвентаря
    @Override
    public void openInventory() {
        //Нечего не делаем метод не вызывается ?????
    }

    //Установить Предметы в слот
    @Override
    public void setInventorySlotContents(int slotNum, ItemStack itemStack) {
        this.InvItemStacks[slotNum] = itemStack; //Копируем предметы в слот

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) //Если предметов сильно много
        {
            itemStack.stackSize = this.getInventoryStackLimit();//Обрезаем по максимуму
        }
    }

    //Событие обновления
    public void updateEntity() {
        if (ProgressMax > 0) {//Если процесс идет
            int delta = ProgressMax - Progress;//Считаем сколько можем преобразовать
            if ((getCapacity() - FluidLevel) > 50) {//Если есть место для преобразования
                if (delta > 50) {//Проверяем можем ли преобразовать 50
                    FluidLevel += 50;
                    Progress += 50;
                    markDirty();//Помечаем что обьект изменился
                } else {//Иначе преобразовываем остатки
                    FluidLevel += delta;
                    Progress += delta;
                    markDirty();//Помечаем что обьект изменился
                }
            }
        }
        if (Progress >= ProgressMax && ProgressMax > 0) {//Проверяем что процесс закончился
            ProgressMax = 0;
            Progress = 0;
            markDirty();//Помечаем что обьект изменился
        }
        if (ProgressMax == 0 && InvItemStacks[0] != null) {//Если процесса нет и есть стак
            if (InvItemStacks[0].stackSize > 0 && MatterValueCalculator.GetMatterValue(InvItemStacks[0]) > 0) {//Если есть стак и он прегоден для преобразования
                ProgressMax = MatterValueCalculator.GetMatterValue(InvItemStacks[0]);//Расчитываем сколько материи есть в предмете
                InvItemStacks[0].stackSize--;//Удаляем один предмет
                if (InvItemStacks[0].stackSize < 1) {//Если предметов больше нет то удаляем стак
                    InvItemStacks[0] = null;
                }
                markDirty();//Помечаем что обьект изменился
            }
        }

    }

    //Чтение состояния ентити
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);//читаем из NBT Данные обьекта
        NBTTagList nbttaglist = nbtTagCompound.getTagList("Items", Constants.NBT.TAG_COMPOUND); //Извлекаем Инвентарь
        InvItemStacks = new ItemStack[getSizeInventory()]; //Создаем пустой инвентарь
        for (int i = 0; i < nbttaglist.tagCount(); i++) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 0xff;
            if (j >= 0 && j < InvItemStacks.length) {
                InvItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        FluidLevel = nbtTagCompound.getInteger("FluidLevel");//Извлекаем уровень жидкости
        Progress = nbtTagCompound.getInteger("Progress");//Извлекаем текущий прогресс
        ProgressMax = nbtTagCompound.getInteger("ProgressMax");//Извлекаем Максимум прогресса
    }

    //Запись состояния
    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < InvItemStacks.length; i++) {
            if (InvItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                InvItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbtTagCompound.setTag("Items", nbttaglist);
        nbtTagCompound.setInteger("FluidLevel", FluidLevel);
        nbtTagCompound.setInteger("Progress", Progress);
        nbtTagCompound.setInteger("ProgressMax", ProgressMax);
    }

    //Имя инвентаря локализовано
    public boolean isInvNameLocalized() {
        return true;
    }
    //Обработка жидкостей

    //Слив Жидкости
    @Override
    public FluidStack drain(int amount, boolean doDrain) {
        if (FluidLevel > 0 && doDrain) {
            if (FluidLevel >= amount) {
                FluidStack fluidStack = FluidRegistry.getFluidStack("liquidmatter", amount);
                FluidLevel -= amount;
                markDirty();
                return fluidStack;
            } else {
                FluidStack fluidStack = FluidRegistry.getFluidStack("liquidmatter", FluidLevel);
                FluidLevel -= FluidLevel;
                markDirty();
                return fluidStack;
            }
        }
        return null;
    }

    //Залив жидкости
    @Override
    public int fill(FluidStack fluidStack, boolean doFill) {
        if (fluidStack.getFluidID() == getFluid().getFluidID() && doFill) {
            if (fluidStack.amount > (getCapacity() - FluidLevel)) {
                FluidLevel += fluidStack.amount;
                markDirty();
                return fluidStack.amount;
            } else {
                FluidLevel += getCapacity() - FluidLevel;
                markDirty();
                return getCapacity() - FluidLevel;
            }
        }
        return 0;
    }

    //Получить обьем
    @Override
    public int getCapacity() {
        return 10000;
    }

    //Получить состав
    @Override
    public FluidStack getFluid() {
        return FluidRegistry.getFluidStack("liquidmatter", FluidLevel);
    }

    //Получить велечену остатка жидкости
    @Override
    public int getFluidAmount() {
        return FluidLevel;
    }

    //Получить информацию о баке
    @Override
    public FluidTankInfo getInfo() {
        return new FluidTankInfo(getFluid(), getCapacity());
    }

    //Можно ли сливать
    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return fluid.getID() == getFluid().getFluidID();
    }

    //Можно ли наполнять
    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return fluid.getID() == getFluid().getFluidID();
    }

    //Слив конкретного количества конкретной жидкости
    @Override
    public FluidStack drain(ForgeDirection from, FluidStack fluidStack, boolean doDrain) {

        if (FluidLevel > 0) {
            if (FluidLevel >= fluidStack.amount) {
                FluidStack fluidStack1 = FluidRegistry.getFluidStack("liquidmatter", fluidStack.amount);
                if (doDrain) {
                    FluidLevel -= fluidStack.amount;
                    markDirty();
                }
                return fluidStack1;
            } else {
                FluidStack fluidStack1 = FluidRegistry.getFluidStack("liquidmatter", FluidLevel);
                if (doDrain) {
                    FluidLevel -= fluidStack.amount;
                    markDirty();
                }
                return fluidStack1;
            }
        }
        return null;
    }

    //Слив любой жидкости с определеной стороны
    @Override
    public FluidStack drain(ForgeDirection from, int amount, boolean doDrain) {

        //amount = 1000;

        FluidStack fluidStack;
        if (FluidLevel > 0) {
            if (FluidLevel >= amount) {
                fluidStack = FluidRegistry.getFluidStack("liquidmatter", amount);
                return fluidStack;
            } else {
                fluidStack = FluidRegistry.getFluidStack("liquidmatter", FluidLevel);
                return fluidStack;
            }
        }
        return null;

    }

    //Заливка конкретной жидкости
    @Override
    public int fill(ForgeDirection from, FluidStack fluidStack, boolean doFill) {

        if (fluidStack.getFluidID() == getFluid().getFluidID() && doFill) {
            if (fluidStack.amount + FluidLevel <= getCapacity()) {
                FluidLevel += fluidStack.amount;
                markDirty();
                return fluidStack.amount;
            } else {
                FluidLevel += getCapacity() - FluidLevel;
                markDirty();
                return getCapacity() - FluidLevel;
            }
        }
        return 0;
    }

    //Получить информацию о всех житкостях в контейнере
    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        FluidTankInfo[] fluidTankInfos = new FluidTankInfo[1];
        fluidTankInfos[0] = new FluidTankInfo(getFluid(), getCapacity());
        return fluidTankInfos;
    }
}
