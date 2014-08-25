package com.github.thelonedevil.gearsautomatonssteam.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by justin on 23/08/2014.
 */
public class CompacterItem extends ItemBlock {


    public CompacterItem(Block p_i45328_1_) {
        super(p_i45328_1_);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item,1,3));
    }
}
