package com.yzarc.boss.blocks;

import com.yzarc.boss.BossMain;
import com.yzarc.boss.ClientProxy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BossBlocks 
{
    public static Block test;
    public static Block BlockSlimeTrail;
    public static final void init() 
    {
    	GameRegistry.registerBlock(test = new CreateBlocks("test", Material.cake, ClientProxy.bossModTab, 2.0F, 6.0F, 1.0F, "pickaxe", 3, Block.soundTypeGravel), "test_block");
    	GameRegistry.registerBlock(BlockSlimeTrail = new BlockSlimeTrail(), "slime_trail");
    }
    
}
