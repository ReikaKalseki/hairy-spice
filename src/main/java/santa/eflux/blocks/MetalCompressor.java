package santa.eflux.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import santa.api.handlers.WrenchHandler;
import santa.api.interfaces.wrench.IWrenchable;
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
        return WrenchHandler.onBlockActivated(world, x, y, z, player, side, block);
    }


    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
        LogHelper.info("Metal Compressor has been clicked");
        WrenchHandler.onBlockClicked(world, x, y, z, player);
    }

    @Override
    public boolean isRotateable() {
        return true;
    }

    @Override
    public boolean wrenchSpecialAction(World world, Block block, int x, int y, int z) {
        return false;
    }
}
