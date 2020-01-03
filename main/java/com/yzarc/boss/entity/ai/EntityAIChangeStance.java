package com.yzarc.boss.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIChangeStance extends EntityAIBase
{
    private EntityLiving theEntity;
    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    private float distanceFromEntity;
    private Class targetEntityClass;

    public EntityAIChangeStance(EntityLiving theEntity, Class targetEntityClass, float distanceFromEntity)
    {
        this.theEntity = theEntity;
        this.targetEntityClass = targetEntityClass;
        this.distanceFromEntity = distanceFromEntity;
        this.setMutexBits(2);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if (this.targetEntityClass == EntityPlayer.class)
        {
    		this.closestEntity = this.theEntity.worldObj.getClosestPlayerToEntity(this.theEntity, (double)this.distanceFromEntity);
    		
    		if (this.closestEntity == null)
    		{
    			return false;
    		}
        }
    	
    	return true;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
		return false;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.theEntity.setDead();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.closestEntity = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
    	
    }
}