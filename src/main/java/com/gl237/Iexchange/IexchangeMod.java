package com.gl237.Iexchange;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = IexchangeMod.MODID, version = IexchangeMod.VERSION)
public class IexchangeMod
{
    public static final String MODID = "industrialexchange";
    public static final String VERSION = "0.1";
    //Регистрация жидкостей
    public Fluid LEnergyFluid;
    public Fluid LMatterFluid;
    //Регистрация блоков жидкости
    public Block lEnergyFluidBlock;
    public Block lMatterFluidBlock;
    //Регестрация ведерок))
    public Item lEnergyBucketItem;
    public Item lMatterBucketItem;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        // System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    	
    	InitFuilds();
    	
    }
    //Инициализация жидкостей
    private void InitFuilds()
    {
    	
    	LEnergyFluid = new Fluid("LiquidEnergy");
        LMatterFluid = new Fluid("LiquidMatter");
    	
    	LEnergyFluid.setLuminosity(15); //Яркость жидкости
    	LEnergyFluid.setViscosity(500); //Текучесть жидкости
    	
    	LMatterFluid.setLuminosity(1); //Яркость жидкости
    	LMatterFluid.setViscosity(7000); //Текучесть жидкости
    	
    	//Регистрация жидкости в реестре жидкостей
    	FluidRegistry.registerFluid(LEnergyFluid);
    	FluidRegistry.registerFluid(LMatterFluid);
    	
    	//Обявление блоков жидкостей
    	lEnergyFluidBlock = new LEnergyFluidBlock(LEnergyFluid, Material.water).setBlockName("LEnergyFluidB");
    	lMatterFluidBlock = new LMatterFluidBlock(LMatterFluid, Material.water).setBlockName("LMatterFluidB");
    	
    	//Добовление блоков жидкостей в реестр жидкостей
    	GameRegistry.registerBlock(lEnergyFluidBlock, MODID + "_" + lEnergyFluidBlock.getUnlocalizedName());
    	GameRegistry.registerBlock(lMatterFluidBlock, MODID + "_" + lMatterFluidBlock.getUnlocalizedName());
    	
    	//Установка имени жидкостей?
    	LEnergyFluid.setUnlocalizedName(lEnergyFluidBlock.getUnlocalizedName());
    	LMatterFluid.setUnlocalizedName(lMatterFluidBlock.getUnlocalizedName());
    	//Инициализация ведер с жидкостью 
    	
    	lEnergyBucketItem = new LEnergyBucketItem(lEnergyFluidBlock);
    	lMatterBucketItem = new LEnergyBucketItem(lMatterFluidBlock);
    	
    	lEnergyBucketItem.setUnlocalizedName("lEnergyBucketItem").setContainerItem(Items.bucket);
    	lMatterBucketItem.setUnlocalizedName("lMatterBucketItem").setContainerItem(Items.bucket);
    	
    	GameRegistry.registerItem(lEnergyBucketItem, "lEnergyBucketItem");
    	GameRegistry.registerItem(lMatterBucketItem, "lMatterBucketItem");
    	
    	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidenergy", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(lEnergyBucketItem), new ItemStack(Items.bucket));
    	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidmatter", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(lMatterBucketItem), new ItemStack(Items.bucket));
    	
    }
    
}
