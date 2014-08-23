package com.gl237.Iexchange;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IECreativeTab extends CreativeTabs {

	public IECreativeTab(int TabID, String TabName) {
		super(TabID, TabName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(IexchangeMod.lEnergyBucketItem,1).getItem();
	}

	public String getTranslatedTabLabel()
	{
		return "IExchange";
	}
}
