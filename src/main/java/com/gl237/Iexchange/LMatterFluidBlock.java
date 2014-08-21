package com.gl237.Iexchange;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class LMatterFluidBlock extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon; //Иконка стоячей жидкости
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon; //Иконка текущей жидкости
    
    public LMatterFluidBlock(Fluid fluid, Material material) {
            super(fluid, material);
            setCreativeTab(CreativeTabs.tabMisc);//Добовление во вкладку креатива
    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;//Если верх или низ то стоячая жидкость если бок то текущая
    }
    
    //Регистрация иконок жидкостей
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon("iexchangemod:LMatter_still");
            flowingIcon = register.registerIcon("iexchangemod:LMatter_flow");
    }
    
    //Возможность замены другой жидкости текущей
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
    
}