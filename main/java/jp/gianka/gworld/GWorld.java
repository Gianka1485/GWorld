package jp.gianka.gworld;

import jp.gianka.gworld.elements.config.GWorldConfig;
import jp.gianka.gworld.elements.init.GWorldBlocks;
import jp.gianka.gworld.elements.init.GWorldItems;
import jp.gianka.gworld.elements.tab.GWorldTab;
import jp.gianka.gworld.elements.world.OreGeneration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GWorld.modid)
public class GWorld {
    public static final String modid = "gworld";
    private static final Logger LOGGER = LogManager.getLogger("gworld");
    public static final CreativeModeTab gworld = new GWorldTab();

    public GWorld() {
        IEventBus modEventbus = FMLJavaModLoadingContext.get().getModEventBus();

        GWorldBlocks.BLOCKS.register(modEventbus);
        GWorldItems.ITEMS.register(modEventbus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        ModLoadingContext.get().registerConfig(Type.COMMON, GWorldConfig.SPEC, "gworld-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            OreGeneration.registerConfiguredFeatures();
        });
        LOGGER.info("Hello from preinit");
        LOGGER.info("Dirt block >> {}", Blocks.DIRT.getRegistryName());
    }

    @OnlyIn(Dist.CLIENT)
    public void clientSetup(FMLClientSetupEvent event) {
        LOGGER.info("Hello from client setup");
    }

    @SubscribeEvent
    public void serverStarting(FMLServerStartingEvent event) {
        LOGGER.info("Hello from server starting");
    }

    @EventBusSubscriber(bus = Bus.MOD)
    public static class RegistryEvents {
        public RegistryEvents() {
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            LOGGER.info("Hello from Register Block");
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            LOGGER.info("Hello from Register Item");
        }
    }
}
