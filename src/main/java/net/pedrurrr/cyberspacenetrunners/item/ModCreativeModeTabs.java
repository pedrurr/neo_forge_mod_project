package net.pedrurrr.cyberspacenetrunners.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pedrurrr.cyberspacenetrunners.CyberspaceNetrunners;
import net.pedrurrr.cyberspacenetrunners.block.ModBlocks;

import java.util.function.Supplier;



public class ModCreativeModeTabs {
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CyberspaceNetrunners.MOD_ID);

public static final Supplier<CreativeModeTab> CYBERITEMSTAB = CREATIVE_MODE_TAB.register("cyber_items_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DATASHARD.get()))


                .title(Component.translatable("creativetab.cyberspacenetrunners.cyber_items"))
                .displayItems((ItemDisplayParameters, output) ->{
                    output.accept(ModItems.DATASHARD);
                    output.accept(ModItems.DATACHUNK);


                }).build());

public static final Supplier<CreativeModeTab> CYBERBLOCKSTAB = CREATIVE_MODE_TAB.register("cyber_blocks_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DATAPACKAGE.get()))

                .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CyberspaceNetrunners.MOD_ID,"cyber_items_tab"))
                .title(Component.translatable("creativetab.cyberspacenetrunners.cyber_blocks"))
                .displayItems((ItemDisplayParameters, output) ->{
                    output.accept(ModBlocks.DATAPACKAGE);
                    output.accept(ModBlocks.FLOWINGDATA);


                }).build());



public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TAB.register(eventBus);

}
}
