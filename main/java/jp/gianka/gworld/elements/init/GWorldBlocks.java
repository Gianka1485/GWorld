package jp.gianka.gworld.elements.init;

import jp.gianka.gworld.elements.block.KyptoiteOre;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.ToIntFunction;

public class GWorldBlocks {
    public static final DeferredRegister<Block> BLOCKS;
    public static final RegistryObject<Block> KYPTOITE_ORE;

    public GWorldBlocks() {
    }

    static {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "gworld");
        KYPTOITE_ORE = BLOCKS.register("kyptoite_ore", () -> {
            return new KyptoiteOre(Properties.of(Material.STONE, MaterialColor.DIAMOND).strength(5F, 1500F).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel((blockState) -> {
                return 15;
            }), UniformInt.of(10, 20));
        });
    }
}
