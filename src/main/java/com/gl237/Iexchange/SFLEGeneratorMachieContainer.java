// SFLEGeneratorMachieContainer.java
// Container SFLEGenerator
// Контейнер SFLE Генератора
// gl237man

package com.gl237.Iexchange;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import static net.minecraft.tileentity.TileEntityFurnace.getItemBurnTime;

public class SFLEGeneratorMachieContainer extends Container {

	private SFLEGeneratorMachieTileEntity machieTileEntity;//Енитити SFLE Генератора

    private int lastProgress;
    private int lastFluidLevel;

	public SFLEGeneratorMachieContainer(InventoryPlayer inventoryPlayer, SFLEGeneratorMachieTileEntity tileEntity)
	{
		this.machieTileEntity = tileEntity; //Присваеваем Ентити
		//Добовляем слоты контейнера
        	this.addSlotToContainer(new Slot(tileEntity, 0, 52, 41));
        	
        	//Добовляем слоты инвентаря игрока
        	int i;

        	for (i = 0; i < 3; ++i)
        	{
                	for (int j = 0; j < 9; ++j)
                	{
                        	this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                	}
        	}

        	for (i = 0; i < 9; ++i)
        	{
                	this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        	}
	}

    //Добовляем прогрессбары
    public void addCraftingToCrafters(ICrafting iCrafting)
    {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.machieTileEntity.Progress);
        iCrafting.sendProgressBarUpdate(this, 1, this.machieTileEntity.FluidLevel);
    }


    //Проверяем изменение прогресс баров
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastProgress != this.machieTileEntity.Progress)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.machieTileEntity.Progress);
            }

            if (this.lastFluidLevel != this.machieTileEntity.FluidLevel)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.machieTileEntity.FluidLevel);
            }

        }

        this.lastProgress = this.machieTileEntity.Progress;
        this.lastFluidLevel = this.machieTileEntity.FluidLevel;

    }

    //обновляем состояние прогресс баров
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int parNum, int parValue)
    {
        if (parNum == 0)
        {
            this.machieTileEntity.Progress = parValue;
        }

        if (parNum == 1)
        {
            this.machieTileEntity.FluidLevel = parValue;
        }
    }


	 @Override
	 public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)//Оброботка шифтклик!
	 {
	 	int InvSize=1;//Количество слотов инвентаря
	        ItemStack itemstack = null;//Создаем пустой стак
	        Slot slot = (Slot) inventorySlots.get(slotIndex);//Получаем слот по индексу
	        if (slot != null && slot.getHasStack())//Если Слот существует и имеет предметы
	        {

	            ItemStack itemstack1 = slot.getStack();//Получаем предметы из слота в стак
	            itemstack = itemstack1.copy();//Копируем стак

                if (getItemBurnTime(itemstack1) < 1)//Если предмет не топливо
                {
                    return null;
                }

	            if (slotIndex < InvSize)//Если указатель поподает внутрь инвентаря
	            {
	                if (!mergeItemStack(itemstack1, InvSize, inventorySlots.size(), true))//Перемещяем предметы в инвентарь
	                {
	                    return null;//Если не перемистилось Возвращяем пустоту
	                }
	            }

	            else if (!mergeItemStack(itemstack1, 0, InvSize, false))//Прермещяем предметы в контейнер
	            {
	                return null;//Если не перемистилось Возвращяем пустоту
	            }

	            if (itemstack1.stackSize == 0)//Если стак пустой
	            {
	                slot.putStack(null);//Очищяем слот
	            }
	            else
	            {
	                slot.onSlotChanged();//Обновляем слот
	            }
	        }
	        return itemstack;//Возвращяем стак
	    }

	//Возможно ли взаимодействие с игроком
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer)
    {
		return this.machieTileEntity.isUseableByPlayer(entityPlayer);
	}

}
