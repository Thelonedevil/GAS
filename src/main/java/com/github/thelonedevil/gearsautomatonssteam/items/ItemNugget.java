package com.github.thelonedevil.gearsautomatonssteam.items;

import com.github.thelonedevil.gearsautomatonssteam.GASMain;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import net.minecraft.item.Item;

/**
 * Created by justin on 26/08/2014.
 */
public class ItemNugget extends Item {

    public ItemNugget(String name){
        this.setUnlocalizedName("nugget" + name).setCreativeTab(GASMain.Tab3).setTextureName(Ref.MODID+":nugget"+name);
    }
}
