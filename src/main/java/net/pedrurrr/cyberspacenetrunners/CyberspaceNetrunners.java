package net.pedrurrr.cyberspacenetrunners;

//import net.pedrurrr.cyberspacenetrunners.Config;
//import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
//import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.pedrurrr.cyberspacenetrunners.block.ModBlocks;
import net.pedrurrr.cyberspacenetrunners.item.ModCreativeModeTabs;
import net.pedrurrr.cyberspacenetrunners.item.ModItems;
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
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod ( CyberspaceNetrunners.MOD_ID )
public class CyberspaceNetrunners {
    public static final String MOD_ID = "cyberspacenetrunners" ;
    private static final Logger LOGGER = LogUtils.getLogger() ;


    public CyberspaceNetrunners ( IEventBus modEventBus, ModContainer modContainer ) {
        modEventBus.addListener ( this::commonSetup ) ;
        NeoForge.EVENT_BUS.register ( this ) ;

        ModCreativeModeTabs.register ( modEventBus ) ;

        ModItems.register ( modEventBus ) ;
        ModBlocks.register ( modEventBus ) ;

        //modEventBus.addListener ( this::addCreative ) ;
        modContainer.registerConfig ( ModConfig.Type.COMMON, Config.SPEC ) ;


                                                                                   }



    private void commonSetup ( final FMLCommonSetupEvent event ) {


                                                                 }




    @SubscribeEvent
    public void onServerStarting ( ServerStartingEvent event ) {


                                                               }



    @EventBusSubscriber ( modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT )
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup ( FMLClientSetupEvent event ) {

                                                                     }

                                        }




                                  }