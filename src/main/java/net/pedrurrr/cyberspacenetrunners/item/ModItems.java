package net.pedrurrr.cyberspacenetrunners.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pedrurrr.cyberspacenetrunners.CyberspaceNetrunners;

public class ModItems {
    public static final DeferredRegister
                        .Items ITEMS = DeferredRegister
                        .createItems( CyberspaceNetrunners.MOD_ID );


    public static final DeferredItem<Item> DATASHARD = ITEMS
            .register ("data_shard",
            () -> new Item ( new Item.Properties() )

                      ) ;
    public static final DeferredItem<Item> DATACHUNK = ITEMS
            .register ("data_chunk", () -> new Item ( new Item.Properties() )

                      ) ;



    public static void register ( IEventBus eventBus )  {
        ITEMS.register ( eventBus ) ;
                                                        }

}
