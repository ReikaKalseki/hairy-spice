package santa.eflux.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.reference.Reference;

/**
 * Created by elijahfoster-wysocki on 9/2/14.
 */
public class GeneratorBase extends Block {

    public GeneratorBase(){
        super(Material.iron);
        this.setCreativeTab(Reference.EFLUX_TAB);
        this.setBlockTextureName(Reference.MOD_ID + ":generatorBase");
        this.setBlockName(BlockInfo.GENBASE_UNLOCALIZED);
        this.setStepSound(soundTypeMetal);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
    }
}
