package santa.api.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import santa.api.interfaces.wrench.IWrenchable;
import santa.api.interfaces.wrench.IWrench;
import santa.eflux.tileentity.TileEntityMetalCompressor;
import santa.eflux.utility.LogHelper;

public class WrenchHandler
{
    public static boolean hasBeenRotated = false;

    public static void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            Block block = world.getBlock(x, y, z);
            TileEntity tile = world.getTileEntity(x, y, z);
            if (block instanceof IWrenchable) {
                IWrenchable wrenchableBlock = (IWrenchable) block;
                if (tile instanceof TileEntityMetalCompressor) {
                    Item equipped = player.getCurrentEquippedItem() != null ? player.getCurrentEquippedItem().getItem() : null;
                    if (equipped instanceof IWrench) {
                        IWrench equippedWrench = (IWrench) equipped;
                        if (equippedWrench.isWrench()) {
                            wrenchableBlock.wrenchSpecialAction(world, block, x, y, z);
                        }
                    }
                }
            }
        }
    }

    public static boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, Block block)
    {
        if (!world.isRemote)
        {
            LogHelper.info("isRemote");

            Item equipped = player.getCurrentEquippedItem().getItem();
            if (equipped instanceof IWrench)
            {
                LogHelper.info("Player has right-clicked with wrench");
                IWrench equippedWrench = (IWrench) equipped;
                if (equippedWrench.isWrench())
                {
                    LogHelper.info("Wrench is wrench");
                    if (player.isSneaking())
                    {
                        LogHelper.info("Player was sneaking");
                        destroy(world, block, x, y, z);
                        return true;
                    } else {
                        LogHelper.info("Player was not sneaking");
                        rotate(world, block, x, y, z, side);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void rotate(World world, Block block,int x, int y, int z, int side) {
        if (!hasBeenRotated) {
            if (block instanceof IWrenchable) {
                IWrenchable wrenchableBlock = (IWrenchable) block;
                if (wrenchableBlock.isRotateable()) {

                }
            }
            hasBeenRotated = true;
        } else if (hasBeenRotated)
        {
            hasBeenRotated = false;
        }
    }

    public static void destroy(World world, Block block, int x, int y, int z) {
        if (world.getBlock(x, y, z).equals(block)) {
            LogHelper.info("About to destroy Block");
            world.setBlock(x, y, z, Blocks.air);

            LogHelper.info("about to spawn in item");
            Item itemToDrop = Item.getItemFromBlock(block);
            world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(itemToDrop)));
        }
    }

    public static boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, Block block)
    {
        if (itemStack.getItem() instanceof IWrench) {
            IWrench wrench = (IWrench) itemStack.getItem();
            if (wrench.isWrench()) {
                if (block instanceof IWrenchable) {
                    IWrenchable wrenchableBlock = (IWrenchable) world.getBlock(x, y, z);
                    if (player.isSneaking()) {
                        destroy(world, block, x, y, z);
                    } else {
                        rotate(world, block, x, y, z, side);
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
