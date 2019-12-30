package com.yzarc.boss;

import net.minecraft.init.Blocks;

import com.yzarc.boss.blocks.BossBlocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = BossMain.MODID, version = BossMain.VERSION)

public class BossMain
{
    public static final String MODID = "boss";
    public static final String VERSION = "0.1";
    
    @SidedProxy(clientSide="com.bedrockminer.tutorial.ClientProxy", serverSide="com.bedrockminer.tutorial.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preinit(FMLInitializationEvent event)
    {
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.Init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
    	proxy.postInit(event);
    }
}
