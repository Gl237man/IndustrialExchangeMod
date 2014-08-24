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
        this.addSlotToContainer(new Slot(TileEntitydisasm, 0, 56, 17));
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
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);
            
            //null checks and checks if the item can be stacked (maxStackSize > 1)
            if (slotObject != null && slotObject.getHasStack()) {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();

                    //merges the item into player inventory since its in the tileEntity
                    if (slot < 1) 
                    {
                    	//return null;
                    	if (!this.mergeItemStack(stackInSlot, 0, 35, false)) {
                                    return null;
                            }
                                            
                    }
                    //places it into the tileEntity is possible since its in the player inventory
                    else if (!this.mergeItemStack(stackInSlot, 0, 1, true)) {
                            return null;
                    }

                    if (stackInSlot.stackSize == 0) {
                            slotObject.putStack(null);
                    } else {
                            slotObject.onSlotChanged();
                    }

                    if (stackInSlot.stackSize == stack.stackSize) {
                            return null;
                    }
                    slotObject.onPickupFromSlot(player, stackInSlot);
            }
            return stack;
            
    }

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		
		return this.Mesh.isUseableByPlayer(entityplayer);
	}

}
