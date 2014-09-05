package santa.eflux;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod.EventHandler;
import santa.eflux.proxies.CommonProxy;
import santa.eflux.blocks.BlockHandler;
import santa.eflux.items.ItemHandler;
import santa.eflux.reference.Reference;
import santa.eflux.utility.LogHelper;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class EnergeticFluxMain {

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    void pre(FMLPreInitializationEvent event){

        System.out.println("[E-Flux] Stuff should be working fine.");

        BlockHandler.init();
        BlockHandler.regi();
        BlockHandler.reci();

        LogHelper.info("PreInit Complete");
    }

    @EventHandler
    void init(FMLInitializationEvent event){
        proxy.initRenderers();
        proxy.initSounds();

        ItemHandler.init();
        ItemHandler.reci();
        ItemHandler.regi();

        LogHelper.info("Init Complete");
    }

    @EventHandler
    void post(FMLPostInitializationEvent event){


        LogHelper.info("PostInit Complete");
    }

    /* TODO
    everything.
     */
}