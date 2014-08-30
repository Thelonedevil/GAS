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
    public static Item nuggetIron = new ItemNugget("Iron");

    public static Item compactedBrass = new compactedOre("Brass");
    public static Item ingotBrass = new ItemIngot("Brass");
    public static Item nuggetBrass = new ItemNugget("Brass");

    public static Item compactedDZR = new compactedOre("DZR");
    public static Item ingotDZR = new ItemIngot("DZR");
    public static Item nuggetDZR = new ItemNugget("DZR");
    
    public static Item crushedCopper = new crushedOre("Copper");
    public static Item washedCopper = new washedOre("Copper");
    public static Item compactedCopper=new compactedOre("Copper");
    public static Item ingotCopper = new ItemIngot("Copper");
    public static Item nuggetCopper = new ItemNugget("Copper");
    
    public static Item crushedZinc = new crushedOre("Zinc");
    public static Item washedZinc = new washedOre("Zinc");
    public static Item compactedZinc=new compactedOre("Zinc");
    public static Item ingotZinc = new ItemIngot("Zinc");
    public static Item nuggetZinc = new ItemNugget("Zinc");
    
    public static Item crushedArsenic = new crushedOre("Arsenic");
    public static Item washedArsenic = new washedOre("Arsenic");
    public static Item compactedArsenic=new compactedOre("Arsenic");
    public static Item ingotArsenic = new ItemIngot("Arsenic");
    public static Item nuggetArsenic = new ItemNugget("Arsenic");

    public static Item crank = new Crank();
    
    public static void init(){

        GameRegistry.registerItem(crushedIron,"oreCrushedIron");
        GameRegistry.registerItem(washedIron,"oreWashedIron");
        GameRegistry.registerItem(compactedIron,"oreCompactedIron");
        GameRegistry.registerItem(nuggetIron,"nuggetIron");

        GameRegistry.registerItem(crushedCopper,"oreCrushedCopper");
        GameRegistry.registerItem(washedCopper,"oreWashedCopper");
        GameRegistry.registerItem(compactedCopper,"oreCompactedCopper");
        GameRegistry.registerItem(ingotCopper,"ingotCopper");
        GameRegistry.registerItem(nuggetCopper,"nuggetCopper");

        GameRegistry.registerItem(crushedZinc,"oreCrushedZinc");
        GameRegistry.registerItem(washedZinc,"oreWashedZinc");
        GameRegistry.registerItem(compactedZinc,"oreCompactedZinc");
        GameRegistry.registerItem(ingotZinc,"ingotZinc");
        GameRegistry.registerItem(nuggetZinc,"nuggetZinc");

        GameRegistry.registerItem(crushedArsenic,"oreCrushedArsenic");
        GameRegistry.registerItem(washedArsenic,"oreWashedArsenic");
        GameRegistry.registerItem(compactedArsenic,"oreCompactedArsenic");
        GameRegistry.registerItem(ingotArsenic,"ingotArsenic");
        GameRegistry.registerItem(nuggetArsenic,"nuggetArsenic");

        GameRegistry.registerItem(compactedBrass,"oreCompactedBrass");
        GameRegistry.registerItem(ingotBrass,"ingotBrass");
        GameRegistry.registerItem(nuggetBrass,"nuggetBrass");
        
        GameRegistry.registerItem(compactedDZR,"oreCompactedDZR");
        GameRegistry.registerItem(ingotDZR,"ingotDZR");
        GameRegistry.registerItem(nuggetDZR,"nuggetDZR");
        GameRegistry.registerItem(crank,"Crank");
    }
}
