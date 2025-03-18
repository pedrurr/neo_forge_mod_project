package net.pedrurrr.cyberspacenetrunners.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FlowingDataBlock extends Block {
    public static final BooleanProperty TOUCHING_AIR = BooleanProperty.create("touching_air");

    public FlowingDataBlock() {
        super(Properties.of(Material.GLASS, MaterialColor.NONE)
                .noOcclusion()
                .strength(0.5f)
                .lightLevel(state -> state.getValue(TOUCHING_AIR) ? 15 : 0)
                .isRedstoneConductor((state, world, pos) -> false)
                .isSuffocating((state, world, pos) -> false)
                .isViewBlocking((state, world, pos) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(TOUCHING_AIR, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOUCHING_AIR);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return state.getValue(TOUCHING_AIR) ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        boolean touchingAir = world.isEmptyBlock(pos.relative(direction));
        return state.setValue(TOUCHING_AIR, touchingAir);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }
}