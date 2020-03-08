package com.yzarc.boss.blocks;

import java.util.Random;

import com.yzarc.boss.BossMain;
import com.yzarc.boss.items.BossItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockSlimeTrail extends Block {

	 private static final String __OBFID = "CL_00000309";

	 protected BlockSlimeTrail(String unlocalizedName, CreativeTabs creativeTab)
     {
         super(BossMaterials.slime);
         this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
         this.setTickRandomly(true);
         this.setCreativeTab(creativeTab);
         this.setBlockBoundsByMetaData(0);
        
         String textureName = BossMain.MODID + ":" + unlocalizedName;
        
         this.setBlockTextureName(textureName);
         this.setBlockName(unlocalizedName);
     }

     @SideOnly(Side.CLIENT)
     public void registerBlockIcons(IIconRegister icon)
     {
         this.blockIcon = icon.registerIcon(textureName);
     }

     /**
      * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
      * cleared to be reused)
      */
     public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
     {
         int l = world.getBlockMetadata(x, y, z) & 7;
         float f = 0.0625F;
         return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)((float)y + (float)l * f), (double)z + this.maxZ);
     }

     /**
      * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
      * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
      */
     public boolean isOpaqueCube()
     {
         return false;
     }

     /**
      * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
      */
     public boolean renderAsNormalBlock()
     {
    	 return false;
     }
     
     /**
      * Sets the block's bounds for rendering it as an item
      */
     public void setBlockBoundsForItemRender()
     {
    	 this.setBlockBoundsByMetaData(0);
     }

     /**
      * Updates the blocks bounds based on its current state. Args: world, x, y, z
      */
     public void setBlockBoundsBasedOnState(IBlockAccess meta, int x, int y, int z)
     {
    	 this.setBlockBoundsByMetaData(meta.getBlockMetadata(x, y, z));
     }

     protected void setBlockBoundsByMetaData(int meta)
     {
    	 int layerAmount = meta & 7;
    	 float y = (float)(1 * (1 + layerAmount)) / 16.0F;
    	 this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, y, 1.0F);
     }

     /**
      * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
      */
     public boolean canPlaceBlockAt(World world, int x, int y, int z)
     {
    	 Block block = world.getBlock(x, y - 1, z);
    	 return block == this && (world.getBlockMetadata(x, y - 1, z) & 7) == 7 ? true : block.isOpaqueCube() ;
     }
     
//     if(block == this && (world.getBlockMetadata(x, y - 1, z) & 7) == 7)
//     {
//     	return true;
//     }
//     else
//     {
//     	if (block.isOpaqueCube() && block.isSideSolid(world, x, y, z, ForgeDirection.UP))
//     	{
//     		return true;
//     	}
//     	else
//    		{
//     		return false;
//    		}
//    	}
//     
     
     /**
      * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
      * their own) Args: x, y, z, neighbor Block
      */
     public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
     {
    	 this.func_150155_m(world, x, y, z);
     }

     private boolean func_150155_m(World world, int x, int y, int z)
     {
    	 if (!this.canPlaceBlockAt(world, x, y, z))
    	 {
    		 world.setBlockToAir(x, y, z);
    		 return false;
    	 }
    	 else
    	 {
    		 return true;
    	 }
     }

     /**
      * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
      * block and l is the block's subtype/damage.
      */
     public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_)
     {
    	 super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
    	 p_149636_1_.setBlockToAir(p_149636_3_, p_149636_4_, p_149636_5_);
     }

     public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
     {
    	 return BossItems.noHoe;
     }

     /**
      * Returns the quantity of items to drop on block destruction.
      */
     public int quantityDropped(Random p_149745_1_)
     {
    	 return 1;
     }

     /**
      * Ticks the block if it's been scheduled
      */
     public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
     {
    	 if (p_149674_1_.getSavedLightValue(EnumSkyBlock.Block, p_149674_2_, p_149674_3_, p_149674_4_) > 11)
    	 {
    		 p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
    	 }
     }

     /**
      * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
      * coordinates.  Args: blockAccess, x, y, z, side
      */
     @SideOnly(Side.CLIENT)
     public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
     {
    	 return p_149646_5_ == 1 ? true : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
     }

     /**
      * Metadata and fortune sensitive version, this replaces the old (int meta, Random rand)
      * version in 1.1.
      *
      * @param meta Blocks Metadata
      * @param fortune Current item fortune level
      * @param random Random number generator
      * @return The number of items to drop
      */
     public int quantityDropped(int meta, int fortune, Random random)
     {
    	 return (meta & 7) + 1;
     }

     /**
      * Determines if a new block can be replace the space occupied by this one,
      * Used in the player's placement code to make the block act like water, and lava.
      *
      * @param world The current world
      * @param x X Position
      * @param y Y position
      * @param z Z position
      * @return True if the block is replaceable by another block
      */
     public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
     {
    	 int meta = world.getBlockMetadata(x, y, z);
    	 return meta >= 7 ? false : blockMaterial.isReplaceable();
     }
}
