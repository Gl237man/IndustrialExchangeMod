// SFLEGeneratorMachieContainer.java
// Container SFLEGenerator
// Контейнер SFLE Генератора
// gl237man

package com.gl237.Iexchange;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SFLEGeneratorMachieContainer extends Container {

	private SFLEGeneratorMachieTileEntity Mesh;//Енитити SFLE Генератора
	
	public SFLEGeneratorMachieContainer(InventoryPlayer par1InventoryPlayer, SFLEGeneratorMachieTileEntity TileEntitydisasm)
	{
		this.Mesh = TileEntitydisasm; //Присваеваем Ентити 
		//Добовляем слоты контейнера
        	this.addSlotToContainer(new Slot(TileEntitydisasm, 0, 52, 41));
        	
        	//Добовляем слоты инвентаря игрока
        	int i;

        	for (i = 0; i < 3; ++i)
        	{
                	for (int j = 0; j < 9; ++j)
                	{
                        	this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                	}
        	}

        	for (i = 0; i < 9; ++i)
        	{
                	this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        	}
	}
			
	 @Override
	 public ItemStack transferStackInSlot(EntityPlayer p, int i)//Оброботка шифтклик!
	 {
	 	int InvSize=1;//Количество слотов инвентаря
	        ItemStack itemstack = null;//Создаем пустой стак
	        Slot slot = (Slot) inventorySlots.get(i);//Получаем слот по индексу
	        if (slot != null && slot.getHasStack())//Если Слот существует и имеет предметы
	        {
	            ItemStack itemstack1 = slot.getStack();//Получаем предметы из слота в стак
	            itemstack = itemstack1.copy();//Копируем стак
	            
	            if (i < InvSize)//Если указатель поподает внутрь инвентаря
	            {
	                if (!mergeItemStack(itemstack1, InvSize, inventorySlots.size(), true))//Перемещяем предметы в инвентарь
	                {
	                    return null;//Если не перемистилось Возвращяем пустоту
	                }
	            }
	            /*else if (!Filter)//Сдесь будет фильтр того что можно вгружать в слот
	            {
	                return null;
	            }*/
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
	public boolean canInteractWith(EntityPlayer entityplayer) {
		
		return this.Mesh.isUseableByPlayer(entityplayer);
	}

}
