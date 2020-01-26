package com.yzarc.boss.entity;

import com.yzarc.boss.entity.effect.EntitySlimeReflectFX;

import net.minecraft.client.Minecraft;
import com.yzarc.boss.items.BossItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import scala.collection.concurrent.Debug;
import net.minecraft.util.MathHelper;

public class EntityBlob extends EntityCreature
{
	private float width = 2.0F;
	private float height = 0.3F;
	private double aggroDistance = 4.0D;
	private int arrowCount;
	private int attackDelayCounter;
	
	private boolean isBig;
	private boolean reflectStance;
	private boolean attacking;
	
	public EntityBlob(World worldIn) 
	{
		super(worldIn);
		this.setSize(width,height);
		this.arrowCount = 0;
		this.attackDelayCounter = 0;
		this.isBig = false;
		this.reflectStance = false;
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}
	
	public void onLivingUpdate()
	{
		changeStance();
		super.onLivingUpdate();
	}
	
	public boolean attackEntityFrom(DamageSource source, float damageAmount)
	{
		Entity entity = source.getSourceOfDamage();
		if (entity instanceof EntityArrow)
		{
			if (!this.isReflect())
			{
				this.arrowCount++;
				if (this.arrowCount >= 3)
				{
					this.setReflect(true);
				}
			}
			else //if reflectStance
			{
				ReflectArrow(entity);
				return false;
			}
		}
		
		return super.attackEntityFrom(source, damageAmount);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity targetEntity) 
	{
		return super.attackEntityAsMob(targetEntity);
	}

	@Override
	protected void updateEntityActionState() {
		this.entityToAttack = null;
		super.updateEntityActionState();
	}

	protected Item getDropItem()
	{
		return BossItems.noHoe;
	}
	
	public boolean getCanSpawnHere()
	{
		return super.getCanSpawnHere();
	}
    
    public void changeStance()
    {
    	if (this.worldObj.getClosestPlayerToEntity(this, aggroDistance) != null)
    	{
    		this.setBig(true);
    	}
    	else
    	{
    		this.setBig(false);
    	}
    }
	
	//intensifies the Minecraft reflecting of the arrow
	public void ReflectArrow(Entity entity)
	{
		
		entity.motionX = entity.motionX*5.0F;
		entity.motionY = entity.motionY*5.0F;
		entity.motionZ = entity.motionZ*5.0F;
		
		//Prevents the arrow from spazzing out if its Y speed is too low, and makes them bounce on the blob instead
		if (entity.motionY < 0.1D) {
			entity.motionY = -4;
		}
		
		if (this.worldObj.isRemote)
        {          
			//Spawn in a reflect particle
			Minecraft.getMinecraft().effectRenderer.addEffect(new EntitySlimeReflectFX(this.worldObj, entity.posX, entity.posY, entity.posZ));
		}
		
		this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "boss:blob-boing", 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
	}
	
	public boolean isBig() {
		return this.isBig;
	}

	public void setBig(boolean isBig) {
		this.isBig = isBig;
	}
	
	public void setAttacking(boolean b) 
	{
		this.attacking = b;
	}
	
	public boolean isAttacking()
	{
		return this.attacking;
	}
	
	public void setReflect(boolean b)
	{
		this.reflectStance = b;
	}
	
	public boolean isReflect() 
	{
		return this.reflectStance;
	}
}
