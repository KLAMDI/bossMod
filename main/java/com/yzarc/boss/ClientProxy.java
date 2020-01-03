package com.yzarc.boss;

import com.yzarc.boss.entity.EntityBlob;
import com.yzarc.boss.entity.ModelBlob;
import com.yzarc.boss.entity.RenderBlob;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy 
{
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
		RenderingRegistry.registerEntityRenderingHandler(EntityBlob.class, new RenderBlob(new ModelBlob(), 0.5F));
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
	}

}
