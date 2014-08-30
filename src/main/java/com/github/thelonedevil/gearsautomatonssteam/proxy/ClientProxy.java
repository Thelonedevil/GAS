package com.github.thelonedevil.gearsautomatonssteam.proxy;

import com.github.thelonedevil.gearsautomatonssteam.RenderTransparentItem;
import com.github.thelonedevil.gearsautomatonssteam.tiles.fluid.MyFluids;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by justin on 14/08/2014.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemRenderers() {
        super.registerItemRenderers();
        MinecraftForgeClient.registerItemRenderer(MyFluids.steamBottle, new RenderTransparentItem());
    }
}
