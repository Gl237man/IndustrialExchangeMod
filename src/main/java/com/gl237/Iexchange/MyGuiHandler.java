// MyGuiHandler.java
// Менеджер Графических интерфейсов
// gl237man

package com.gl237.Iexchange;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;


public class MyGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);//Получаем ентити обекта открываемого интерфейса

        if (tileEntity instanceof SFLEGeneratorMachieTileEntity)//Если ентити является SFLE Генераторовм то Возврощяем контейнер
        {
            return new SFLEGeneratorMachieContainer(player.inventory, (SFLEGeneratorMachieTileEntity) tileEntity);
        }
        return null;

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);//Получаем ентити обекта открываемого интерфейса

        if (tileEntity instanceof SFLEGeneratorMachieTileEntity)//Если ентити является SFLE Генераторовм то Возврощяем Гуи
        {
            return new SFLEGeneratorMachieGui(player.inventory, (SFLEGeneratorMachieTileEntity) tileEntity);
        }
        return null;
    }

}
