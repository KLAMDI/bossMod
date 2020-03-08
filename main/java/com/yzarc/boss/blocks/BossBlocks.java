package com.yzarc.boss.blocks;

import com.yzarc.boss.BossMain;
import com.yzarc.boss.ClientProxy;
import com.yzarc.boss.items.ItemSlimeTrail;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class BossBlocks extends Blocks
{
    public static Block test;
    public static Block slime_trail;
    public static final void init() 
    {
    	GameRegistry.registerBlock(test = new CreateBlocks("test", Material.cake, ClientProxy.bossModTab, 2.0F, 6.0F, 1.0F, "pickaxe", 3, Block.soundTypeGravel), "test_block");
    	GameRegistry.registerBlock(slime_trail = new BlockSlimeTrail("slime_trail", ClientProxy.bossModTab), ItemSlimeTrail.class, "slime_trail_block");
    }
    
}
