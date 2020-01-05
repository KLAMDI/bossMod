package com.yzarc.boss.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityBlob extends EntityMob
{
	private float sizeY = 1.0F;
	private float sizeX = 1.0F;
	
	private boolean isBig = false;
	
	public EntityBlob(World worldIn) 
	{
		super(worldIn);
		this.setSize(sizeY,sizeX);
		//this.tasks.addTask(0, new EntityAIWander(this, 0.1D));
		//this.tasks.addTask(1, new EntityAIChangeStance(this, EntityPlayer.class, 4));
		//this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		//this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		
		// TODO Auto-generated constructor stub
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}
	
	public void onLivingUpdate()
	{
		changeStance();
		super.onLivingUpdate();
	}

	@Override
	protected void updateEntityActionState() {
		// TODO Auto-generated method stub
		//super.updateEntityActionState();
	}

	protected Item getDropItem()
	{
		return Items.diamond_hoe;
	}
	
	public boolean getCanSpawnHere()
	{
		return super.getCanSpawnHere();
	}
	
	public void setSizeY(float sizeY)
	{
		this.sizeY = sizeY;
	}
	
	public void setSizeX(float sizeX)
	{
		this.sizeX = sizeX;
	}
	
    public void setSizeXY(float sizeY, float sizeX)
    {
    	this.setSizeX(sizeX);
    	this.setSizeY(sizeY);
    	this.setSize(sizeX, sizeY);
    }
    
    public void changeStance()
    {
    	if (this.worldObj.getClosestPlayerToEntity(this, 8.0D) != null)
    	{
    		isBig = true;
    		this.setSizeXY(2.0F, 2.0F);
    	}
    	else
    	{
    		isBig = false;
    		this.setSizeXY(1.0F, 1.0F);
    	}
    }
}
