package com.yzarc.boss.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

import com.yzarc.boss.BossMain;
import com.yzarc.boss.entity.EntityBlob;
import com.yzarc.boss.model.ModelBlob;;

@SideOnly(Side.CLIENT)
public class RenderBlob extends RenderLiving {

    private static final ResourceLocation blobTextures = new ResourceLocation(BossMain.MODID + ":textures/entity/blob_base.png");
    
    protected ModelBlob entityModel;

    public RenderBlob(ModelBase modelBlob, float scale)
    {
        super(modelBlob, scale);
        
        entityModel = ((ModelBlob) mainModel);
    }
    
    public void renderBlob(EntityBlob entity, double x, double y, double z, float u, float v)
    {
    	this.entityModel.setBig(entity.isBig());
    	
    	super.doRender(entity, x, y, z, u, v);
    }
    
    public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v)
    {
    	renderBlob((EntityBlob)entityLiving, x, y, z, u, v);
    }
    
    public void doRender(Entity entity, double x, double y, double z, float u, float v)
    {
    	renderBlob((EntityBlob)entity, x, y, z, u, v);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBlob entity)
    {
        return blobTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityBlob)entity);
    }
}

