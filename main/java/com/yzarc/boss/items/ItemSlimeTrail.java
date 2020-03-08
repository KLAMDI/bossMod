package com.yzarc.boss.items;

import com.yzarc.boss.blocks.BossBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSlimeTrail extends ItemBlockWithMetadata
{

	private static final String __OBFID = "CL_00000068";

    public ItemSlimeTrail(Block block)
    {
        super(block, block);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	
        if (item.stackSize == 0)
        {
            return false;
        }
        else if (!player.canPlayerEdit(x, y, z, p_77648_7_, item))
        {
            return false;
        }
        else
        {
            Block block = world.getBlock(x, y, z);

            if (block == BossBlocks.slime_trail)
            {
                int i1 = world.getBlockMetadata(x, y, z);
                int j1 = i1 & 7;

                if (j1 <= 6 && world.checkNoEntityCollision(this.field_150939_a.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlockMetadataWithNotify(x, y, z, j1 + 1 | i1 & -8, 2))
                {
                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);
                    --item.stackSize;
                    return true;
                }
            }
            
            return super.onItemUse(item, player, world, x, y, z, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
        }
    }
}

