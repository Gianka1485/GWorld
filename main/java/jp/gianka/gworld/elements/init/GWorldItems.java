package jp.gianka.gworld.elements.init;

import jp.gianka.gworld.GWorld;
import jp.gianka.gworld.elements.config.GWorldArmorMaterials;
import jp.gianka.gworld.elements.config.GWorldTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GWorldItems {
    public static final DeferredRegister<Item> ITEMS;

    public static final RegistryObject<Item> KYPTOITE_DUST;
    public static final RegistryObject<Item> KYPTOITE_GEM;
    public static final RegistryObject<Item> KYPTOITE_ORE;
    public static final RegistryObject<ArmorItem> KYPTOITE_HELMET;
    public static final RegistryObject<ArmorItem> KYPTOITE_CHESTPLATE;
    public static final RegistryObject<ArmorItem> KYPTOITE_LEGGINGS;
    public static final RegistryObject<ArmorItem> KYPTOITE_BOOTS;
    public static final RegistryObject<AxeItem> KYPTOITE_AXE;
    public static final RegistryObject<HoeItem> KYPTOITE_HOE;
    public static final RegistryObject<PickaxeItem> KYPTOITE_PICKAXE;
    public static final RegistryObject<ShovelItem> KYPTOITE_SHOVEL;
    public static final RegistryObject<SwordItem> KYPTOITE_SWORD;

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "gworld");

        KYPTOITE_DUST = ITEMS.register("kyptoite_dust", () -> {
            return new Item((new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_GEM = ITEMS.register("kyptoite_gem", () -> {
            return new Item((new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_ORE = ITEMS.register("kyptoite_ore", () -> {
            return new BlockItem((Block) GWorldBlocks.KYPTOITE_ORE.get(), (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_HELMET = ITEMS.register("kyptoite_helmet", () -> {
            return new ArmorItem(GWorldArmorMaterials.KYPTOITE, EquipmentSlot.HEAD, (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_CHESTPLATE = ITEMS.register("kyptoite_chestplate", () -> {
            return new ArmorItem(GWorldArmorMaterials.KYPTOITE, EquipmentSlot.CHEST, (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_LEGGINGS = ITEMS.register("kyptoite_leggings", () -> {
            return new ArmorItem(GWorldArmorMaterials.KYPTOITE, EquipmentSlot.LEGS, (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_BOOTS = ITEMS.register("kyptoite_boots", () -> {
            return new ArmorItem(GWorldArmorMaterials.KYPTOITE, EquipmentSlot.FEET, (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_AXE = ITEMS.register("kyptoite_axe", () -> {
            return new AxeItem(GWorldTiers.KYPTOITE_TOOL, 5.0F, -3.0F, (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_HOE = ITEMS.register("kyptoite_hoe", () -> {
            return new HoeItem(GWorldTiers.KYPTOITE_TOOL, -5, 0.0F, (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_PICKAXE = ITEMS.register("kyptoite_pickaxe", () -> {
            return new PickaxeItem(GWorldTiers.KYPTOITE_TOOL, 1, -2.8F, (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_SHOVEL = ITEMS.register("kyptoite_shovel", () -> {
            return new ShovelItem(GWorldTiers.KYPTOITE_TOOL, 1.5F, -3.0F, (new Properties()).tab(GWorld.gworld));
        });
        KYPTOITE_SWORD = ITEMS.register("kyptoite_sword", () -> {
            return new SwordItem(GWorldTiers.KYPTOITE_TOOL, 3, -2.4F, (new Properties()).tab(GWorld.gworld));
        });
    }
}
