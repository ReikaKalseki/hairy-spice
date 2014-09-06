package santa.eflux.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import santa.eflux.reference.Info;
import santa.eflux.reference.Reference;

public class CharcoalBlock extends BlockEflux
{
    public CharcoalBlock() {
        super(Material.rock, 1.0F, 7F, soundTypeStone, Info.Blocks.CHARCOAL_UNLOCALIZED, Reference.EFLUX_TAB);
    }
}
