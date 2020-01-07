package com.yzarc.boss.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelBlob extends ModelBase 
{
	
	private boolean isBig;
	
	//bodyparts
	private ModelRenderer core;
	private ModelRenderer coreBack;
	private ModelRenderer coreFront;
	private ModelRenderer coreLeft;
	private ModelRenderer coreRight;
	
	//From top to bottom, second layer
	
	
	//Goes from top to bottom, core layer
	private ModelRenderer[] frontL = new ModelRenderer[4];
	private int frontLlengths[] = {4, 6, 7, 8};
	private float frontLspeeds[] = {0.17F, 0.20F, 0.22F, 0.18F};
	
	private ModelRenderer[] frontR = new ModelRenderer[4];
	private int frontRlengths[] = {2, 3, 5, 7};
	private float frontRspeeds[] = {0.27F, 0.23F, 0.22F, 0.14F};

	private ModelRenderer[] coreL = new ModelRenderer[16];
	private int coreLlengths[] = {9,10,11,12,13,14,15,17,16,15,14,13,12,11,10,9};
	private float coreLspeeds[] = {0.27F, 0.3F, 0.23F, 0.12F, 0.16F, 0.14F, 0.18F, 0.22F, 0.16F, 0.20F, 0.18F, 0.12F, 0.11F, 0.10F, 0.13F, 0.14F};
	private ModelRenderer[] coreR = new ModelRenderer[16];
	private int coreRlengths[] = {9,11,13,15,16,17,18,19,20,19,18,17,16,13,11,9};
	private float coreRspeeds[] = {0.12F, 0.18F, 0.23F, 0.20F, 0.32F, 0.3F, 0.33F, 0.28F, 0.20F, 0.22F, 0.24F, 0.17F, 0.10F, 0.13F, 0.14F, 0.10F};
	
	private ModelRenderer[] backL = new ModelRenderer[4];
	private int backLlengths[] = {8, 7, 5, 3};
	private float backLspeeds[] = {0.17F, 0.20F, 0.22F, 0.18F};
	
	private ModelRenderer[] backR = new ModelRenderer[4];
	private int backRlengths[] = {8, 6, 4, 2};
	private float backRspeeds[] = {0.27F, 0.23F, 0.22F, 0.14F};
	
	
    public ModelBlob()
    {
        this(0.0F);
    }

    public ModelBlob(float scale)
    {
    	
    	this.textureWidth = 64;
    	this.textureHeight = 64;
    	
        byte b0 = 4;
        this.core = new ModelRenderer(this, 0, 0);
        this.core.addBox(0.0F, 17.0F, 0.0F, 16, 3, 16, scale);
        this.core.setRotationPoint(-8.0F, (float)b0, -8.0F);
        
        this.coreBack = new ModelRenderer(this, 0, 19);
        this.coreBack.addBox(3.0F, 18.0F, 16.0F, 10, 2, 5, scale);
        this.coreBack.setRotationPoint(-8.0F, (float)b0, -8.0F);
        
        this.coreFront = new ModelRenderer(this, 30, 19);
        this.coreFront.addBox(3.0F, 18.0F, -5.0F, 10, 2, 5, scale);
        this.coreFront.setRotationPoint(-8.0F, (float)b0, -8.0F);
        
        this.coreLeft = new ModelRenderer(this, 0, 28);
        this.coreLeft.addBox(16.0F, 18.0F, 3.0F, 5, 2, 10, scale);
        this.coreLeft.setRotationPoint(-8.0F, (float)b0, -8.0F);
        
        this.coreRight = new ModelRenderer(this, 0, 28);
        this.coreRight.addBox(-5.0F, 18.0F, 3.0F, 5, 2, 10, scale);
        this.coreRight.setRotationPoint(-8.0F, (float)b0, -8.0F);
        
        for (int i = 0; i < backL.length; i++) {
        	this.backL[i] = new ModelRenderer(this, 0, 26);
        	this.backL[i].addBox(12.0F, 19.0F, 16.0F + (float)i, backLlengths[i], 1, 1, scale);
        	this.backL[i].setRotationPoint(-8.0F, (float)b0, -8.0F);
		}
        
        for (int i = 0; i < backR.length; i++) {
        	this.backR[i] = new ModelRenderer(this, 0, 26);
        	this.backR[i].addBox((float)(4 - backRlengths[i]), 19.0F, 16.0F + (float)i, backRlengths[i], 1, 1, scale);
        	this.backR[i].setRotationPoint(-8.0F, (float)b0, -8.0F);
		}
        
        for (int i = 0; i < coreL.length; i++) {
        	this.coreL[i] = new ModelRenderer(this, 0, 26);
        	this.coreL[i].addBox(12.0F, 19.0F, 0.0F + (float)i, coreLlengths[i], 1, 1, scale);
        	this.coreL[i].setRotationPoint(-8.0F, (float)b0, -8.0F);
        }
        
        for (int i = 0; i < coreR.length; i++) {
        	this.coreR[i] = new ModelRenderer(this, 0, 26);
        	this.coreR[i].addBox((float)(4 - coreRlengths[i]), 19.0F, 0.0F + (float)i, coreRlengths[i], 1, 1, scale);
        	this.coreR[i].setRotationPoint(-8.0F, (float)b0, -8.0F);
        }
       
        for (int i = 0; i < frontL.length; i++) {
        	this.frontL[i] = new ModelRenderer(this, 0, 26);
        	this.frontL[i].addBox(12.0F, 19.0F, -4.0F + (float)i, frontLlengths[i], 1, 1, scale);
        	this.frontL[i].setRotationPoint(-8.0F, (float)b0, -8.0F);
        }
        
        for (int i = 0; i < frontR.length; i++) {
        	this.frontR[i] = new ModelRenderer(this, 0, 26);
        	this.frontR[i].addBox((float)(4 - frontRlengths[i]), 19.0F, -4.0F + (float)i, frontRlengths[i], 1, 1, scale);
        	this.frontR[i].setRotationPoint(-8.0F, (float)b0, -8.0F);
        }
    }
    
    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float speed, float maxSwing, float time, float p_78088_5_, float p_78088_6_, float par7)
    {
    	this.setRotationAngles(speed, maxSwing, time, p_78088_5_, p_78088_6_, par7, entity);
        this.core.render(par7);
    	this.coreBack.render(par7);
    	this.coreFront.render(par7);
    	this.coreLeft.render(par7);
    	this.coreRight.render(par7);
    	
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
       
        for (int i = 0; i < frontL.length; i++) {
        	this.frontL[i].render(par7);
        }
       
        for (int i = 0; i < frontR.length; i++) {
        	this.frontR[i].render(par7);
        }
        
        if (isBig)
        {
        	
        }              
    }
    
    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float speed, float maxSwing, float time, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity)
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
        
        for (int i = 0; i < frontL.length; i++) {
        	this.frontL[i].offsetX = MathHelper.cos(frontLspeeds[i]*time + frontLspeeds[i]*speed)*0.05F;
        }

        for (int i = 0; i < frontR.length; i++) {
        	this.frontR[i].offsetX = MathHelper.cos(frontRspeeds[i]*time + frontRspeeds[i]*speed)*0.05F;
        }
        
    }

	public boolean isBig() {
		return isBig;
	}

	public void setBig(boolean isBig) {
		this.isBig = isBig;
	}
    
    
    

}
