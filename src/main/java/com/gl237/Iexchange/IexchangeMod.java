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
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.TextureStitchEvent;

@Mod(modid = IexchangeMod.MODID, version = IexchangeMod.VERSION)
public class IexchangeMod
{
    public static final String MODID = "industrialexchange";
    public static final String VERSION = "0.1";
    //Проверка
    public Fluid LEnergyFluid;
    public Fluid LMatterFluid;
    //Ðåãèñòðàöèÿ áëîêîâ æèäêîñòè
    public Block lEnergyFluidBlock;
    public Block lMatterFluidBlock;
    //Ðåãåñòðàöèÿ âåäåðîê))
    public Item lEnergyBucketItem;
    public Item lMatterBucketItem;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        // System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    	
    	InitFuilds();
    	
    }
    //Èíèöèàëèçàöèÿ æèäêîñòåé
    private void InitFuilds()
    {
    	
    	LEnergyFluid = new Fluid("LiquidEnergy");
        LMatterFluid = new Fluid("LiquidMatter");
    	
    	LEnergyFluid.setLuminosity(15); //ßðêîñòü æèäêîñòè
    	LEnergyFluid.setViscosity(500); //Òåêó÷åñòü æèäêîñòè
    	
    	LMatterFluid.setLuminosity(1); //ßðêîñòü æèäêîñòè
    	LMatterFluid.setViscosity(7000); //Òåêó÷åñòü æèäêîñòè
    	
    	//Ðåãèñòðàöèÿ æèäêîñòè â ðååñòðå æèäêîñòåé
    	FluidRegistry.registerFluid(LEnergyFluid);
    	FluidRegistry.registerFluid(LMatterFluid);
    	
    	//Îáÿâëåíèå áëîêîâ æèäêîñòåé
    	lEnergyFluidBlock = new LEnergyFluidBlock(LEnergyFluid, Material.water).setBlockName("LEnergyFluidB");
    	lMatterFluidBlock = new LMatterFluidBlock(LMatterFluid, Material.water).setBlockName("LMatterFluidB");
    	
    	//Äîáîâëåíèå áëîêîâ æèäêîñòåé â ðååñòð æèäêîñòåé
    	GameRegistry.registerBlock(lEnergyFluidBlock, MODID + "_" + lEnergyFluidBlock.getUnlocalizedName());
    	GameRegistry.registerBlock(lMatterFluidBlock, MODID + "_" + lMatterFluidBlock.getUnlocalizedName());
    	
    	//Óñòàíîâêà èìåíè æèäêîñòåé?
    	LEnergyFluid.setUnlocalizedName(lEnergyFluidBlock.getUnlocalizedName());
    	LMatterFluid.setUnlocalizedName(lMatterFluidBlock.getUnlocalizedName());
    	//Èíèöèàëèçàöèÿ âåäåð ñ æèäêîñòüþ 
    	
    	lEnergyBucketItem = new LEnergyBucketItem(lEnergyFluidBlock);
    	lMatterBucketItem = new LEnergyBucketItem(lMatterFluidBlock);
    	
    	lEnergyBucketItem.setUnlocalizedName("lEnergyBucketItem").setContainerItem(Items.bucket);
    	lMatterBucketItem.setUnlocalizedName("lMatterBucketItem").setContainerItem(Items.bucket);
    	
    	GameRegistry.registerItem(lEnergyBucketItem, "lEnergyBucketItem");
    	GameRegistry.registerItem(lMatterBucketItem, "lMatterBucketItem");
    	
    	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidenergy", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(lEnergyBucketItem), new ItemStack(Items.bucket));
    	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidmatter", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(lMatterBucketItem), new ItemStack(Items.bucket));
    	
    }
    //Dont Check
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureHook(TextureStitchEvent.Post event) 
    {
	if (event.map.getTextureType() == 0) 
	{
		LEnergyFluid.setIcons(lEnergyFluidBlock.getBlockTextureFromSide(1), lEnergyFluidBlock.getBlockTextureFromSide(2));
		LMatterFluid.setIcons(lMatterFluidBlock.getBlockTextureFromSide(1), lMatterFluidBlock.getBlockTextureFromSide(2));
	}
    }
    
    
}
