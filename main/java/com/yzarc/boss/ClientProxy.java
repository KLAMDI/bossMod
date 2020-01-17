package com.yzarc.boss;

import com.yzarc.boss.blocks.BossBlocks;
import com.yzarc.boss.render.BossRenderer;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy 
{
    public static CreativeTabs bossModTab;
    
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		bossModTab = new CreativeTabs("tabBossMod") {
			public Item getTabIconItem() 
			{
				return Item.getItemFromBlock(BossBlocks.test);
			}
		};
		BossRenderer.init();
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

}
