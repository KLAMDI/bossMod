package com.yzarc.boss.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBlob extends EntityMob
{
	private float width = 1.0F;
	private float height = 1.0F;
	private double aggroDistance = 4.0D;
	private int arrowCount;
	
	private boolean isBig;
	private boolean donutStance;
	
	public EntityBlob(World worldIn) 
	{
		super(worldIn);
		this.setSize(width,height);
		this.arrowCount = 0;
		this.isBig = false;
		this.donutStance = false;
		//this.tasks.addTask(0, new EntityAIWander(this, 0.1D));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		//this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		
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
		if (donutStance)
		{
			DodgeArrows();
		}
		super.onLivingUpdate();
	}
	
	public boolean attackEntityFrom(DamageSource source, float f1)
	{
		if (!donutStance)
		{
			if (source.isProjectile())
			{
				this.arrowCount++;
				if (arrowCount >= 3)
				{
					donutStance = true;
				}
			}
		}
		return super.attackEntityFrom(source, f1);
	}

	@Override
	protected void updateEntityActionState() {
		super.updateEntityActionState();
	}

	protected Item getDropItem()
	{
		return Items.diamond_hoe;
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

	public void setBig(boolean isBig) {
		this.isBig = isBig;
	}
	
	public void DodgeArrows()
	{
		
	}
}
