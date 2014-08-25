package com.github.thelonedevil.gearsautomatonssteam.tiles.machines;

import com.github.thelonedevil.gearsautomatonssteam.GASMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by justin on 18/08/2014.
 */
public abstract class BaseMachine extends BlockContainer implements ITileEntityProvider {

   public BaseMachine(){
        super(Material.iron);
       this.setCreativeTab(GASMain.Tab2);
    }
    @Override
    public abstract TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_);
}
