package com.github.thelonedevil.gearsautomatonssteam.items;

import com.github.thelonedevil.gearsautomatonssteam.GASMain;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import net.minecraft.item.Item;

/**
 * Created by justin on 23/08/2014.
 */
public class compactedOre  extends Item {

    public compactedOre(String type){
        this.setCreativeTab(GASMain.Tab3);
        this.setUnlocalizedName("oreCompacted"+type);
        this.setTextureName(Ref.MODID+":oreCompacted"+type);
    }
}
