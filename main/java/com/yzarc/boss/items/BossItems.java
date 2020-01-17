package com.yzarc.boss.items;

import com.yzarc.boss.ClientProxy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class BossItems 
{
	public static Item noHoe;
	public static final void init()
	{
		GameRegistry.registerItem(noHoe = new CreateItems("nohoe", ClientProxy.bossModTab, "diamond_hoe"), "NoHoe");
	}
}
