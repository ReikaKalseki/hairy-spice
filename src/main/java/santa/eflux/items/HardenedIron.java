package santa.eflux.items;

import net.minecraft.item.Item;
import santa.eflux.EnergeticFluxMain;

/**
 * Created by elijahfoster-wysocki on 9/1/14.
 */
public class HardenedIron extends Item {

    public HardenedIron(){
        super();
        this.setUnlocalizedName(ItemInfo.IRON_UNLOCALIZED);
        this.setCreativeTab(EnergeticFluxMain.tabEflux);
        this.setTextureName("eflux:iron");
    }
}
