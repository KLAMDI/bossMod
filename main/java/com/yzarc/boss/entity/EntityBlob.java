package com.yzarc.boss.entity;

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

public class EntityBlob extends EntityMob
{
	private float width = 2.0F;
	private float height = 0.3F;
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
		//super.onLivingUpdate();
	}
	
	public boolean attackEntityFrom(DamageSource source, float f1)
	{
		Entity entity = source.getSourceOfDamage();
		if (entity instanceof EntityArrow)
		{
			if (!donutStance)
			{
				this.arrowCount++;
				if (arrowCount >= 3)
				{
					donutStance = true;
				}
			}
			else //if donutStance
			{
				entity.setDead();
				SpawnArrow(entity);
				return false;
			}
		}
		else
		{
			
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
	
	//spawns a copy of the arrow taht went into it's body --NEEDS ROTATION CHECK--
	public void SpawnArrow(Entity entity)
	{
		double 	posX = entity.posX, //3 
				posY = entity.posY, 
				posZ = entity.posZ;
		double dx, dy, dz;
		//blob pos = ~0 ~0 ~0
		dx = this.posX - posX; //this.posX = 5
		dy = this.posY - posY;
		dz = this.posZ - posZ;
		
		if (dx < 0)
			dx -= 0.4;
		else
			dx += 0.4;
		
		if (dy < 0)
			dy -= 0.4;
		else
			dy += 0.4;
		
		if (dz < 0)
			dz -= 0.4;
		else
			dz += 0.4;
		
		double 	newPosX = this.posX + dx,
				newPosY = this.posY + dy,
				newPosZ = this.posZ + dz;
		
		EntityArrow arrow = new EntityArrow(this.worldObj, newPosX, newPosY, newPosZ);
		
		if (!this.worldObj.isRemote)
        {
            this.worldObj.spawnEntityInWorld(arrow);
            arrow.motionX = entity.motionX * 3;
    		arrow.motionY = entity.motionY;
    		arrow.motionZ = entity.motionZ;
        }
		System.out.println(posX + " "+ posY + " " + posZ + "\n");
		System.out.println(arrow.motionX + " " + arrow.motionY + " " + arrow.motionZ);
	}
}
