package jp.gianka.gworld.elements.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class GWorldConfig {
    public static final Builder BUILDER = new Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ConfigValue<Boolean> KYPTOITE_ORE_GENERATION;
    public static final ConfigValue<Integer> KYPTOITE_ORE_SIZE;
    public static final ConfigValue<Integer> KYPTOITE_ORE_MIN_HEIGHT;
    public static final ConfigValue<Integer> KYPTOITE_ORE_MAX_HEIGHT;
    public static final ConfigValue<Integer> KYPTOITE_ORE_CHANCE;

    public GWorldConfig() {
    }

    static {
        BUILDER.push("Kyptoite ore generation");
        KYPTOITE_ORE_GENERATION = BUILDER.define("Generate kyptoite ore", true);
        KYPTOITE_ORE_SIZE = BUILDER.define("Kyptoite ore vein size", 4);
        KYPTOITE_ORE_MIN_HEIGHT = BUILDER.define("Minimum kyptoite ore generation height", 0);
        KYPTOITE_ORE_MAX_HEIGHT = BUILDER.define("Maximum kyptoite ore generation height", 16);
        KYPTOITE_ORE_CHANCE = BUILDER.define("Chance of generate kyptoite ore", 1);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
