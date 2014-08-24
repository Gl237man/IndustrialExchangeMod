package com.gl237.Iexchange;

import java.util.Random;

import javax.swing.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class SFLEGeneratorMachieBlock extends BlockContainer
{
	IIcon textureTop;
	IIcon textureButom;
	IIcon textureBack;
	IIcon textureFront;
	IIcon textureLeft;
	IIcon textureRight;

	
	
	protected SFLEGeneratorMachieBlock(Material mat) {
		super(mat);
		setCreativeTab(IexchangeMod.IECreativeTab);//Добовление в креатив таб
		this.setHardness(4F);//Установка прочности
		this.setResistance(1F);//Установка Взрывозащищоности
	}

	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                                    EntityPlayer player, int idk, float what, float these, float are) 
	 	{
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) 
            {
               return false;
            }
            player.openGui(IexchangeMod.instance, 0, world, x, y, z);
            //player.openGui(NanoExcange.instance, 0, world, x, y, z);
            return true;
    }

	
	//Тип предмета при добычи
	@Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
		return Item.getItemFromBlock(IexchangeMod.sFLEGeneratorMachieBlock);
    }
	//Количество предметов при добычи
	@Override
	public int quantityDropped(Random par1Random)
	{
	    return 1;
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		// TODO Auto-generated method stub
		return new SFLEGeneratorMachieTileEntity();
	}
	
	//Регистрируем иконки
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) 
    {
		
        textureTop = register.registerIcon("iexchangemod:testBlockTop");
    	textureButom = register.registerIcon("iexchangemod:testBlockButom");
    	textureBack = register.registerIcon("iexchangemod:testBlockBack");
    	textureFront = register.registerIcon("iexchangemod:testBlockFront");;
    	textureLeft = register.registerIcon("iexchangemod:testBlockLeft");
    	textureRight = register.registerIcon("iexchangemod:testBlockRight");
        
	}
	
    //Установка метадаты в зависимости от положения игрока 
    @Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack stack) {
		super.onBlockPlacedBy(world, i, j, k, entityliving, stack);

		ForgeDirection orientation = get2dOrientation(entityliving);

		world.setBlockMetadataWithNotify(i, j, k, orientation.getOpposite().ordinal(), 1);
		
	}
    //Утилита для получения направления подсмотренно в BuildCraft
    public static ForgeDirection get2dOrientation(EntityLivingBase entityliving) {
		ForgeDirection[] orientationTable = { ForgeDirection.SOUTH,
				ForgeDirection.WEST, ForgeDirection.NORTH, ForgeDirection.EAST };
		int orientationIndex = MathHelper.floor_double((entityliving.rotationYaw + 45.0) / 90.0) & 3;
		return orientationTable[orientationIndex];
	}
    
    //Получение Иконки в зависимости от положения обьекта
	@Override
	public IIcon getIcon(int i, int j) {
		switch(j)
		{
		case 2:
			switch (i) 
			{
			case 0:
				return textureButom;
			case 1:
				return textureTop;
			case 2:
				return textureFront;
			case 3:
				return textureBack;
			case 4:
				return textureRight;
			case 5:
				return textureLeft;
			default:
				return textureFront;
			}
			
		case 3:
			switch (i) 
			{
			case 0:
				return textureButom;
			case 1:
				return textureTop;
			case 2:
				return textureBack;
			case 3:
				return textureFront;
			case 4:
				return textureLeft;
			case 5:
				return textureRight;
			default:
				return textureFront;
			}
			
		case 4:
			switch (i) 
			{
			case 0:
				return textureButom;
			case 1:
				return textureTop;
			case 2:
				return textureLeft;
			case 3:
				return textureRight;
			case 4:
				return textureFront;
			case 5:
				return textureBack;
			default:
				return textureFront;
			}
			
		case 5:
			switch (i) 
			{
			case 0:
				return textureButom;
			case 1:
				return textureTop;
			case 2:
				return textureRight;
			case 3:
				return textureLeft;
			case 4:
				return textureBack;
			case 5:
				return textureFront;
			default:
				return textureFront;
			}
			
		default:
			switch (i) 
			{
			case 0:
				return textureButom;
			case 1:
				return textureTop;
			case 2:
				return textureBack;
			case 3:
				return textureFront;
			case 4:
				return textureLeft;
			case 5:
				return textureRight;
			default:
				return textureFront;
			}
		}
		
	}
	
	

}
