package com.yzarc.boss.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BossBlocks 
{
    public static Block test;
    public static final void init() 
    {
    	GameRegistry.registerBlock(test = new CreateBlocks("test", Material.cake, 10.0F, 1.0F), "test_block");
    }
    
}
