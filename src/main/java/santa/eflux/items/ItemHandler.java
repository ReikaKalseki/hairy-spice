package santa.eflux.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import santa.eflux.reference.Info;

public class ItemHandler {

    public static Item ironHard;
    public static Item hammer;
    public static Item wrench;

    public static void init(){
        ironHard = new HardenedIron();
        hammer = new Hammer();
        wrench = new Wrench();
    }

    public static void regi(){
        GameRegistry.registerItem(ironHard, Info.Items.IRON_KEY);
        GameRegistry.registerItem(hammer, Info.Items.HAMMER_KEY);
        GameRegistry.registerItem(wrench, Info.Items.WRENCH_KEY);
    }

    public static void reci(){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hammer), "III", "IsI", " s ", 'I', "ingotIron", 's', "stickWood"));
    }
}
