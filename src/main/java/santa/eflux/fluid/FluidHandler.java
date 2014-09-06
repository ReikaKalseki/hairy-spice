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
    //general
    public static Fluid[] fluids = {new Fluid("steam")};

    //steam
    public static Block efluxSteamBlock = new BlockSteam(fluids[1], Material.water).setBlockName("steam");

    public void init() {
        doFluidStuff();

        for (int i = 0; i < fluids.length; i++)
        {
            FluidRegistry.registerFluid(fluids[i]);
        }

    }

    //do stuff with all fluids
    public void doFluidStuff()
    {
        //steam
        doFluidModification(0, 100, 500, true, fluids[1], efluxSteamBlock);
    }

    public void doFluidModification(int luminosity, int temperature, int viscosity, boolean gaseous, Fluid fluid, Block fluidBlock)
    {
        fluid.setLuminosity(luminosity);
        fluid.setTemperature(temperature);
        fluid.setViscosity(viscosity);
        fluid.setGaseous(gaseous);

        GameRegistry.registerBlock(fluidBlock, Reference.MOD_ID + "_" + fluidBlock.getUnlocalizedName().substring(5));
        fluid.setUnlocalizedName(fluidBlock.getUnlocalizedName());
    }
}
