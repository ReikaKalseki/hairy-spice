package santa.eflux.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import santa.api.handlers.WrenchHandler;
import santa.api.interfaces.wrench.IWrench;
import santa.eflux.reference.Info;
import santa.eflux.reference.Reference;

public class Wrench extends ItemEflux implements IWrench
{
    public Wrench() {
        super(Info.Items.WRENCH_UNLOCALIZED, Reference.EFLUX_TAB);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(x, y, z);
        return WrenchHandler.onItemUse(itemStack, player, world, x, y, z, side, block);
    }

    @Override
    public boolean isWrench() {
        return true;
    }
}
