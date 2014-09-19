// LEnergyFluidBlock.java
// Block LEnergyFluid
// Блок жидкой энергии
// gl237man

package com.gl237.Iexchange;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class LEnergyFluidBlock extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon; //Иконка стоячей жидкости
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon; //Иконка текущей жидкости

    public LEnergyFluidBlock(Fluid fluid, Material material) {
        super(fluid, material);
        setCreativeTab(IexchangeMod.IECreativeTab);//Добовление в креатив таб
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1) ? stillIcon : flowingIcon; //Возращяем нужную иконку
    }

    //Регистрируем иконки
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon("iexchangemod:LEnergy_still");
        flowingIcon = register.registerIcon("iexchangemod:LEnergy_flow");
    }

    //Определяем поведение замены блока
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.displaceIfPossible(world, x, y, z);
    }

}
