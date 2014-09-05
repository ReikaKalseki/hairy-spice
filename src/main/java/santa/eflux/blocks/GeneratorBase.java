package santa.eflux.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.reference.Reference;

/**
 * Created by elijahfoster-wysocki on 9/2/14.
 */
public class GeneratorBase extends BlockEflux {

    public GeneratorBase(){
        super(Material.iron, 1.5F, 10.0F, soundTypeMetal, BlockInfo.GENBASE_UNLOCALIZED, Reference.EFLUX_TAB);
    }
}
