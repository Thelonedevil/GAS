package com.github.thelonedevil.gearsautomatonssteam.tiles.machines.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.github.thelonedevil.gearsautomatonssteam.items.MyItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class CrusherRecipes
{
    private static final CrusherRecipes smeltingBase = new CrusherRecipes();
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static CrusherRecipes smelting()
    {
        return smeltingBase;
    }

    private CrusherRecipes()
    {
        this.addBlockRecipe(Blocks.cobblestone, new ItemStack(Item.getItemFromBlock(Blocks.gravel)), 0.7F);
        this.addBlockRecipe(Blocks.iron_ore, new ItemStack(MyItems.crushedIron,2),0.7f);


    }

    public void addBlockRecipe(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
    {
        this.addItemRecipe(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void addItemRecipe(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
    {
        this.addItemstackRecipe(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }

    public void addItemstackRecipe(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.compareItemStacks(p_151395_1_, (ItemStack) entry.getKey()));
        Random rand = new Random();
        if (rand.nextInt(10) > 7){
            return new ItemStack(((ItemStack)entry.getValue()).getItem(), 3);
        }
        return (ItemStack)entry.getValue();
    }

    private boolean compareItemStacks(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.compareItemStacks(p_151398_1_, (ItemStack) entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}