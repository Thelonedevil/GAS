package com.github.thelonedevil.gearsautomatonssteam.tiles.fluid;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by justin on 21/08/2014.
 */
public class MyFluids {

    public static Fluid steam = new Fluid("steam").setGaseous(true).setDensity(-200).setTemperature(373);
    public static Block steamBlock;
    public static Item yourBucket ;

    public static void init(){
        FluidRegistry.registerFluid(steam);
        steamBlock =  new Steam(steam, Material.water).setBlockName("steamBlock");
        GameRegistry.registerBlock(steamBlock, "steamBlock");
        yourBucket = new SteamBottle(steamBlock).setUnlocalizedName("steamBottle").setContainerItem(Items.bucket);
        GameRegistry.registerItem(yourBucket, "steamBottle");
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("steam", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(yourBucket), new ItemStack(Items.bucket));

    }
}
