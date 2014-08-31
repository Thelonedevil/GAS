package com.github.thelonedevil.gearsautomatonssteam.items;

import com.github.thelonedevil.gearsautomatonssteam.GASMain;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import net.minecraft.item.Item;

/**
 * Created by justin on 30/08/2014.
 */
public class Crank extends Item {

    public Crank(){
        this.setCreativeTab(GASMain.Tab2);
        this.setUnlocalizedName("crank");
        this.setTextureName(Ref.MODID+":crank");
        this.setMaxDamage(5);
        this.setMaxStackSize(1);
    }
}
