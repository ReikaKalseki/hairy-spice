package santa.eflux.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.tileentity.TileEntityCombustionGenerator;

import java.util.Random;

/**
 * Created by elijahfoster-wysocki on 9/2/14.
 */
public class CombustionGenerator extends Block {

    public CombustionGenerator(){
        super(Material.iron);
        this.setCreativeTab(EnergeticFluxMain.tabEflux);
        this.setBlockTextureName("eflux:generatorCombust");
        this.setBlockName(BlockInfo.COMBUST_UNLOCALIZED);
        this.setStepSound(soundTypeMetal);
    }

    @Override
    public TileEntity createTileEntity(World world, int meta){
        return new TileEntityCombustionGenerator();
    }


}
