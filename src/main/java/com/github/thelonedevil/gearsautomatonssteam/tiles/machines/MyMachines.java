package com.github.thelonedevil.gearsautomatonssteam.tiles.machines;

import com.github.thelonedevil.gearsautomatonssteam.items.itemblocks.CompacterItem;
import com.github.thelonedevil.gearsautomatonssteam.items.itemblocks.CrusherItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by justin on 18/08/2014.
 */
public class MyMachines {

    public static Block crusher = new Crusher(false).setBlockName("crusher");
    public static Block crusherActive = new Crusher(true).setBlockName("crusherActive");
    public static Block boiler = new Boiler().setBlockName("boiler");
    public static Block steamer = new Steamer().setBlockName("steamer");
    public static Block compacter = new Compacter(false).setBlockName("compacter");
    public static Block compacterActive = new Compacter(true).setBlockName("compacterActive");

    public static void init(){
        GameRegistry.registerBlock(crusher, CrusherItem.class,"crusher");
        GameRegistry.registerBlock(crusherActive,CrusherItem.class,"crusherActive");
        GameRegistry.registerBlock(steamer,"steamer");
        GameRegistry.registerBlock(compacter, CompacterItem.class,"compacter");
        GameRegistry.registerBlock(compacterActive, CompacterItem.class,"compacterActive");
        GameRegistry.registerBlock(boiler,"boiler");
    }
}
