package com.github.thelonedevil.gearsautomatonssteam.proxy;

import com.github.thelonedevil.gearsautomatonssteam.GASMain;
import com.github.thelonedevil.gearsautomatonssteam.handler.GUIHandler;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.BoilerTE;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.CompacterTE;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.CrusherTE;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.SteamerTE;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by justin on 14/08/2014.
 */
public class CommonProxy {

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(CrusherTE.class, "CrusherTE");
        GameRegistry.registerTileEntity(SteamerTE.class, "SteamerTE");
        GameRegistry.registerTileEntity(CompacterTE.class, "CompacterTE");
        GameRegistry.registerTileEntity(BoilerTE.class, "BoilerTE");
    }

    public void registerNetworkStuff() {
        NetworkRegistry.INSTANCE.registerGuiHandler(GASMain.instance, new GUIHandler());
    }

    public void registerItemRenderers(){

    }
}
