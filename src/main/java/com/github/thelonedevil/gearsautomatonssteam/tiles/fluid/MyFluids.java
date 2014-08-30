package com.github.thelonedevil.gearsautomatonssteam.tiles.fluid;

import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.Blocks;
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
    public static Item steamBottle;
    public static Item steamBottleEmpty;
    public static final Material steamMaterial = (new MaterialLiquid(MapColor.waterColor));

    public static void init(){

        FluidRegistry.registerFluid(steam);
        steamBlock =  new Steam(steam, steamMaterial).setBlockName("steamBlock");
        GameRegistry.registerBlock(steamBlock, "steamBlock");
        steamBottleEmpty = new SteamBottle(Blocks.air).setUnlocalizedName("steamBottle").setTextureName(Ref.MODID+":steamBottleEmpty");
        GameRegistry.registerItem(steamBottleEmpty,"steamBottleEmpty");
        steamBottle = new SteamBottle(steamBlock).setUnlocalizedName("steamBottle").setContainerItem(steamBottleEmpty).setTextureName(Ref.MODID+":steamBottle");
        GameRegistry.registerItem(steamBottle, "steamBottle");
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("steam", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(steamBottle), new ItemStack(steamBottleEmpty));

    }
}
