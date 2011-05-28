package com.elmakers.mine.bukkit.utilities;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import com.elmakers.mine.bukkit.persistence.dao.BlockData;
import com.elmakers.mine.bukkit.persistence.dao.BlockList;

public class BlockRecurse
{
    protected int maxRecursion = 8;

    public int recurse(Block startBlock, BlockAction recurseAction)
    {
        recurse(startBlock, recurseAction, null, 0);
        return recurseAction.getBlocks().size();
    }

    protected void recurse(Block block, BlockAction recurseAction, BlockFace nextFace, int rDepth)
    {
        BlockList affectedBlocks = recurseAction.getBlocks();
        if (nextFace != null)
        {
            block = block.getFace(nextFace);
        }
        if (affectedBlocks.contains(block))
        {
            return;
        }
        affectedBlocks.add(block);

        if (!recurseAction.perform(block))
        {
            return;
        }

        if (rDepth < maxRecursion)
        {
            for (BlockFace face : BlockData.FACES)
            {
                if (nextFace == null || nextFace != BlockData.getReverseFace(face))
                {
                    recurse(block, recurseAction, face, rDepth + 1);
                }
            }
        }
    }
}
