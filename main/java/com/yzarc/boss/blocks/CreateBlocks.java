package com.yzarc.boss.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.yzarc.boss.BossMain;

public class CreateBlocks extends Block
{
	protected CreateBlocks(String unlocalizedName, Material material, float hardness, float lightlevel)
	{
		super(material);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(BossMain.MODID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(hardness);
        this.setResistance(6.0F);
        this.setLightLevel(lightlevel);
        this.setHarvestLevel("pickaxe", 3);
        this.setStepSound(soundTypeMetal);
	}
}
