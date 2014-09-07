package santa.eflux.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import santa.eflux.blocks.MetalCompressor;
import santa.eflux.interfaces.IWrenchable;
import santa.eflux.interfaces.wrench.IWrench;
import santa.eflux.reference.Info;
import santa.eflux.reference.Reference;
import santa.eflux.utility.LogHelper;

public class Wrench extends ItemEflux implements IWrench
{
    public Wrench() {
        super(Info.Items.WRENCH_UNLOCALIZED, Reference.EFLUX_TAB);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (world.getBlock(x, y, z) instanceof IWrenchable)
        {
            IWrenchable wrenchableBlock = (IWrenchable) world.getBlock(x, y, z);
            if (player.isSneaking())
            {
                wrenchableBlock.destroy(world, world.getBlock(x, y, z), x, y, z);
            } else
            {
                wrenchableBlock.rotate(world, world.getBlock(x, y, z), x, y, z, side);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isWrench() {
        return true;
    }
}
