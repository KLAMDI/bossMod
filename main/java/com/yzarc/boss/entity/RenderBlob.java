package com.yzarc.boss.entity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

import com.yzarc.boss.BossMain;
import com.yzarc.boss.entity.EntityBlob;;

@SideOnly(Side.CLIENT)
public class RenderBlob extends RenderLiving {

    private static final ResourceLocation blobTextures = new ResourceLocation(BossMain.MODID + ":textures/blocks/stest.png");
    private ModelBase scaleAmount;

    public RenderBlob(ModelBase p_i1253_1_, float p_i1253_2_)
    {
        super(p_i1253_1_, p_i1253_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBlob p_110775_1_)
    {
        return blobTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityBlob)p_110775_1_);
    }
}

