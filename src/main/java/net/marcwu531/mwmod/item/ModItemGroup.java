package net.marcwu531.mwmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup MWMOD_GROUP = new ItemGroup("mwModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.MUSHROOM.get());
        }
    };

}
