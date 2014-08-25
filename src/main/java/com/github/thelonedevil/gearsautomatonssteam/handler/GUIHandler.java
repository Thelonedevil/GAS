package com.github.thelonedevil.gearsautomatonssteam.handler;

import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.containers.compacterContainer;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.containers.crusherContainer;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.CompacterTE;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.CrusherTE;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.gui.compacterGUI;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.gui.crusherGUI;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by justin on 18/08/2014.
 */
public class GUIHandler implements IGuiHandler {

    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID){
            case Ref.CRUSHER_GUI_ID:
                CrusherTE tileEntityFurnace = (CrusherTE) world.getTileEntity(x, y, z);
                return new crusherContainer(player.inventory, tileEntityFurnace);
            case Ref.COMPACTER_GUI_ID:
                CompacterTE tile = (CompacterTE) world.getTileEntity(x,y,z);
                return new compacterContainer(player.inventory, tile);
            default: return null;
        }
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID){
            case Ref.CRUSHER_GUI_ID:
                CrusherTE tileEntityFurnace = (CrusherTE) world.getTileEntity(x, y, z);
                return new crusherGUI(player.inventory, tileEntityFurnace);
            case Ref.COMPACTER_GUI_ID:
                CompacterTE tile = (CompacterTE) world.getTileEntity(x,y,z);
                return new compacterGUI(player.inventory, tile);
            default: return null;
        }
    }
}
