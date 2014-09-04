package santa.eflux.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import santa.eflux.EnergeticFluxMain;

/**
 * Created by elijahfoster-wysocki on 9/2/14.
 */
public class GeneratorBase extends Block {

    public GeneratorBase(){
        super(Material.iron);
        this.setCreativeTab(EnergeticFluxMain.tabEflux);
        this.setBlockTextureName("eflux:generatorBase");
        this.setBlockName(BlockInfo.GENBASE_UNLOCALIZED);
        this.setStepSound(soundTypeMetal);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
    }
}
