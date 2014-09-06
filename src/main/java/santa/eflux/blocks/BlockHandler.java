package santa.eflux.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import santa.eflux.items.ItemHandler;

/**
 * Created by elijahfoster-wysocki on 9/1/14.
 */
public class BlockHandler {

    public static Block generatorCombust;
    public static Block generatorBase;
    public static Block tank;

    //Initialize blocks here
    public static void init(){

        generatorCombust = new CombustionGenerator();
        generatorBase = new GeneratorBase();
        tank = new Tank();
    }

    //Register blocks here
    public static void regi(){

        GameRegistry.registerBlock(generatorCombust, BlockInfo.COMBUST_KEY);
        GameRegistry.registerBlock(generatorBase, BlockInfo.GENBASE_KEY);
        GameRegistry.registerBlock(tank, BlockInfo.TANK_KEY);
    }

    //Recipes for blocks go here
    public static void reci(){

        GameRegistry.addRecipe(new ItemStack(generatorBase, 2), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), ItemHandler.ironHard});
        GameRegistry.addRecipe(new ItemStack(generatorCombust, 1), new Object[]{"XYX", "DFD", "XXX", Character.valueOf('X'), generatorBase, Character.valueOf('Y'), Items.diamond, Character.valueOf('D'), Items.redstone, Character.valueOf('F'), Blocks.furnace});
        GameRegistry.addRecipe(new ItemStack(tank, 1), new Object[]{"XXX", "XYX", "XXX", Character.valueOf('X'), ItemHandler.ironHard, Character.valueOf('Y'), Blocks.glass});

    }
}
