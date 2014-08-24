package com.gl237.Iexchange;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;


public class MyGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		 TileEntity tileEntity = world.getTileEntity(x, y, z);

         if(tileEntity instanceof SFLEGeneratorMachieTileEntity)
         {
                return new SFLEGeneratorMachieContainer(player.inventory, (SFLEGeneratorMachieTileEntity) tileEntity);
         }
         return null;
		
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

        if(tileEntity instanceof SFLEGeneratorMachieTileEntity)
        {
                 return new SFLEGeneratorMachieGui(player.inventory, (SFLEGeneratorMachieTileEntity) tileEntity);
        }
        return null;
	}
/*
	@Override
	public Object getClientGuiElement(int arg0, EntityPlayer arg1, World arg2,
			int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getServerGuiElement(int arg0, EntityPlayer arg1, World arg2,
			int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}