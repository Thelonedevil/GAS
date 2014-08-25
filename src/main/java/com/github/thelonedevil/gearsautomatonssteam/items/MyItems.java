package com.github.thelonedevil.gearsautomatonssteam.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by justin on 21/08/2014.
 */
public class MyItems {

    public static Item crushedIron = new crushedOre("Iron");
    public static Item washedIron = new washedOre("Iron");
    public static Item compactedIron = new compactedOre("Iron");

    public static void init(){

        GameRegistry.registerItem(crushedIron,"oreCrushedIron");
        GameRegistry.registerItem(washedIron,"oreWashedIron");
        GameRegistry.registerItem(compactedIron,"oreCompactedIron");
    }
}
