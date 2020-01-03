package com.yzarc.boss.entity;

import net.minecraft.entity.SharedMonsterAttributes;
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
	public EntityBlob(World worldIn) 
	{
		super(worldIn);
		this.setSize(1.0F, 1.0F);
		this.tasks.addTask(0, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		
		// TODO Auto-generated constructor stub
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
	}
	
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}
	
	protected Item getDropItem()
	{
		return Items.diamond_hoe;
	}
	
	public boolean getCanSpawnHere()
	{
		return super.getCanSpawnHere();
	}

}
