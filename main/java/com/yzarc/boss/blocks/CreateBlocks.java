package com.yzarc.boss.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.yzarc.boss.BossMain;

public class CreateBlocks extends Block
{
	protected CreateBlocks(String unlocalizedName, Material material, CreativeTabs creativetab, float hardness, float resistance, float lightlevel, String harvesttool, int harvestlevel, SoundType stepsound)
	{
		super(material);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(BossMain.MODID + ":" + unlocalizedName);
        this.setCreativeTab(creativetab);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setLightLevel(lightlevel);
        this.setHarvestLevel(harvesttool, harvestlevel);
        this.setStepSound(stepsound);
	}
}