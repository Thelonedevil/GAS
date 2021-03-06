package com.github.thelonedevil.gearsautomatonssteam;

import com.github.thelonedevil.gearsautomatonssteam.generation.CustomGenerator;

import com.github.thelonedevil.gearsautomatonssteam.items.MyItems;
import com.github.thelonedevil.gearsautomatonssteam.tiles.fluid.MyFluids;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.MyMachines;
import com.github.thelonedevil.gearsautomatonssteam.tiles.ore.MyOres;
import com.github.thelonedevil.gearsautomatonssteam.proxy.CommonProxy;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.LogHelper;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;


/**
 * Created by justin on 18/08/2014.
 */
@Mod(modid=Ref.MODID, version=Ref.VERSION, name = Ref.NAME)
public class GASMain {
    @Instance(Ref.MODID)
    public static GASMain instance;

    @SidedProxy(clientSide = "com.github.thelonedevil.gearsautomatonssteam.proxy.ClientProxy", serverSide = "com.github.thelonedevil.gearsautomatonssteam.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs Tab1 = new CreativeTabs("GAS - World Gen") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.bedrock);
        }
    };
    public static CreativeTabs Tab2 = new CreativeTabs("GAS - Machines") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.bedrock);
        }
    };
    public static CreativeTabs Tab3 = new CreativeTabs("GAS - Ore") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.bedrock);
        }
    };
    public static CustomGenerator worldgen = new CustomGenerator();

    @EventHandler
    public static void onPreInit(FMLPreInitializationEvent event){
        MyOres.init();
        MyItems.init();
        MyMachines.init();
        MyFluids.init();
        MyRecipes.init();
        proxy.registerTileEntities();
        proxy.registerItemRenderers();
        GameRegistry.registerWorldGenerator(worldgen, 9);
        LogHelper.info("Pre-Initialisation Complete");
    }
    @EventHandler
    public static void load(FMLInitializationEvent event) {
        proxy.registerNetworkStuff();
    }



}
