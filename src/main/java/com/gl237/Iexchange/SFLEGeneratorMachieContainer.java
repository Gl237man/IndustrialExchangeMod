package com.gl237.Iexchange;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SFLEGeneratorMachieContainer extends Container {

	private SFLEGeneratorMachieTileEntity Mesh;
	
	public SFLEGeneratorMachieContainer(InventoryPlayer par1InventoryPlayer, SFLEGeneratorMachieTileEntity TileEntitydisasm)
	{
		this.Mesh = TileEntitydisasm;
        this.addSlotToContainer(new Slot(TileEntitydisasm, 0, 52, 41));
        //this.addSlotToContainer(new Slot(TileEntitydisasm, 1, 56, 53));
        //this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, TileEntitydisasm, 2, 116, 35));
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
		 	int InvSize=1;
	        ItemStack itemstack = null;
	        Slot slot = (Slot) inventorySlots.get(i);
	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();
	            if (i < InvSize)
	            {
	                if (!mergeItemStack(itemstack1, InvSize, inventorySlots.size(), true))
	                {
	                    return null;
	                }
	            }
	            /*else if (!Filter)
	            {
	                return null;
	            }*/
	            else if (!mergeItemStack(itemstack1, 0, InvSize, false))
	            {
	                return null;
	            }
	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack(null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }
	        }
	        return itemstack;
	    }

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		
		return this.Mesh.isUseableByPlayer(entityplayer);
	}

}
