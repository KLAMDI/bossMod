package com.yzarc.boss.entity.effect;

import org.lwjgl.opengl.GL11;

import com.yzarc.boss.BossMain;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import static org.lwjgl.opengl.GL11.*;

public class EntitySlimeReflectFX extends EntityFX{

	private static final ResourceLocation reflectTexture = new ResourceLocation(BossMain.MODID + ":textures/particle/slimeReflectFX.png");
	
	public EntitySlimeReflectFX(World world, double x, double y, double z) {
		super(world, x, y, z);
		setMaxAge(5);
		setGravity(0);
	}
	
	@Override
	public void renderParticle(Tessellator tess, float partialTicks, float par3, float par4, float par5, float par6, float par7) {
		Minecraft.getMinecraft().renderEngine.bindTexture(reflectTexture);
		
		//GL magic
		glDepthMask(false);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glAlphaFunc(GL_GREATER, 0.0003921569F);

		tess.setBrightness(getBrightnessForRender(partialTicks));
		
		float scale = 0.1F*particleScale;
		float x =  (float)(prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float)(prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z =  (float)(prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		
		//Initializing UV texture
		tess.addVertexWithUV(x - (par3 + par6)*scale, y - par4*scale, z - (par5 + par7)*scale, 0, 0);
		tess.addVertexWithUV(x - (par3 - par6)*scale, y + par4*scale, z - (par5 - par7)*scale, 1, 0);
		tess.addVertexWithUV(x + (par3 + par6)*scale, y + par4*scale, z + (par5 + par7)*scale, 1, 1);
		tess.addVertexWithUV(x + (par3 - par6)*scale, y - par4*scale, z + (par5 - par7)*scale, 0, 1);
		
		glDisable(GL_BLEND);
		glDepthMask(true);
		glAlphaFunc(GL_GREATER, 0.1F);
		
		
	}
	
	public int getFXLayer() {
		return 1;
	}
	
	public EntitySlimeReflectFX setMaxAge(int maxAge) {
		particleMaxAge = maxAge;
				return this;
	}
	
	public EntitySlimeReflectFX setGravity(int gravity) {
		particleGravity = gravity;
				return this;
	}
	public EntitySlimeReflectFX setScale(int scale) {
		particleScale = scale;
				return this;
	}
}
