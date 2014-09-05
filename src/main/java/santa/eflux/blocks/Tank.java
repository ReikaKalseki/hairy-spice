package santa.eflux.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.reference.Reference;

/**
 * Created by elijahfoster-wysocki on 9/2/14.
 */
public class Tank extends Block {

    public Tank(){
        super(Material.iron);
        this.setCreativeTab(Reference.EFLUX_TAB);
        this.setBlockTextureName(Reference.MOD_ID + ":tank");
        this.setBlockName(BlockInfo.TANK_UNLOCALIZED);
        this.setStepSound(soundTypeGlass);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
    }
}
