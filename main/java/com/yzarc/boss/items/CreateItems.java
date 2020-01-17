package com.yzarc.boss.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreateItems extends Item
{
	protected CreateItems(String unlocalizedName, CreativeTabs creativetab, String textureName)
	{
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(creativetab);
		this.setTextureName(textureName);
	}
}
