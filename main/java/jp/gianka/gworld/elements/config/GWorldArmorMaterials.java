package jp.gianka.gworld.elements.config;

import jp.gianka.gworld.GWorld;
import jp.gianka.gworld.elements.init.GWorldItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public enum GWorldArmorMaterials implements ArmorMaterial {
    KYPTOITE("kyptoite", 200, new int[]{4, 7, 9, 4}, 30, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.2F, () -> {
        return Ingredient.of(new ItemLike[]{(ItemLike) GWorldItems.KYPTOITE_GEM.get()});
    });

    private static final int[] baseDurability = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockBackResistance;
    private final Ingredient repairIngredient;

    private GWorldArmorMaterials(String name, int durabilityMultiplier, int[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, float toughness, float knockBackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = defenseForSlot;
        this.enchantmentValue = enchantmentValue;
        this.sound = equipSound;
        this.toughness = toughness;
        this.knockBackResistance = knockBackResistance;
        this.repairIngredient = (Ingredient) repairIngredient.get();
    }

    public int getDurabilityForSlot(EquipmentSlot slot) {
        return baseDurability[slot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    public String getName() {
        return GWorld.modid + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockBackResistance;
    }
}
