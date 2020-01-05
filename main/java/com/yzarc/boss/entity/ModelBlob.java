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
	public ModelRenderer coreBack;
	
	//Goes from top to bottom
	public ModelRenderer[] coreL = new ModelRenderer[16];
	public int coreLlengths[] = {9,10,11,12,13,14,15,17,16,15,14,13,12,11,10,9};
	public float coreLspeeds[] = {0.27F, 0.3F, 0.23F, 0.12F, 0.16F, 0.14F, 0.18F, 0.22F, 0.16F, 0.20F, 0.18F, 0.12F, 0.11F, 0.10F, 0.13F, 0.14F};
	public ModelRenderer[] coreR = new ModelRenderer[16];
	public int coreRlengths[] = {9,11,13,15,16,17,18,19,20,19,18,17,16,13,11,9};
	public float coreRspeeds[] = {0.12F, 0.18F, 0.23F, 0.20F, 0.32F, 0.3F, 0.33F, 0.28F, 0.20F, 0.22F, 0.24F, 0.17F, 0.10F, 0.13F, 0.14F, 0.10F};
	
	public ModelRenderer[] backL = new ModelRenderer[4];
	public int backLlengths[] = {8, 7, 5, 3};
	public float backLspeeds[] = {0.17F, 0.20F, 0.22F, 0.18F};
	
	public ModelRenderer[] backR = new ModelRenderer[4];
	public int backRlengths[] = {8, 6, 4, 2};
	public float backRspeeds[] = {0.27F, 0.23F, 0.22F, 0.14F};
	
	
    public ModelBlob()
    {
        this(1.0F);
    }

    public ModelBlob(float scale)
    {
        byte b0 = 4;
        this.core = new ModelRenderer(this, 0, 0);
        this.core.addBox(0.0F, 19.0F, 0.0F, 16, 1, 16, scale);
        this.core.setRotationPoint(0.0F, (float)b0, 0.0F);
        
        this.coreBack = new ModelRenderer(this, 0, 0);
        this.coreBack.addBox(0.0F, 19.0F, 16.0F, 8, 1, 4, scale);
        this.coreBack.setRotationPoint(0.0F, (float)b0, 0.0F);
        
        for (int i = 0; i < backL.length; i++) {
        	this.backL[i] = new ModelRenderer(this, 0, 0);
        	this.backL[i].addBox(8.0F, 19.0F, 16.0F + (float)i, backLlengths[i], 1, 1, scale);
        	this.backL[i].setRotationPoint(0.0F, (float)b0, 0.0F);
		}
        
        for (int i = 0; i < backR.length; i++) {
        	this.backR[i] = new ModelRenderer(this, 0, 0);
        	this.backR[i].addBox((float)(0.0F - backRlengths[i]), 19.0F, 16.0F + (float)i, backRlengths[i], 1, 1, scale);
        	this.backR[i].setRotationPoint(0.0F, (float)b0, 0.0F);
		}
        
        for (int i = 0; i < coreL.length; i++) {
        	this.coreL[i] = new ModelRenderer(this, 0, 0);
        	this.coreL[i].addBox(8.0F, 19.0F, 0.0F + (float)i, coreLlengths[i], 1, 1, scale);
        	this.coreL[i].setRotationPoint(0.0F, (float)b0, 0.0F);
        }
        
        for (int i = 0; i < coreR.length; i++) {
        	this.coreR[i] = new ModelRenderer(this, 0, 0);
        	this.coreR[i].addBox((float)(0 - coreRlengths[i]), 19.0F, 0.0F + (float)i, coreRlengths[i], 1, 1, scale);
        	this.coreR[i].setRotationPoint(0.0F, (float)b0, 0.0F);
        }
       
    }
    
    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float par7)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, par7, p_78088_1_);
        this.core.render(par7);
        this.coreBack.render(par7);
        
        for (int i = 0; i < coreL.length; i++) {
        	this.coreL[i].render(par7);
        }
        
        for (int i = 0; i < coreR.length; i++) {
        	this.coreR[i].render(par7);
        }

        for (int i = 0; i < backL.length; i++) {
        	this.backL[i].render(par7);
        }
        
        for (int i = 0; i < backR.length; i++) {
        	this.backR[i].render(par7);
        }
    }
    
    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float speed, float p_78087_2_, float time, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        for (int i = 0; i < coreL.length; i++) {
        	this.coreL[i].offsetX = MathHelper.cos(coreLspeeds[i]*time + coreLspeeds[i]*speed)*0.05F;
        }
        
        for (int i = 0; i < coreR.length; i++) {
        	this.coreR[i].offsetX  = MathHelper.cos(coreRspeeds[i]*time + coreRspeeds[i]*speed + .2F)*0.05F;
        }
        
        for (int i = 0; i < backL.length; i++) {
        	this.backL[i].offsetX = MathHelper.cos(backLspeeds[i]*time + backLspeeds[i]*speed)*0.05F;
        }

        for (int i = 0; i < backR.length; i++) {
        	this.backR[i].offsetX = MathHelper.cos(backRspeeds[i]*time + backRspeeds[i]*speed)*0.05F;
        }
        
    }
    

}
