package com.yzarc.boss.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BossBlocks 
{
    public static Block test;
    public static final void init() 
    {
    	GameRegistry.registerBlock(test = new CreateBlocks("test", Material.cake, CreativeTabs.tabBlock , 10.0F, 6.0F, 1.0F, "pickaxe", 3, Block.soundTypeGravel), "test_block");
    }
    
}
