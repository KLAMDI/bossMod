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
	public ModelRenderer coreLDown1Center;
	public ModelRenderer coreLDown2Center;
	public ModelRenderer coreLDown3Center;
	public ModelRenderer coreLDown4Center;
	public ModelRenderer coreLUp1Center;
	public ModelRenderer coreLUp2Center;
	public ModelRenderer coreLUp3Center;
	public ModelRenderer coreLUp4Center;
	public ModelRenderer coreRDown1Center;
	public ModelRenderer coreRDown2Center;
	public ModelRenderer coreRDown3Center;
	public ModelRenderer coreRDown4Center;
	public ModelRenderer coreRUp1Center;
	public ModelRenderer coreRUp2Center;
	public ModelRenderer coreRUp3Center;
	public ModelRenderer coreRUp4Center;
	
	public ModelRenderer[] coreLDown = new ModelRenderer[8];
	
    public ModelBlob()
    {
        this(1.0F);
    }

    public ModelBlob(float scale)
    {
        byte b0 = 4;
        this.core = new ModelRenderer(this, 0, 0);
        this.core.addBox(0.0F, 19.0F, 0.0F, 8, 1, 8, scale);
        this.core.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreLDown1Center = new ModelRenderer(this, 0, 0);
        this.coreLDown1Center.addBox(3.0F, 19.0F, 0.0F, 1, 1, 12, scale);
        this.coreLDown1Center.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreLDown2Center = new ModelRenderer(this, 0, 0);
        this.coreLDown2Center.addBox(2.0F, 19.0F, 0.0F, 1, 1, 11, scale);
        this.coreLDown2Center.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreLDown3Center = new ModelRenderer(this, 0, 0);
        this.coreLDown3Center.addBox(1.0F, 19.0F, 0.0F, 1, 1, 10, scale);
        this.coreLDown3Center.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreLDown4Center = new ModelRenderer(this, 0, 0);
        this.coreLDown4Center.addBox(0.0F, 19.0F, 0.0F, 1, 1, 9, scale);
        this.coreLDown4Center.setRotationPoint(0.0F, (float)b0, 0.0F);
        
        
        this.coreRDown1Center = new ModelRenderer(this, 0, 0);
        this.coreRDown1Center.addBox(3.0F, 19.0F, -7.0F, 1, 1, 15, scale);
        this.coreRDown1Center.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreRDown2Center = new ModelRenderer(this, 0, 0);
        this.coreRDown2Center.addBox(2.0F, 19.0F, -5.0F, 1, 1, 13, scale);
        this.coreRDown2Center.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreRDown3Center = new ModelRenderer(this, 0, 0);
        this.coreRDown3Center.addBox(1.0F, 19.0F, -3.0F, 1, 1, 11, scale);
        this.coreRDown3Center.setRotationPoint(0.0F, (float)b0, 0.0F);
        this.coreRDown4Center = new ModelRenderer(this, 0, 0);
        this.coreRDown4Center.addBox(0.0F, 19.0F, -1.0F, 1, 1, 9, scale);
        this.coreRDown4Center.setRotationPoint(0.0F, (float)b0, 0.0F);
    }
    
    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float par7)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, par7, p_78088_1_);
        this.core.render(par7);
        this.coreLDown1Center.render(par7);
        this.coreLDown2Center.render(par7);
        this.coreLDown3Center.render(par7);
        this.coreLDown4Center.render(par7);
        this.coreRDown1Center.render(par7);
        this.coreRDown2Center.render(par7);
        this.coreRDown3Center.render(par7);
        this.coreRDown4Center.render(par7);
    }
    
    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float speed, float p_78087_2_, float time, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
    	  this.coreLDown1Center.offsetZ = MathHelper.cos(0.1F*time + 0.1F*speed)*0.05F;
    	  this.coreLDown2Center.offsetZ = MathHelper.cos(0.12F*time + 0.12F*speed)*0.05F;
    	  this.coreLDown3Center.offsetZ = MathHelper.cos(0.2F*time + 0.15F*speed)*0.05F;
    	  this.coreLDown4Center.offsetZ = MathHelper.cos(0.3F*time + 0.2F*speed)*0.05F;
    	  this.coreRDown1Center.offsetZ = MathHelper.cos(0.3F*time + 0.3F*speed + .2F)*0.05F;
    	  this.coreRDown2Center.offsetZ = MathHelper.cos(0.24F*time + 0.23F*speed + .2F)*0.05F;
    	  this.coreRDown3Center.offsetZ = MathHelper.cos(0.12F*time + 0.2F*speed + .2F)*0.05F;
    	  this.coreRDown4Center.offsetZ = MathHelper.cos(0.2F*time + 0.03F*speed + .2F)*0.05F;
    }
    

}
