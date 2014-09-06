package santa.eflux.fluid.fluidBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import santa.eflux.EFluxTab;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.fluid.FluidHandler;
import santa.eflux.reference.Info;
import santa.eflux.reference.Reference;

public class BlockSteam extends BlockFluidEflux
{
    public BlockSteam()
    {
        super(FluidHandler.fluids[1], Material.water, Reference.EFLUX_TAB, Info.Fluids.STEAM_NAME, Info.Fluids.STEAM_BLOCK_NAME);
    }
}
