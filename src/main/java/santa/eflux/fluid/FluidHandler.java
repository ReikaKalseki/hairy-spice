package santa.eflux.fluid;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import santa.eflux.fluid.fluidBlocks.BlockSteam;
import santa.eflux.reference.Reference;

public class FluidHandler
{
    //steam
    public static Fluid efluxSteam = new Fluid("steam");
    public static Block efluxSteamBlock = new BlockSteam(efluxSteam, Material.water).setBlockName("steam");

    public void init()
    {
        doFluidStuff();

        //register steam
        FluidRegistry.registerFluid(efluxSteam);
        

    }

    //do stuff with all fluids
    public void doFluidStuff()
    {
        steam();
    }

    //do steam stuff
    public void steam()
    {
        efluxSteam.setLuminosity(0);
        efluxSteam.setTemperature(100);
        efluxSteam.setViscosity(500);
        efluxSteam.setGaseous(true);


        GameRegistry.registerBlock(efluxSteamBlock, Reference.MOD_ID + "_" + efluxSteamBlock.getUnlocalizedName().substring(5));
        efluxSteam.setUnlocalizedName(efluxSteamBlock.getUnlocalizedName());
    }
}
