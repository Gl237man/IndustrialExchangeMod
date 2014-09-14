// IECreativeTab.java
// Вкладка в креативие
// gl237man

package com.gl237.Iexchange;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IECreativeTab extends CreativeTabs {

	public IECreativeTab(int TabID, String TabName) {
		super(TabID, TabName);
	}

	//Получение иконки креатив таба
	@Override
	public Item getTabIconItem() {
		return new ItemStack(IexchangeMod.lEnergyBucketItem,1).getItem();
	}
	//Получение названия вкладки
	public String getTranslatedTabLabel()
	{
		return "IExchange";
	}
}
