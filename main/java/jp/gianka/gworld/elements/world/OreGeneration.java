package jp.gianka.gworld.elements.world;

import com.google.common.collect.ImmutableList;
import jp.gianka.gworld.elements.config.GWorldConfig;
import jp.gianka.gworld.elements.init.GWorldBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.Predicates;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OreGeneration {
    public static ImmutableList<TargetBlockState> KYPTOITE_ORE_TARGET_LIST;
    public static ConfiguredFeature<?, ?> KYPTOITE_ORE;

    public OreGeneration() {
    }

    public static void registerConfiguredFeatures() {
        KYPTOITE_ORE_TARGET_LIST = ImmutableList.of(OreConfiguration.target(Predicates.NATURAL_STONE, ((Block) GWorldBlocks.KYPTOITE_ORE.get()).defaultBlockState()), OreConfiguration.target(Predicates.STONE_ORE_REPLACEABLES, ((Block) GWorldBlocks.KYPTOITE_ORE.get()).defaultBlockState()));
        KYPTOITE_ORE = (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE.configured(new OreConfiguration(KYPTOITE_ORE_TARGET_LIST, (Integer) GWorldConfig.KYPTOITE_ORE_SIZE.get())).rangeUniform(VerticalAnchor.absolute((Integer) GWorldConfig.KYPTOITE_ORE_MIN_HEIGHT.get()), VerticalAnchor.absolute((Integer) GWorldConfig.KYPTOITE_ORE_MAX_HEIGHT.get()))).squared()).count((Integer) GWorldConfig.KYPTOITE_ORE_CHANCE.get());
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("gworld", "kyptoite_ore"), KYPTOITE_ORE);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerBiomeModification(BiomeLoadingEvent event) {
        event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES).add(() -> {
            return KYPTOITE_ORE;
        });
    }
}