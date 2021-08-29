package jp.gianka.gworld.elements.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class OreFeature implements FeatureConfiguration {
    public static final Codec<OreFeature> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(RuleTest.CODEC.fieldOf("target").forGetter((config) -> {
            return config.target;
        }), BlockState.CODEC.fieldOf("state").forGetter((config) -> {
            return config.state;
        }), Codec.intRange(0, 64).fieldOf("size").forGetter((config) -> {
            return config.size;
        })).apply(instance, OreFeature::new);
    });
    public final RuleTest target;
    public final int size;
    public final BlockState state;

    public OreFeature(RuleTest target, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = target;
    }

    public static final class FillerBlockType {
        public static final RuleTest DEEPSLATE_ONLY;
        public static final RuleTest ENDSTONE_ONLY;

        public FillerBlockType() {
        }

        static {
            DEEPSLATE_ONLY = new BlockMatchTest(Blocks.DEEPSLATE);
            ENDSTONE_ONLY = new BlockMatchTest(Blocks.END_STONE);
        }
    }
}
