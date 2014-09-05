package santa.eflux.items;

import net.minecraft.item.Item;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.reference.Reference;

import java.sql.Ref;

/**
 * Created by elijahfoster-wysocki on 9/1/14.
 */
public class HardenedIron extends Item {

    public HardenedIron(){
        super();
        this.setUnlocalizedName(ItemInfo.IRON_UNLOCALIZED);
        this.setCreativeTab(Reference.EFLUX_TAB);
        this.setTextureName(Reference.MOD_ID + ":iron");
    }
}
