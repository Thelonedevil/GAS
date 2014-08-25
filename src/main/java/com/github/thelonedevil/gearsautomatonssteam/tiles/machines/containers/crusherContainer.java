package com.github.thelonedevil.gearsautomatonssteam.tiles.machines.containers;

import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity.CrusherTE;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.recipes.CrusherRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Created by justin on 19/08/2014.
 */
public class crusherContainer extends Container {

    private CrusherTE tile;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public crusherContainer(InventoryPlayer player, CrusherTE tile) {
        this.tile = tile;
        this.addSlotToContainer(new Slot(tile, 0, 55, 34));
        this.addSlotToContainer(new SlotFurnace(player.player, tile, 1, 116, 35));
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
    }
    public void addCraftingToCrafters(ICrafting p_75132_1_)
    {
        super.addCraftingToCrafters(p_75132_1_);
        p_75132_1_.sendProgressBarUpdate(this, 0, this.tile.furnaceCookTime);
        p_75132_1_.sendProgressBarUpdate(this, 1, this.tile.furnaceBurnTime);
        p_75132_1_.sendProgressBarUpdate(this, 2, this.tile.currentItemBurnTime);
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.tile.furnaceCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tile.furnaceCookTime);
            }

            if (this.lastBurnTime != this.tile.furnaceBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tile.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.tile.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tile.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.tile.furnaceCookTime;
        this.lastBurnTime = this.tile.furnaceBurnTime;
        this.lastItemBurnTime = this.tile.currentItemBurnTime;
    }
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_)
    {
        if (p_75137_1_ == 0)
        {
            this.tile.furnaceCookTime = p_75137_2_;
        }

        if (p_75137_1_ == 1)
        {
            this.tile.furnaceBurnTime = p_75137_2_;
        }

        if (p_75137_1_ == 2)
        {
            this.tile.currentItemBurnTime = p_75137_2_;
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 1)
            {
                if (!this.mergeItemStack(itemstack1, 3, 38, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ != 0)
            {
                if (CrusherRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 3 && p_82846_2_ < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 38, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 30 && p_82846_2_ < 38 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 38, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }
}
