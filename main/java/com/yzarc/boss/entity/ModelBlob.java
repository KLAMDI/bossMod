package com.yzarc.boss.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelBlob extends ModelBase {
	public ModelRenderer core;
	public ModelRenderer coreLCenter;
	public ModelRenderer coreRCenter;
//	private ModelRenderer field_78133_b;
//	private ModelRenderer body;
//	private ModelRenderer leg1;
//	private ModelRenderer leg2;
//	private ModelRenderer leg3;
//	private ModelRenderer leg4;
	
    public ModelBlob()
    {
        this(0.0F);
    }

    public ModelBlob(float scale)
    {
        byte b0 = 4;
        this.core = new ModelRenderer(this, 0, 0);
        this.core.addBox(0.0F, 19.0F, 0.0F, 8, 1, 8, scale);
        this.core.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreLCenter = new ModelRenderer(this, 0, 0);
        this.coreLCenter.addBox(3.0F, 19.0F, 0.0F, 2, 1, 10, scale);
        this.coreLCenter.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreRCenter = new ModelRenderer(this, 0, 0);
        this.coreRCenter.addBox(3.0F, 19.0F, -2.0F, 2, 1, 10, scale);
        this.coreRCenter.setRotationPoint(0.0F, (float)b0, 0.0F);
    }
    
    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float par7)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, par7, p_78088_1_);
        this.core.render(par7);
        this.coreLCenter.render(par7);
        this.coreRCenter.render(par7);
    }
    
    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float speed, float p_78087_2_, float time, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
    	  this.coreLCenter.offsetZ = MathHelper.cos(0.1F*time + 0.1F*speed)*0.05F;
    	  this.coreRCenter.offsetZ = MathHelper.cos(0.3F*time + 0.3F*speed + .2F)*0.05F;
    }
    

}
