package com.yzarc.boss;

import net.minecraft.init.Blocks;

import com.yzarc.boss.blocks.BossBlocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BossMain.MODID, version = BossMain.VERSION)

public class BossMain
{
    public static final String MODID = "boss";
    public static final String VERSION = "0.1";
    
    @SidedProxy(clientSide="com.yzarc.boss.ClientProxy", serverSide="com.yzarc.boss.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
    	proxy.postInit(event);
    }
}
