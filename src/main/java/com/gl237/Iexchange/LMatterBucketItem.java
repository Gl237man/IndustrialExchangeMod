// LMatterBucketItem
// Item LMatterBucket
// Ведро жидкой Маттерии
// gl237man

package com.gl237.Iexchange;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LMatterBucketItem extends ItemBucket {

	private String iconName;
	
	// block это блок жидкости связанный с ведром
	public LMatterBucketItem(Block block) {
	
		this(block, IexchangeMod.IECreativeTab);
	}

	public LMatterBucketItem(Block block, CreativeTabs creativeTab) {
		super(block);
		setContainerItem(Items.bucket);
		setCreativeTab(creativeTab);
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
