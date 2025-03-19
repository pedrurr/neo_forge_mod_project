package net.pedrurrr.cyberspacenetrunners.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pedrurrr.cyberspacenetrunners.CyberspaceNetrunners;
import net.pedrurrr.cyberspacenetrunners.item.ModItems;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister
                        .Blocks BLOCKS =
                        DeferredRegister
                        .createBlocks(CyberspaceNetrunners.MOD_ID); //data_package

    public static final DeferredBlock<Block> DATAPACKAGE = registerBlock("datapackage_block",
             () -> new Block(BlockBehaviour.Properties.of()
                 .strength(6f)
                 .requiresCorrectToolForDrops()
                 .sound(SoundType.COPPER_BULB)

             ));



    public static final DeferredBlock<Block> FLOWINGDATA = registerBlock("flowingdata_block",
             () -> new FlowingDataBlock(BlockBehaviour.Properties.of() //usando flowingdatablock no lugar de block explicação abaixo
                 .strength(1f)
                 .requiresCorrectToolForDrops()
                 .sound(SoundType.SHROOMLIGHT)
                 .isViewBlocking((state, world, pos) -> false)
                 .noOcclusion()
                 .lightLevel(state -> 10)

             ));

    public static class FlowingDataBlock extends Block { //extends blocks entao o bloco tem q usar essa classe no lugar de block na classe do bloco
        public FlowingDataBlock(Properties properties) {
            super(properties);
        }

        @Override
        public boolean hidesNeighborFace(BlockGetter world, BlockPos pos, BlockState state, BlockState neighborState, Direction dir) {
            return neighborState.is(this);
        }
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS
                .register(name, block);
                registerBlockItem(name, toReturn);
        return toReturn;
    }




    private static <T extends Block> void  registerBlockItem(String name, DeferredBlock<T> block){
                ModItems.ITEMS
                .register(name, () -> new BlockItem(block.get(), new Item.Properties()

                ));

    }

    public static void register(IEventBus eventBus) {
                BLOCKS
                .register(eventBus);

    }


}
