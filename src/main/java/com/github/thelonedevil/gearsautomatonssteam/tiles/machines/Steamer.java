package com.github.thelonedevil.gearsautomatonssteam.tiles.machines;

import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.SteamerTE;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by justin on 18/08/2014.
 */
public class Steamer extends BaseMachine {
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new SteamerTE();
    }
}
