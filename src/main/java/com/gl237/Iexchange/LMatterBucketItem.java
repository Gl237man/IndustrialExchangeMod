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
	
	public LMatterBucketItem(Block block) {
	
		this(block, CreativeTabs.tabMisc);
	}

	public LMatterBucketItem(Block block, CreativeTabs creativeTab) {
		super(block);
		setContainerItem(Items.bucket);
		setCreativeTab(creativeTab);
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		iconName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("iexchangemod:" + iconName);
	}
	
	
	
}