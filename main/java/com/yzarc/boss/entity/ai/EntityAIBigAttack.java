package com.yzarc.boss.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;

public class EntityAIBigAttack extends EntityAIBase
{
    World worldObj;
    EntityCreature attacker;
    double speedTowardsTarget;
    boolean longMemory;
    PathEntity entityPathEntity;
    Class classTarget;
    private int field_75445_i;
    
    public EntityAIBigAttack(EntityCreature attacker, Class targetClass, double speed, boolean longmem)
    {
        this(attacker, speed, longmem);
        this.classTarget = targetClass;
    }

    public EntityAIBigAttack(EntityCreature attacker, double speed, boolean longmem)
    {
        this.attacker = attacker;
        this.worldObj = attacker.worldObj;
        this.speedTowardsTarget = speed;
        this.longMemory = false;
        this.setMutexBits(3);
    }
	
    @Override
	public boolean shouldExecute() {
    	EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if (entitylivingbase == null)
        {
            return false;
        }
        else if (!entitylivingbase.isEntityAlive())
        {
            return false;
        }
        else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass()))
        {
            return false;
        }
        else
        {
            if (-- this.field_75445_i <= 0)
            {
                this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
               this.field_75445_i = 4 + this.attacker.getRNG().nextInt(7);
                return this.entityPathEntity != null;
            }
            else
            {
                if (this.attacker.getDistanceToEntity(this.attacker.getAttackTarget()) <= 2.0F)
                {
                	return true;
                }
            }
        }
		return false;
	}
    
    public void startExecuting()
    {
        this.attacker.getAttackTarget().setFire(100);
    }
    
}
