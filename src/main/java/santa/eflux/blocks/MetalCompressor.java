package santa.eflux.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import santa.eflux.reference.Reference;
import santa.eflux.tileentity.TileEntityMetalCompressor;


/**
 * Created by elijahfoster-wysocki on 9/5/14.
 */
public class MetalCompressor extends BlockEflux{

    public MetalCompressor(){
        super(Material.iron, 1.5F, 10.0F, soundTypeMetal, BlockInfo.COMPRESSOR_UNLOCALIZED, Reference.EFLUX_TAB);
    }

    @Override
    public TileEntity createTileEntity(World world, int meta){
        return TileEntityMetalCompressor();
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        if (world.getBlockMetadata(x, y, z) == 1) {
            return 5;
        } else {
            return 0;
        }
    }


}
