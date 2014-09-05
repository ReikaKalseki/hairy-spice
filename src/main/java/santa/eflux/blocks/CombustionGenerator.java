package santa.eflux.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.reference.Reference;
import santa.eflux.tileentity.TileEntityCombustionGenerator;

import java.util.Random;


public class CombustionGenerator extends Block {

    public CombustionGenerator(){
        super(Material.iron);
        this.setCreativeTab(Reference.EFLUX_TAB);
        this.setBlockTextureName(Reference.MOD_ID + ":generatorCombust");
        this.setBlockName(BlockInfo.COMBUST_UNLOCALIZED);
        this.setStepSound(soundTypeMetal);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
    }

    @Override
    public TileEntity createTileEntity(World world, int meta){
            return new TileEntityCombustionGenerator();
    }


}
