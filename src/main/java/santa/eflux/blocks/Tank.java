package santa.eflux.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import santa.eflux.EnergeticFluxMain;

/**
 * Created by elijahfoster-wysocki on 9/2/14.
 */
public class Tank extends Block {

    public Tank(){
        super(Material.iron);
        this.setCreativeTab(EnergeticFluxMain.tabEflux);
        this.setBlockTextureName("eflux:tank");
        this.setBlockName(BlockInfo.TANK_UNLOCALIZED);
        this.setStepSound(soundTypeGlass);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
    }
}
