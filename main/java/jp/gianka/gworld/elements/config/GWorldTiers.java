package jp.gianka.gworld.elements.config;

import jp.gianka.gworld.elements.init.GWorldItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public enum GWorldTiers implements Tier {
    KYPTOITE_TOOL(5, 2500, 15.0F, 5.0F, 25, () -> {
        return Ingredient.of(new ItemLike[]{(ItemLike) GWorldItems.KYPTOITE_GEM.get()});
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    private GWorldTiers(int level, int uses, float speed, float attackDamageBonus, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = (Ingredient) repairIngredient.get();
    }

    public int getLevel() {
        return this.level;
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
