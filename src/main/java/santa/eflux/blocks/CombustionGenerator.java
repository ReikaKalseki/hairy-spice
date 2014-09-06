package santa.eflux.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import santa.eflux.EnergeticFluxMain;
import santa.eflux.reference.Reference;
import santa.eflux.tileentity.TileEntityCombustionGenerator;
import santa.eflux.tileentity.TileEntityCombustionGeneratorMulti;

import java.util.Random;


public class CombustionGenerator extends BlockContainer {

    public CombustionGenerator(){
        super(Material.iron);
        this.setCreativeTab(Reference.EFLUX_TAB);
        this.setBlockName(BlockInfo.COMBUST_UNLOCALIZED);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setBlockTextureName(Reference.MOD_ID + ":" + BlockInfo.COMBUST_UNLOCALIZED);
        //super(Material.iron, 1.5F, 10.0F, soundTypeMetal, BlockInfo.COMBUST_UNLOCALIZED, Reference.EFLUX_TAB);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile != null && tile instanceof TileEntityCombustionGeneratorMulti){
            TileEntityCombustionGeneratorMulti multiblock = (TileEntityCombustionGeneratorMulti) tile;
            if (multiblock.hasMaster()){
                if (!multiblock.checkMultiBlockForm())
                    multiblock.resetStructure();
            } else {
                if (!multiblock.checkForMaster()){
                    multiblock.reset();
                    world.markBlockForUpdate(x, y, z);
                }
            }
        }
        super.onNeighborBlockChange(world, x, y, z, block);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new TileEntityCombustionGeneratorMulti();
    }
}
