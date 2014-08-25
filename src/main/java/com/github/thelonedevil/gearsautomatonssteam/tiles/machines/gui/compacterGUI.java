package com.github.thelonedevil.gearsautomatonssteam.tiles.machines.gui;

import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.containers.compacterContainer;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.containers.crusherContainer;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.CompacterTE;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by justin on 23/08/2014.
 */
public class compacterGUI extends GuiContainer {
    private static final ResourceLocation crusherGuiTextures = new ResourceLocation(Ref.MODID, "textures/gui/container/crusher.png");
    private CompacterTE tileCompacter;
    public compacterGUI(InventoryPlayer invPlayer, CompacterTE tile) {
        super(new compacterContainer(invPlayer, tile));
        this.tileCompacter = tile;

    }
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String string = this.tileCompacter.hasCustomInventoryName() ? this.tileCompacter.getInventoryName() : I18n.format(this.tileCompacter.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);

        String torque = "Current Torque : "+this.tileCompacter.getCurrentTorque();
        this.fontRendererObj.drawString(torque, this.xSize / 2 - this.fontRendererObj.getStringWidth(torque) + 15, this.ySize/3 + 5, 4210752);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(crusherGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;


        i1 = this.tileCompacter.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);



    }
}
