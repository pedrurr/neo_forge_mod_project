package net.pedrurrr.cyberspacenetrunners;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pedrurrr.cyberspacenetrunners.blocks.FlowingDataBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(CyberspaceNetrunners.MODID)
public class CyberspaceNetrunners {
    // Mod ID
    public static final String MODID = "cyberspacenetrunners";

    // Logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // Deferred Registers
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Blocks

    public static final DeferredBlock<Block> FLOWING_DATA_BLOCK = BLOCKS.register("flowing_data_block", FlowingDataBlock::new);

    public MyMod() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    //public static final DeferredBlock<Block> FLOWING_DATA_BLOCK = BLOCKS.registerSimpleBlock("flowing_data_block",
            BlockBehaviour.Properties.of()
                   // .mapColor(MapColor.COLOR_LIGHT_BLUE)
                   // .sound(SoundType.GLASS)
                   // .lightLevel(state -> 10) // Emits light
                   // .noOcclusion() // Allows light to pass through
                  //  .emissiveRendering((state, world, pos) -> true)); // Makes the texture appear glowing


    // Block Items
    public static final DeferredItem<BlockItem> FLOWING_DATA_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("flowing_data_block", FLOWING_DATA_BLOCK);



    // Items
    public static final DeferredItem<Item> DATA_SHARD = ITEMS.registerSimpleItem("data_shard",
            new Item.Properties().stacksTo(64));

    // Creative Tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CYBERSPACE_TAB = CREATIVE_MODE_TABS.register("cyberspace_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.cyberspacenetrunners")) // Tab title
                    .withTabsBefore(CreativeModeTabs.COMBAT) // Position in the creative menu
                    .icon(() -> DATA_SHARD.get().getDefaultInstance()) // Tab icon
                    .displayItems((parameters, output) -> {
                        output.accept(DATA_SHARD.get()); // Add Data Shard to the tab
                        output.accept(FLOWING_DATA_BLOCK_ITEM.get()); // Add Flowing Data Block to the tab
                    })
                    .build());

    // Constructor
    public CyberspaceNetrunners(IEventBus modEventBus, ModContainer modContainer) {
        // Register deferred registers
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register event listeners
        modEventBus.addListener(this::commonSetup);
    }

    // Common setup
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Cyberspace Netrunners mod is initializing!");
    }
}