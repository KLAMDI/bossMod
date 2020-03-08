package com.yzarc.boss.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLogic;

public class BossMaterials extends Material {
	
	public static final Material slime = (new Material(MapColor.foliageColor));
   
	/** The color index used to draw the blocks of this material on maps. */
    private final MapColor materialMapColor;
	
	public BossMaterials(MapColor p_i2116_1_) {
		super(p_i2116_1_);
		this.materialMapColor = p_i2116_1_;
	}
	
    public MapColor getMaterialMapColor()
    {
        return this.materialMapColor;
    }

}
