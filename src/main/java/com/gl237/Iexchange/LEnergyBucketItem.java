// LEnergyBucketItem.java
// Item LEnergyBucket
// Ведро жидкой энергии
// gl237man

package com.gl237.Iexchange;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class LEnergyBucketItem extends ItemBucket {

	private String iconName;
	
	// block это блок жидкости связанный с ведром
	public LEnergyBucketItem(Block block) {
	
		this(block, IexchangeMod.IECreativeTab);
	}

	public LEnergyBucketItem(Block block, CreativeTabs creativeTab) {
		super(block);
		setContainerItem(Items.bucket);//Указываем что ведроя является контейнером для жидкости
		setCreativeTab(creativeTab);//Указываем вкладку в реативе
	}

	//Регистрируем имя предмета
	@Override
	public Item setUnlocalizedName(String par1Str) {
		iconName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}
	
	//Регистрируем иконку предмета
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("iexchangemod:" + iconName);
	}
	
	
	
}
