package jp.gianka.gworld.elements.tab;

import jp.gianka.gworld.elements.init.GWorldItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class GWorldTab extends CreativeModeTab {
    public GWorldTab() {
        super("gworld");
    }

    public ItemStack makeIcon() {
        return new ItemStack((ItemLike) GWorldItems.KYPTOITE_GEM.get());
    }
}
