package santa.eflux.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.reference.Info;
import santa.eflux.reference.Reference;

/**
 * Created by elijahfoster-wysocki on 9/2/14.
 */
public class Tank extends BlockEflux {

    public Tank(){
        super(Material.iron, 1.5F, 10.0F, soundTypeGlass, Info.Blocks.TANK_UNLOCALIZED, Reference.EFLUX_TAB);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass(){
        return 1;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess par1, int par2, int par3, int par4, int par5){
        Block block = par1.getBlock(par2, par3, par4);
        boolean render = super.shouldSideBeRendered(par1, par2, par3, par4, par5);
        return true && block instanceof Tank ? false : render;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }
}
