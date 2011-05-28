package com.elmakers.mine.bukkit.utilities;

import org.bukkit.Material;
import org.bukkit.block.Block;

import com.elmakers.mine.bukkit.persistence.dao.MaterialData;
import com.elmakers.mine.bukkit.persistence.dao.MaterialList;

public class ReplaceMaterialAction extends SimpleBlockAction
{
    protected MaterialData replace;

    protected MaterialList replaceable = new MaterialList();

    public ReplaceMaterialAction(Block targetBlock, Material replaceMaterial, byte replaceData)
    {
        replaceable.add(new MaterialData(targetBlock.getType(), targetBlock.getData()));
        replace = new MaterialData(replaceMaterial, replaceData);
    }

    public ReplaceMaterialAction(Material replaceMaterial, byte replaceData)
    {
        replace = new MaterialData(replaceMaterial, replaceData);
    }

    public ReplaceMaterialAction(Material targetMaterial, byte targetData, Material replaceMaterial, byte replaceData)
    {
        replace = new MaterialData(replaceMaterial, replaceData);
        replaceable.add(new MaterialData(targetMaterial, targetData));
    }

    public ReplaceMaterialAction(Block targetBlock, MaterialData material)
    {
        replaceable.add(new MaterialData(targetBlock.getType(), targetBlock.getData()));       
        replace = material;
    }

    public void addReplaceable(Material material)
    {
        replaceable.add(material);
    }

    public boolean perform(Block block)
    {
        if (replace == null)
        {
            return false;
        }

        if (replaceable == null || replaceable.contains(block.getType()))
        {
            block.setType(replace.getType());
            block.setData(replace.getData());
            super.perform(block);
            return true;
        }

        return false;
    }
}
