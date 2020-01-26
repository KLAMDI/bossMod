package com.yzarc.boss.entity;

import com.yzarc.boss.entity.effect.EntitySlimeReflectFX;

import net.minecraft.client.Minecraft;
import com.yzarc.boss.items.BossItems;
import net.minecraft.entity.Entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import scala.collection.concurrent.Debug;
import net.minecraft.util.MathHelper;

public class EntityBlob extends EntityMob
{
	private float width = 2.0F;
	private float height = 0.3F;
	private double aggroDistance = 4.0D;
	private int arrowCount;
	
	private boolean isBig;
	private boolean reflectStance;
	
	public EntityBlob(World worldIn) 
	{
		super(worldIn);
		this.setSize(width,height);
		this.arrowCount = 0;
		this.isBig = false;
		this.reflectStance = false;
		//this.tasks.addTask(0, new EntityAIWander(this, 0.1D));
		this.tasks.addTask(0, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		
		// TODO Auto-generated constructor stub
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}
	
	public void onLivingUpdate()
	{
		changeStance();
		super.onLivingUpdate();
	}
	
	public boolean attackEntityFrom(DamageSource source, float f1)
	{
		Entity entity = source.getSourceOfDamage();
		if (entity instanceof EntityArrow)
		{
			if (!reflectStance)
			{
				this.arrowCount++;
				if (arrowCount >= 3)
				{
					reflectStance = true;
				}
			}
			else //if reflectStance
			{
				ReflectArrow(entity);
				return false;
			}
		}
		else
		{
			
		}
		return super.attackEntityFrom(source, f1);
	}
	
	@Override
	protected void attackEntity(Entity targetEntity, float amount) {
		super.attackEntity(targetEntity, amount);
	}

	@Override
	protected void updateEntityActionState() {
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
    		isBig = true;
    	}
    	else
    	{
    		isBig = false;
    	}
    }

	public boolean isBig() {
		return isBig;
	}
	
	public boolean isReflect() {
		return reflectStance;
	}

	public void setBig(boolean isBig) {
		this.isBig = isBig;
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

	}
}
