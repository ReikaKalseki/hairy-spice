package santa.eflux.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import santa.eflux.items.ItemHandler;
import santa.eflux.reference.Info;

public class BlockHandler {

    public static Block generatorCombust;
    public static Block generatorBase;
    public static Block tank;
    public static Block metalCompressor;
    public static Block charcoalBlock;

    //Initialize blocks here
    public static void init(){

        generatorCombust = new CombustionGenerator();
        generatorBase = new GeneratorBase();
        tank = new Tank();
        metalCompressor = new MetalCompressor();
        charcoalBlock = new CharcoalBlock();
    }

    //Register blocks here
    public static void regi(){

        GameRegistry.registerBlock(generatorCombust, Info.Blocks.COMBUST_KEY);
        GameRegistry.registerBlock(generatorBase, Info.Blocks.GENBASE_KEY);
        GameRegistry.registerBlock(tank, Info.Blocks.TANK_KEY);
        GameRegistry.registerBlock(metalCompressor, Info.Blocks.COMPRESSOR_KEY);
        GameRegistry.registerBlock(charcoalBlock, Info.Blocks.CHARCOAL_KEY);
    }

    //Recipes for blocks go here
    public static void reci(){

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(generatorBase, 1),"XXX", "XXX", "XXX", 'X', ItemHandler.ironHard));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(generatorCombust, 1), "XYX", "DFD", "XXX", 'X', generatorBase, 'Y', "gemDiamond", 'D', "dustRedstone", 'F', Blocks.furnace));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(tank, 1), "XXX", "XYX", "XXX", 'X', ItemHandler.ironHard, 'Y', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(charcoalBlock, 1), "CCC", "CCC", "CCC", 'C', new ItemStack(Items.coal, 1, 1)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.coal, 9, 1), new ItemStack(charcoalBlock)));
    }
}
