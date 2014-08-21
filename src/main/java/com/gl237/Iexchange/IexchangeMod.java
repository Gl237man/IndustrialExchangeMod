package com.gl237.Iexchange;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = IexchangeMod.MODID, version = IexchangeMod.VERSION)
public class IexchangeMod
{
    public static final String MODID = "industrialexchange";
    public static final String VERSION = "0.1";
    //Обьявлени жидкостей
    public Fluid LEnergyFluid = new Fluid("LiquidEnergy");
    public Fluid LMatterFluid = new Fluid("LiquidMatter");
    //Обьявление блоков
    public Block lEnergyFluidBlock;
    public Block lMatterFluidBlock;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        // System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    	
    	InitFuilds();
    	
    }
    //Регистрация жидкостей блоков жидкостей и ведерок
    private void InitFuilds()
    {
    	LEnergyFluid.setLuminosity(15); //Светимость жидкости
    	LEnergyFluid.setViscosity(500); //Вязкость жидкости чем меньше тем текучей
    	
    	LMatterFluid.setLuminosity(15); //Светимость жидкости
    	LMatterFluid.setViscosity(500); //Вязкость жидкости чем меньше тем текучей
    	
    	//Регистрация жидкостей в реестре жидкостей
    	FluidRegistry.registerFluid(LEnergyFluid);
    	FluidRegistry.registerFluid(LMatterFluid);
    	
    	//Обявление блоков жидкостей
    	lEnergyFluidBlock = new LEnergyFluidBlock(LEnergyFluid, Material.water).setBlockName("LEnergyFluid");
    	lMatterFluidBlock = new LMatterFluidBlock(LMatterFluid, Material.water).setBlockName("LMatterFluid");
    	
    	//Добовление блоков жидкостей в реестр жидкостей
    	GameRegistry.registerBlock(lEnergyFluidBlock, MODID + "_" + lEnergyFluidBlock.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(lMatterFluidBlock, MODID + "_" + lMatterFluidBlock.getUnlocalizedName().substring(5));
    	
    	//Установка имени жидкостей?
    	LEnergyFluid.setUnlocalizedName(lEnergyFluidBlock.getUnlocalizedName());
    	LMatterFluid.setUnlocalizedName(lMatterFluidBlock.getUnlocalizedName());
    }
    
}
