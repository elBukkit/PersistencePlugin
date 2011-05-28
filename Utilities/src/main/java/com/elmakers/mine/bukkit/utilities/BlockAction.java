package com.elmakers.mine.bukkit.utilities;

import org.bukkit.block.Block;

import com.elmakers.mine.bukkit.persistence.dao.BlockList;

public interface BlockAction
{
    public boolean perform(Block block);
    public BlockList getBlocks();
}
