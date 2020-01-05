package com.yzarc.boss.render;

import com.yzarc.boss.entity.EntityBlob;
import com.yzarc.boss.model.ModelBlob;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class BossRenderer 
{
	public static void init()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBlob.class, new RenderBlob(new ModelBlob(), 0.5F));
	}
}
