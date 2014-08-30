package com.github.thelonedevil.gearsautomatonssteam;

import com.github.thelonedevil.gearsautomatonssteam.items.MyItems;
import com.github.thelonedevil.gearsautomatonssteam.tiles.fluid.MyFluids;
import com.github.thelonedevil.gearsautomatonssteam.tiles.ore.MyOres;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by justin on 21/08/2014.
 */
public class MyRecipes {

    public static void init(){
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.crushedIron), Blocks.iron_ore,Blocks.stone);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.washedIron), MyFluids.steamBottle,MyItems.crushedIron);

        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.crushedCopper), MyOres.ore_Copper,Blocks.stone);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.washedCopper), MyFluids.steamBottle,MyItems.crushedCopper);

        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.crushedZinc), MyOres.ore_Zinc,Blocks.stone);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.washedZinc), MyFluids.steamBottle,MyItems.crushedZinc);

        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.crushedArsenic), MyOres.ore_Arsenic,Blocks.stone);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.washedArsenic), MyFluids.steamBottle,MyItems.crushedArsenic);
        
        GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot),MyItems.nuggetIron,MyItems.nuggetIron,MyItems.nuggetIron,MyItems.nuggetIron,MyItems.nuggetIron,MyItems.nuggetIron,MyItems.nuggetIron,MyItems.nuggetIron,MyItems.nuggetIron);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.ingotCopper),MyItems.nuggetCopper,MyItems.nuggetCopper,MyItems.nuggetCopper,MyItems.nuggetCopper,MyItems.nuggetCopper,MyItems.nuggetCopper,MyItems.nuggetCopper,MyItems.nuggetCopper,MyItems.nuggetCopper);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.ingotZinc),MyItems.nuggetZinc,MyItems.nuggetZinc,MyItems.nuggetZinc,MyItems.nuggetZinc,MyItems.nuggetZinc,MyItems.nuggetZinc,MyItems.nuggetZinc,MyItems.nuggetZinc,MyItems.nuggetZinc);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.ingotBrass),MyItems.nuggetBrass,MyItems.nuggetBrass,MyItems.nuggetBrass,MyItems.nuggetBrass,MyItems.nuggetBrass,MyItems.nuggetBrass,MyItems.nuggetBrass,MyItems.nuggetBrass,MyItems.nuggetBrass);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.ingotArsenic),MyItems.nuggetArsenic,MyItems.nuggetArsenic,MyItems.nuggetArsenic,MyItems.nuggetArsenic,MyItems.nuggetArsenic,MyItems.nuggetArsenic,MyItems.nuggetArsenic,MyItems.nuggetArsenic,MyItems.nuggetArsenic);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.ingotDZR),MyItems.nuggetDZR,MyItems.nuggetDZR,MyItems.nuggetDZR,MyItems.nuggetDZR,MyItems.nuggetDZR,MyItems.nuggetDZR,MyItems.nuggetDZR,MyItems.nuggetDZR,MyItems.nuggetDZR);
        
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.nuggetIron,9),Items.iron_ingot);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.nuggetCopper,9), MyItems.ingotCopper);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.nuggetDZR,9), MyItems.ingotDZR);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.nuggetZinc,9), MyItems.ingotZinc);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.nuggetBrass,9), MyItems.ingotBrass);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.nuggetArsenic,9), MyItems.ingotArsenic);

        GameRegistry.addSmelting(MyItems.compactedIron, new ItemStack(Items.iron_ingot),0.7f);
        GameRegistry.addSmelting(MyItems.compactedCopper, new ItemStack(MyItems.ingotCopper),0.7f);
        GameRegistry.addSmelting(MyItems.compactedBrass, new ItemStack(MyItems.ingotBrass),0.7f);
        GameRegistry.addSmelting(MyItems.compactedZinc, new ItemStack(MyItems.ingotZinc),0.7f);
        GameRegistry.addSmelting(MyItems.compactedArsenic, new ItemStack(MyItems.ingotArsenic),0.7f);
        GameRegistry.addSmelting(MyItems.compactedDZR, new ItemStack(MyItems.ingotDZR),0.7f);
        GameRegistry.addSmelting(MyOres.ore_Arsenic, new ItemStack(MyItems.ingotArsenic),0.7f);
        GameRegistry.addSmelting(MyOres.ore_Copper, new ItemStack(MyItems.ingotCopper),0.7f);
        GameRegistry.addSmelting(MyOres.ore_Zinc, new ItemStack(MyItems.ingotZinc),0.7f);

        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.compactedIron,8),MyItems.washedIron,MyItems.washedIron,MyItems.washedIron,MyItems.washedIron,MyItems.washedIron,MyItems.washedIron,MyItems.washedIron,MyItems.washedIron,MyItems.washedIron);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.compactedCopper,8),MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.compactedZinc,8),MyItems.washedZinc,MyItems.washedZinc,MyItems.washedZinc,MyItems.washedZinc,MyItems.washedZinc,MyItems.washedZinc,MyItems.washedZinc,MyItems.washedZinc,MyItems.washedZinc);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.compactedArsenic,8),MyItems.washedArsenic,MyItems.washedArsenic,MyItems.washedArsenic,MyItems.washedArsenic,MyItems.washedArsenic,MyItems.washedArsenic,MyItems.washedArsenic,MyItems.washedArsenic,MyItems.washedArsenic);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.compactedBrass,1),MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper,MyItems.washedZinc);
        GameRegistry.addShapelessRecipe(new ItemStack(MyItems.compactedDZR,1),MyItems.washedCopper,MyItems.washedCopper,MyItems.washedCopper,MyItems.washedZinc,MyItems.nuggetArsenic);
        
        GameRegistry.addShapedRecipe(new ItemStack(MyFluids.steamBottleEmpty)," A ","B B","ABA",'A',MyItems.ingotDZR,'B', Item.getItemFromBlock(Blocks.glass));
    }
}
