package santa.eflux.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by elijahfoster-wysocki on 9/1/14.
 */
public class ItemHandler {

    public static Item ironHard;
    public static void init(){
        ironHard = new HardenedIron();
    }

    public static void regi(){
        GameRegistry.registerItem(ironHard, ItemInfo.IRON_KEY);
    }

    public static void reci(){

    }
}
