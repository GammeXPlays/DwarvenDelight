package me.naftoreiclag.dwarvendelight;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

public class PopulatorTallgrass extends BlockPopulator
{
	@Override
	public void populate(World world, Random random, Chunk baseChunk)
	{
		for (int x = 0; x < 16; x++)
		{
			for (int z = 0; z < 16; z++)
			{
				//get a random number between 0 and 100
				int chance = random.nextInt(100);
				
				//target a block
				Block targetBlock = world.getHighestBlockAt(x + (baseChunk.getX() * 16), z + (baseChunk.getZ() * 16));
				
				if(targetBlock.getRelative(BlockFace.DOWN, 1).getType().equals(Material.GRASS))
				{
					//if it's greater than 80
					if (chance > 80)
					{
						//set to tallgrass 1
						targetBlock.setTypeIdAndData(Material.LONG_GRASS.getId(), (byte) 1, true);
					}
					else if (chance < 10)
					{
						//set to tallgrass 2
						targetBlock.setTypeIdAndData(Material.LONG_GRASS.getId(), (byte) 2, true);
					}
				}
			}
		}
	}
}
