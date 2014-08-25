package com.github.thelonedevil.gearsautomatonssteam.tiles.machines;

import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.BoilerTE;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.interfaces.ISteamProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by justin on 18/08/2014.
 */
public class Boiler extends BaseMachine {
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new BoilerTE();
    }


}
