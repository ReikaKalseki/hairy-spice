package santa.eflux.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import santa.eflux.interfaces.IWrenchable;
import santa.eflux.interfaces.wrench.IWrench;
import santa.eflux.reference.Info;
import santa.eflux.reference.Reference;
import santa.eflux.tileentity.TileEntityMetalCompressor;
import santa.eflux.utility.LogHelper;

public class MetalCompressor extends BlockEflux implements IWrenchable
{
    public MetalCompressor(){
        super(Material.iron, 1.5F, 10.0F, soundTypeMetal, Info.Blocks.COMPRESSOR_UNLOCALIZED, Reference.EFLUX_TAB);
    }


    @Override
    public TileEntity createTileEntity(World world, int meta){
        return new TileEntityMetalCompressor();
    }


    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        if (world.getBlockMetadata(x, y, z) == 1) {
            return 5;
        } else {
            return 0;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(x, y, z);
        LogHelper.info("Metal Compressor has been activated");
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


    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if(tile instanceof TileEntityMetalCompressor)
            {
                Item equipped = player.getCurrentEquippedItem() != null ? player.getCurrentEquippedItem().getItem() : null;
                if (equipped instanceof IWrench)
                {
                    IWrench equippedWrench = (IWrench) equipped;
                    if (equippedWrench.isWrench())
                    {
                        wrenchSpecialAction(world, world.getBlock(x, y, z), x, y, z);
                    }
                }
            }
        }
    }

    @Override
    public boolean isRotateable() {
        return true;
    }

    @Override
    public void rotate(World world, Block block,int x, int y, int z, int side) {
        //do stuff here
    }

    @Override
    public void destroy(World world, Block block, int x, int y, int z) {
        if (world.getBlock(x, y, z).equals(block)) {
            LogHelper.info("About to destroy Block");
            world.setBlock(x, y, z, Blocks.air);

            LogHelper.info("about to spawn in item");
            Item itemToDrop = Item.getItemFromBlock(block);
            world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(itemToDrop)));
        }
    }

    @Override
    public boolean wrenchSpecialAction(World world, Block block, int x, int y, int z) {
        return false;
    }
}
