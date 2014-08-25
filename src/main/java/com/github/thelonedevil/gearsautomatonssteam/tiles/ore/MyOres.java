package com.github.thelonedevil.gearsautomatonssteam.tiles.ore;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by justin on 18/08/2014.
 */
public class MyOres {
    public static Block ore_Copper = new BaseOre().setBlockName("ore_Copper").setBlockTextureName("ore_Copper");
    public static Block ore_Zinc = new BaseOre().setBlockName("ore_Zinc").setBlockTextureName("ore_Zinc");
    public static Block ore_Arsenic = new BaseOre().setBlockName("ore_Arsenic").setBlockTextureName("ore_Arsenic");

    public static void init(){
        GameRegistry.registerBlock(ore_Copper,"ore_Copper");
        GameRegistry.registerBlock(ore_Zinc,"ore_Zinc");
        GameRegistry.registerBlock(ore_Arsenic,"oreArsenic");
    }

}
