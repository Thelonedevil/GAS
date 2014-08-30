package com.github.thelonedevil.gearsautomatonssteam.items;

import com.github.thelonedevil.gearsautomatonssteam.GASMain;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import net.minecraft.item.Item;

/**
 * Created by justin on 18/08/2014.
 */
public class washedOre extends Item {

    public washedOre(String type){
        this.setCreativeTab(GASMain.Tab3);
        this.setUnlocalizedName("oreWashed"+type);
        this.setTextureName(Ref.MODID+":oreWashed"+type);
    }
}
