package santa.eflux.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemHandler {

    public static Item ironHard;
    public static Item hammer;
    public static void init(){
        ironHard = new HardenedIron();
        hammer = new Hammer();
    }

    public static void regi(){
        GameRegistry.registerItem(ironHard, ItemInfo.IRON_KEY);
        GameRegistry.registerItem(hammer, ItemInfo.HAMMER_KEY);
    }

    public static void reci(){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hammer), "III", "IsI", " s ", 'I', "ingotIron", 's', "stickWood"));
    }
}
