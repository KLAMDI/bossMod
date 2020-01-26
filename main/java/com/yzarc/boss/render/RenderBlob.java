package com.yzarc.boss.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import com.yzarc.boss.BossMain;
import com.yzarc.boss.entity.EntityBlob;
import com.yzarc.boss.model.ModelBlob;;

@SideOnly(Side.CLIENT)
public class RenderBlob extends RenderLiving {

    private static final ResourceLocation blobTextures = new ResourceLocation(BossMain.MODID + ":textures/entity/blob_base.png");
    private static final ResourceLocation armoredBlobTextures = new ResourceLocation(BossMain.MODID + ":textures/entity/blob_armor.png");
    
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
    
    protected int shouldRenderPass(EntityBlob entityBlob, int i, float f) {
    	if (entityBlob.isReflect()) {
    		
            if (entityBlob.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }
            if (i == 1) {
		        float f1 = (float)entityBlob.ticksExisted + f;
		        this.bindTexture(armoredBlobTextures);
		        GL11.glMatrixMode(GL11.GL_TEXTURE);
		        GL11.glLoadIdentity();
		        float f2 = f1 * 0.01F;
		        float f3 = f1 * 0.01F;
		        GL11.glTranslatef(f2, f3, 0.0F);
		        this.setRenderPassModel(this.entityModel);
		        GL11.glMatrixMode(GL11.GL_MODELVIEW);
		        GL11.glEnable(GL11.GL_BLEND);
		        float f4 = 0.5F;
		        GL11.glColor4f(f4, f4, f4, 1.0F);
		        GL11.glDisable(GL11.GL_LIGHTING);
		        GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		        return 1;
            }
            
            if (i == 2) {
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
            }
    	}
    	return -1;
    }
    
    protected int inheritRenderPass(EntityBlob entity, int i, float f)
    {
        return -1;
    }
    
    protected int shouldRenderPass(EntityLivingBase entity, int i, float f)
    {
        return this.shouldRenderPass((EntityBlob)entity, i, f);
    }
    
    protected int inheritRenderPass(EntityLivingBase entity, int i, float f)
    {
        return this.inheritRenderPass((EntityBlob)entity, i, f);
    }
}



