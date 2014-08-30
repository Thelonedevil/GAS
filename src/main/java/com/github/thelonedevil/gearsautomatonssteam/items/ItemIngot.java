package com.github.thelonedevil.gearsautomatonssteam.items;

import com.github.thelonedevil.gearsautomatonssteam.GASMain;
import com.github.thelonedevil.gearsautomatonssteam.utlitiy.Ref;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by justin on 26/08/2014.
 */
public class ItemIngot extends Item {

    public ItemIngot(String name){
        this.setUnlocalizedName("ingot" + name).setCreativeTab(GASMain.Tab3).setTextureName(Ref.MODID+":ingot"+name);
    }
}
