package com.gl237.Iexchange;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = IexchangeMod.MODID, version = IexchangeMod.VERSION)
public class IexchangeMod
{
	
	@Instance("IexchangeMod")
	public static IexchangeMod instance;
	
    public static final String MODID = "industrialexchange";
    public static final String VERSION = "0.1";
    //Жидкости
    public Fluid LEnergyFluid;
    public Fluid LMatterFluid;
    //Блоки жидкости
    public static Block lEnergyFluidBlock;
    public static Block lMatterFluidBlock;
    //Ведерки с жидкостью
    public static Item lEnergyBucketItem;
    public static Item lMatterBucketItem;
    //Машины
    public static Block sFLEGeneratorMachieBlock;//Твердотопливный генератор ЖЭ
    
    public static CreativeTabs IECreativeTab = new IECreativeTab(CreativeTabs.getNextID(),"IECreativeTab");
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
	
        // System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    	InitMachines();
    	InitFuilds();
    	MinecraftForge.EVENT_BUS.register(this); 
    }
    //Инициализация машин
    private void InitMachines()
    {
    	sFLEGeneratorMachieBlock = new SFLEGeneratorMachieBlock(Material.iron).setBlockName("sFLEGeneratorMachieBlock");
    	GameRegistry.registerBlock(sFLEGeneratorMachieBlock, MODID + "_" + sFLEGeneratorMachieBlock.getUnlocalizedName());
    	
    	GameRegistry.registerTileEntity(SFLEGeneratorMachieTileEntity.class, "SFLEGeneratorMachieContainer");
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new MyGuiHandler());//Попробовать заменить с this на instance
    	//NetworkRegistry.INSTANCE.registerGuiHandler(this, new MyGuiHandler());
    	//NetworkRegistry.instance().registerGuiHandler(this, new MyGuiHandler());

    }
    //Инициализация жидкосией
    private void InitFuilds()
    {
    	
    	LEnergyFluid = new Fluid("LiquidEnergy");
        LMatterFluid = new Fluid("LiquidMatter");
    	
    	LEnergyFluid.setLuminosity(15); //Светимость
    	LEnergyFluid.setViscosity(500); //Текучесть
    	
    	LMatterFluid.setLuminosity(1); //Светимость
    	LMatterFluid.setViscosity(7000); //Текучесть
    	
    	//Добовляем жидкость в реестр жидкостей
    	FluidRegistry.registerFluid(LEnergyFluid);
    	FluidRegistry.registerFluid(LMatterFluid);
    	
    	//Добовляем блоки жидкости
    	lEnergyFluidBlock = new LEnergyFluidBlock(LEnergyFluid, Material.water).setBlockName("LEnergyFluidB");
    	lMatterFluidBlock = new LMatterFluidBlock(LMatterFluid, Material.water).setBlockName("LMatterFluidB");
    	
    	//Регистрируем блоки жидкости в реестре жидкостей
    	GameRegistry.registerBlock(lEnergyFluidBlock, MODID + "_" + lEnergyFluidBlock.getUnlocalizedName());
    	GameRegistry.registerBlock(lMatterFluidBlock, MODID + "_" + lMatterFluidBlock.getUnlocalizedName());
    	
    	//Устанавливаем имена жидкостей
    	LEnergyFluid.setUnlocalizedName(lEnergyFluidBlock.getUnlocalizedName());
    	LMatterFluid.setUnlocalizedName(lMatterFluidBlock.getUnlocalizedName());
    	//Регистрируем ведерки
    	
    	lEnergyBucketItem = new LEnergyBucketItem(lEnergyFluidBlock);
    	lMatterBucketItem = new LEnergyBucketItem(lMatterFluidBlock);
    	
    	lEnergyBucketItem.setUnlocalizedName("lEnergyBucketItem").setContainerItem(Items.bucket);
    	lMatterBucketItem.setUnlocalizedName("lMatterBucketItem").setContainerItem(Items.bucket);
    	
    	GameRegistry.registerItem(lEnergyBucketItem, "lEnergyBucketItem");
    	GameRegistry.registerItem(lMatterBucketItem, "lMatterBucketItem");
    	
    	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidenergy", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(lEnergyBucketItem), new ItemStack(Items.bucket));
    	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidmatter", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(lMatterBucketItem), new ItemStack(Items.bucket));
    	
    }

    
    //Перехватываем событие получение текстуры для жидкостей
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
