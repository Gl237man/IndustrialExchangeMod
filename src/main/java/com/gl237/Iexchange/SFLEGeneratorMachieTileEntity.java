// SFLEGeneratorMachieTileEntity.java
// TileEntity SFLEGenerator
// Ентити SFLE Генератора
// gl237man

package com.gl237.Iexchange;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public class SFLEGeneratorMachieTileEntity extends TileEntity implements IInventory, IFluidTank ,IFluidHandler
{

	private ItemStack[] InvItemStacks;//Предметы в контейнере
	private int FluidLevel;
	public SFLEGeneratorMachieTileEntity()
	{
		super();
		InvItemStacks = new ItemStack[1];//Создаем пустой список предметов
	}
	//Событие при закрытии инвентаря
	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
	}
	
	//Получение предметов из инвентаря i номер стака j Количество
	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (InvItemStacks[i] != null)//Если слот не пуст
        	{
            		if (InvItemStacks[i].stackSize <= j)//Если текущее количество меньше или равно запрашиваемому
            		{
                		ItemStack itemstack = InvItemStacks[i];//Берем копию всех предметов
                		InvItemStacks[i] = null;//Очищяем слот
                		markDirty();//Маркируем что ентити изменился
                		return itemstack;//Возвращяем стак
            		}
            		ItemStack itemstack1 = InvItemStacks[i].splitStack(j);//Берем часть стака и копируем в новый обьект
            		if (InvItemStacks[i].stackSize == 0)//Если в стаке нечего не осталось
            		{
            			InvItemStacks[i] = null;//Очищяем стак
            		}
            		markDirty();//Маркируем что ентити изменился
            		return itemstack1;//Возврощем часть стака
        	}
        	else
        	{
            		return null;//Возврощяем пустоту
        	}
	}
	
	//Получение имени инвентаря
	@Override
	public String getInventoryName() {
		return "SFLE Generator";
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
	public ItemStack getStackInSlot(int i) {
		return this.InvItemStacks[i];
	}
	//Получаем стак при закрытии
	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.InvItemStacks[i] != null)
        	{
                	ItemStack itemstack = this.InvItemStacks[i];
                	this.InvItemStacks[i] = null;
                	return itemstack;
        	}
        	else
        	{
                	return null;
        	}
	}

	// Имеет ли инвентарь свое название
	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return true;
	}

	//Подходит ли стак в определенный слот
	@Override
	public boolean isItemValidForSlot(int arg0, ItemStack arg1) {
		// TODO Надо получать только топливо
		return true;
	}
	
	//Можно ли использовать игроком?
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		if (worldObj == null)
	        {
	            return true;
	        }
	        if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
	        {
	            return false;
	        }
	        return entityplayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}

	//При открытии инвентаря
	@Override
	public void openInventory() {
		FluidLevel = 5000;
		// TODO Auto-generated method stub
	}
	
	//Установить Предметы в слот
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) 
	{
		this.InvItemStacks[i] = itemstack; //Копируем предметы в слот

        	if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) //Если предметов сильно много
        	{
        		itemstack.stackSize = this.getInventoryStackLimit();//Обрезаем по максимуму
        	}
	}
	
	//Сдесь будет событие обновления 
	public void updateEntity()
    	{
		 
    	}
    	
    	//Чтение состояния ентити
	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readFromNBT(nbttagcompound);
		NBTTagList nbttaglist = nbttagcompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		InvItemStacks = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 0xff;
			if (j >= 0 && j < InvItemStacks.length)
			{
				InvItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
		FluidLevel = nbttagcompound.getInteger("FluidLevel");
		//facing = nbttagcompound.getByte("facing");
	       
	}
	
	//Запись состояния
	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeToNBT(nbttagcompound);
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < InvItemStacks.length; i++)
		{
			if (InvItemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				InvItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
	        nbttagcompound.setTag("Items", nbttaglist);
	        nbttagcompound.setInteger("FluidLevel", FluidLevel);
	        //nbttagcompound.setByte("facing", (byte)facing);
	}

	//Имя инвентаря локализовано
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return true;
	}
	//Обработка жидкостей
	@Override
	public FluidStack drain(int arg0, boolean arg1) {
		if (FluidLevel>0 && arg1)
		{
			if (FluidLevel>=arg0)
			{
				FluidStack f = FluidRegistry.getFluidStack("liquidenergy", arg0);
				FluidLevel-=arg0;
				markDirty();
				return f;
			}
			else
			{
				FluidStack f = FluidRegistry.getFluidStack("liquidenergy", FluidLevel);
				FluidLevel-=FluidLevel;
				markDirty();
				return f;
			}
		}
		return null;
	}
	
	@Override
	public int fill(FluidStack arg0, boolean arg1) {
		if (arg0.fluidID == getFluid().fluidID && arg1)
		{
			if (arg0.amount > (getCapacity()-FluidLevel))
			{
				FluidLevel+=arg0.amount;
				markDirty();
				return arg0.amount;
			}
			else
			{
				FluidLevel+=getCapacity()-FluidLevel;
				markDirty();
				return getCapacity()-FluidLevel;
			}
		}
		return 0;
	}
	
	@Override
	public int getCapacity() {
		return 10000;
	}
	
	@Override
	public FluidStack getFluid() {
		return FluidRegistry.getFluidStack("liquidenergy", 1000);
	}
	@Override
	public int getFluidAmount() {
		return FluidLevel;
	}
	@Override
	public FluidTankInfo getInfo() {
		return new FluidTankInfo(getFluid(), 10000);
	}
	@Override
	public boolean canDrain(ForgeDirection arg0, Fluid arg1) {
		return arg1.getID() == getFluid().fluidID;
	}
	@Override
	public boolean canFill(ForgeDirection arg0, Fluid arg1) {
		return arg1.getID() == getFluid().fluidID;
	}
	@Override
	public FluidStack drain(ForgeDirection arg0, FluidStack arg1, boolean arg2) {
		
		if (FluidLevel>0 && arg2)
		{
			if (FluidLevel>=arg1.amount)
			{
				FluidStack f = FluidRegistry.getFluidStack("liquidenergy", arg1.amount);
				FluidLevel-=arg1.amount;
				markDirty();
				return f;
			}
			else
			{
				FluidStack f = FluidRegistry.getFluidStack("liquidenergy", FluidLevel);
				FluidLevel-=FluidLevel;
				markDirty();
				return f;
			}
		}
		return null;
	}
	@Override
	public FluidStack drain(ForgeDirection arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		//return FluidRegistry.getFluidStack("liquidenergy", arg1);
		//return null;
		
		if (FluidLevel>0)
		{
			if (FluidLevel>=arg1)
			{
				FluidStack f = FluidRegistry.getFluidStack("liquidenergy", arg1);
				FluidLevel-=arg1;
				markDirty();
				return f;
			}
			else
			{
				FluidStack f = FluidRegistry.getFluidStack("liquidenergy", FluidLevel);
				FluidLevel-=FluidLevel;
				markDirty();
				return f;
			}
		}
		return null;
		
	}
	@Override
	public int fill(ForgeDirection arg0, FluidStack arg1, boolean arg2) {
		
		if (arg1.fluidID == getFluid().fluidID && arg2)
		{
			if (arg1.amount + FluidLevel <= getCapacity())
			{
				FluidLevel+=arg1.amount;
				markDirty();
				return arg1.amount;
			}
			else
			{
				FluidLevel+=getCapacity()-FluidLevel;
				markDirty();
				return getCapacity()-FluidLevel;
			}
		}
		return 0;
	}
	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection arg0) {
		FluidTankInfo[] fm = new FluidTankInfo[1];
		fm[0] = new FluidTankInfo(getFluid(), 10000);
		return fm;
	}
	 


}
