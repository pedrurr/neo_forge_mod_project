package net.pedrurrr.cyberspacenetrunners.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pedrurrr.cyberspacenetrunners.CyberspaceNetrunners;
import net.pedrurrr.cyberspacenetrunners.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CyberspaceNetrunners.MOD_ID);

    public static final DeferredBlock<Block> DATAPACKAGE = registerBlock("data_package",
        () -> new Block(BlockBehaviour.Properties.of()
                .strength(2f).requiresCorrectToolForDrops().sound(SoundType.WET_SPONGE)));

    public static final DeferredBlock<Block> FLOWINGDATA = registerBlock("flowing_data",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.HONEY_BLOCK)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void  registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }


}
