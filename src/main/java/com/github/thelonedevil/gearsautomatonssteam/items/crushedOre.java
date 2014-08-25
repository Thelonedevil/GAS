package com.github.thelonedevil.gearsautomatonssteam.items;

import com.github.thelonedevil.gearsautomatonssteam.GASMain;
import net.minecraft.item.Item;

/**
 * Created by justin on 18/08/2014.
 */
public class crushedOre extends Item {

    public crushedOre(String type){
        this.setCreativeTab(GASMain.Tab3);
        this.setUnlocalizedName("oreCrushed"+type);
        this.setTextureName("oreCrushed"+type);
    }
}
