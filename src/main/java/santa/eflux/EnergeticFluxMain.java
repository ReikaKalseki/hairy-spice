package santa.eflux;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod.EventHandler;
import santa.eflux.proxies.CommonProxy;

/**
 * Created by elijahfoster-wysocki on 7/14/14.
 */

@Mod(modid = "eflux", name = "Energetic Flux", version = "0.0.1")
public class EnergeticFluxMain {

    @SidedProxy(clientSide="santa.eflux.proxies.ClientProxy", serverSide="santa.eflux.proxies.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tabEflux = new EFluxTab("Energetic Flux");

    @Mod.EventHandler
    void pre(FMLPreInitializationEvent event){

        System.out.println("[E-Flux] Stuff should be working fine.");
    }

    @Mod.EventHandler
    void init(FMLInitializationEvent event){
        proxy.initRenderers();
        proxy.initSounds();

    }

    @Mod.EventHandler
    void post(FMLPostInitializationEvent event){

    }

    /* TODO

     */
}