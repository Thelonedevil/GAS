package com.github.thelonedevil.gearsautomatonssteam.tiles.machines.entity;

import com.github.thelonedevil.gearsautomatonssteam.items.washedOre;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.Compacter;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.Crusher;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.interfaces.ITorquePowered;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.recipes.CompacterRecipes;
import com.github.thelonedevil.gearsautomatonssteam.tiles.machines.recipes.CrusherRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by justin on 18/08/2014.
 */
public class CompacterTE extends TileEntity implements ISidedInventory, ITorquePowered {
    private String name = "Compacter";

    private int currentTorque = 10;
    /**
     * The number of ticks that the furnace will keep burning
     */
    public int furnaceBurnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int currentItemBurnTime = getCurrentTorque();
    /**
     * The number of ticks that the current item has been cooking for
     */
    public int furnaceCookTime;
    private ItemStack[] stacks = new ItemStack[2];

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return true;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return stacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return stacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        if (this.stacks[p_70298_1_] != null) {
            ItemStack itemstack;

            if (this.stacks[p_70298_1_].stackSize <= p_70298_2_) {
                itemstack = this.stacks[p_70298_1_];
                this.stacks[p_70298_1_] = null;
                return itemstack;
            } else {
                itemstack = this.stacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.stacks[p_70298_1_].stackSize == 0) {
                    this.stacks[p_70298_1_] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        stacks[slot] = stack;
    }

    @Override
    public String getInventoryName() {
        return name;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        switch (slot) {
            case 0:
                return stack.getItem() instanceof washedOre;
            default:
                return false;
        }
    }

    /**
     * @return the minumum amount of torque required to function
     */
    @Override
    public int getMinTorque() {
        return 0;
    }

    /**
     * @return the maxium amount of torque machine can handle (will normally be MAX_INTEGER)
     */
    @Override
    public int getMaxTorque() {
        return 0;
    }

    /**
     * @return the current amount of torque
     */
    @Override
    public int getCurrentTorque() {
        return currentTorque;
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int p_145953_1_) {
        return this.furnaceCookTime * p_145953_1_ / 2000;
    }

    public void setInvName(String s) {
        this.name = s;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity() {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote) {
            if (this.furnaceBurnTime != 0 || this.stacks[0] != null) {
                if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                    this.currentItemBurnTime = this.furnaceBurnTime = getCurrentTorque();

                    if (this.furnaceBurnTime > 0) {
                        flag1 = true;


                    }
                }

                if (this.isBurning() && this.canSmelt()) {

                    this.furnaceCookTime += currentTorque;

                    if (this.furnaceCookTime == 2000) {
                        this.furnaceCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                } else {
                    this.furnaceCookTime = 0;
                }
            }

            if (flag != this.furnaceBurnTime > 0) {
                flag1 = true;
                Compacter.updateBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt() {
        if (this.stacks[0] == null) {
            return false;
        } else {
            ItemStack itemstack = CompacterRecipes.smelting().getSmeltingResult(this.stacks[0]);
            if (itemstack == null) return false;
            if (this.stacks[1] == null) return true;
            if (!this.stacks[1].isItemEqual(itemstack)) return false;
            int result = stacks[1].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.stacks[1].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = CompacterRecipes.smelting().getSmeltingResult(this.stacks[0]);

            if (this.stacks[1] == null) {
                this.stacks[1] = itemstack.copy();
            } else if (this.stacks[1].getItem() == itemstack.getItem()) {
                this.stacks[1].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.stacks[0].stackSize;

            if (this.stacks[0].stackSize <= 0) {
                this.stacks[0] = null;
            }
        }
    }

    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.stacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.stacks.length) {
                this.stacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = p_145839_1_.getShort("BurnTime");
        this.furnaceCookTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getCurrentTorque();

        if (p_145839_1_.hasKey("CustomName", 8)) {
            this.name = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short) this.furnaceBurnTime);
        p_145841_1_.setShort("CookTime", (short) this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.stacks.length; ++i) {
            if (this.stacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.stacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName()) {
            p_145841_1_.setString("CustomName", this.name);
        }
    }
}