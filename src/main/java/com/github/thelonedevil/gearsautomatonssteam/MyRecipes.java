package com.github.thelonedevil.gearsautomatonssteam;

import com.github.thelonedevil.gearsautomatonssteam.items.MyItems;
import com.github.thelonedevil.gearsautomatonssteam.tiles.fluid.MyFluids;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by justin on 21/08/2014.
 */
public class MyRecipes {

    public static void init(){
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.crushedIron), Blocks.iron_ore,Blocks.stone);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.washedIron), MyFluids.yourBucket,MyItems.crushedIron);

        GameRegistry.addSmelting(MyItems.compactedIron, new ItemStack(Items.iron_ingot),0.7f);
    }
}
