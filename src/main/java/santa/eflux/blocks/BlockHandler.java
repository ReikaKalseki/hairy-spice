package santa.eflux.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by elijahfoster-wysocki on 9/1/14.
 */
public class BlockHandler {

    public static Block generatorCombust;

    //Initialize blocks here
    public static void init(){

        generatorCombust = new CombustionGenerator();
    }

    //Register blocks here
    public static void regi(){

        GameRegistry.registerBlock(generatorCombust, BlockInfo.COMBUST_KEY);
    }

    //Recipes for blocks go here
    public static void reci(){


    }
}
