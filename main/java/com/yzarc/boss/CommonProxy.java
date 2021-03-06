package com.yzarc.boss;

import com.yzarc.boss.blocks.BossBlocks;
import com.yzarc.boss.entity.BossEntities;
import com.yzarc.boss.items.BossItems;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent e) 
	{
		BossItems.init();
		BossBlocks.init();
		BossEntities.init();
    }

    public void init(FMLInitializationEvent e) 
    {

    }

    public void postInit(FMLPostInitializationEvent e) 
    {

    }
}
