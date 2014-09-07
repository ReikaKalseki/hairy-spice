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
            if (player.isSneaking())
            {
                rightShiftClick(world, x, y, z, world.getBlock(x, y, z), side);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isWrench() {
        return true;
    }

    @Override
    public void rightClick(World world, Block block, int x, int y, int z, int side) {
        LogHelper.info("rightClick has been called");
        if (block instanceof IWrenchable)
        {
            ((IWrenchable) block).rotate(world, block, x, y, z, side);
        }
    }

    @Override
    public void rightShiftClick(World world, int x, int y, int z, Block block, int side) {
        LogHelper.info("rightShiftClick has been called");
        if (block instanceof IWrenchable)
        {
            ((IWrenchable) block).destroy(world, block, x, y, z);
        }
    }

    @Override
    public void leftClick(World world, Block block, int x, int y, int z) {
        LogHelper.info("leftClick has been called");
        if (block instanceof IWrenchable)
        {
            ((IWrenchable) block).wrenchSpecialAction(world, block, x, y, z);
        }
    }
}
