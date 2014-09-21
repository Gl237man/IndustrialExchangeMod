package com.gl237.Iexchange;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by gl237 on 21.09.2014.
 */
public class MatterGeneratorMachineBlock extends BlockContainer{

    //Иконки
    IIcon textureTop;
    IIcon textureButom;
    IIcon textureBack;
    IIcon textureFront;
    IIcon textureLeft;
    IIcon textureRight;

    //Когда блок активирован пользователем
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float what, float these, float are) {

        TileEntity tileEntity = world.getTileEntity(x, y, z);//Получаем ентити блока
        if (tileEntity == null || player.isSneaking()) //Если блока нет или блок сломан
        {
            return false;
        }

        player.openGui(IexchangeMod.instance, 1, world, x, y, z);//Открыть гуи с индексом Один
        return true;
    }

    //Тип предмета при добычи
    @Override
    public Item getItemDropped(int par1, Random random, int par3) {
        return Item.getItemFromBlock(IexchangeMod.matterGeneratorMachieBlock);
    }

    //Количество предметов при добычи
    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    //Создание ентити при установке в мире
    @Override
    public TileEntity createNewTileEntity(World world, int arg1) {
        return new MatterGeneratorMachineTileEntity();
    }

    //Регистрируем иконки
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        textureTop = register.registerIcon("iexchangemod:testBlockTop");
        textureButom = register.registerIcon("iexchangemod:testBlockButom");
        textureBack = register.registerIcon("iexchangemod:testBlockBack");
        textureFront = register.registerIcon("iexchangemod:EGenBlockFront");
        textureLeft = register.registerIcon("iexchangemod:testBlockLeft");
        textureRight = register.registerIcon("iexchangemod:testBlockRight");

    }

    //Установка метадаты в зависимости от положения игрока
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack stack) {
        super.onBlockPlacedBy(world, x, y, z, entityliving, stack);

        ForgeDirection orientation = get2dOrientation(entityliving);
        world.setBlockMetadataWithNotify(x, y, z, orientation.getOpposite().ordinal(), 1);
    }

    //Утилита для получения направления подсмотренно в BuildCraft
    public static ForgeDirection get2dOrientation(EntityLivingBase entityliving) {
        ForgeDirection[] orientationTable = {ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.NORTH, ForgeDirection.EAST};
        int orientationIndex = MathHelper.floor_double((entityliving.rotationYaw + 45.0) / 90.0) & 3;
        return orientationTable[orientationIndex];
    }

    //Получение Иконки в зависимости от положения обьекта
    //ToDo Надо оптимизировать
    @Override
    public IIcon getIcon(int i, int j) {
        switch (j) {
            case 2:
                switch (i) {
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
                switch (i) {
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
                switch (i) {
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
                switch (i) {
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
                switch (i) {
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

    //Вываливание содержимого блока при разрушении
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int hz) {
        Random R = new Random();
        MatterGeneratorMachineTileEntity tileEntity = (MatterGeneratorMachineTileEntity) world.getTileEntity(x, y, z);
        if (tileEntity != null) {
            for (int i1 = 0; i1 < tileEntity.getSizeInventory(); ++i1) {
                ItemStack itemstack = tileEntity.getStackInSlot(i1);

                if (itemstack != null) {
                    float f = R.nextFloat() * 0.8F + 0.1F;
                    float f1 = R.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = R.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem)) {
                        int j1 = R.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize) {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double) ((float) R.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) R.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double) ((float) R.nextGaussian() * f3);

                        if (itemstack.hasTagCompound()) {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                        }
                    }
                }
            }
        }
        super.breakBlock(world, x, y, z, block, hz);
    }


    protected MatterGeneratorMachineBlock(Material material) {
        super(material);
        setCreativeTab(IexchangeMod.IECreativeTab);//Добовление в креатив таб
        this.setHardness(4F);//Установка прочности
        this.setResistance(1F);//Установка Взрывозащищоности
    }


}
