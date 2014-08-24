package com.gl237.Iexchange;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class SFLEGeneratorMachieTileEntity extends TileEntity implements IInventory
{

	private ItemStack[] InvItemStacks;
	
	public SFLEGeneratorMachieTileEntity()
	{
		InvItemStacks = new ItemStack[1];
	}
	
	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.InvItemStacks[i] != null)
        {
                ItemStack itemstack;

                if (this.InvItemStacks[i].stackSize <= j)
                {
                        itemstack = this.InvItemStacks[i];
                        this.InvItemStacks[i] = null;
                        return itemstack;
                }
                else
                {
                        itemstack = this.InvItemStacks[i].splitStack(j);

                        if (this.InvItemStacks[i].stackSize == 0)
                        {
                                this.InvItemStacks[i] = null;
                        }

                        return itemstack;
                }
        }
        else
        {
                return null;
        }
	}

	@Override
	public String getInventoryName() {
		return "Nano Disasembler";
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSizeInventory() {
		
		return this.InvItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.InvItemStacks[i];
	}

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

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		return true;
	}

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

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.InvItemStacks[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
        {
        	itemstack.stackSize = this.getInventoryStackLimit();
        }
	}
	
	public void updateEntity()
    {
		 
    }
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
	        //facing = nbttagcompound.getByte("facing");
	       
	    }

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
	        //nbttagcompound.setByte("facing", (byte)facing);
	    }

		public boolean isInvNameLocalized() {
			// TODO Auto-generated method stub
			return true;
		}
		 


}
