package santa.eflux.interfaces;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public interface IWrenchable
{
    //tells if rotateable
    public boolean isRotateable();

    //rotate the block
    public void rotate(World world, Block block,int x, int y, int z, int side);

    //destroy the block
    public void destroy(World world, Block block, int x, int y, int z);

    //anything special
    public boolean wrenchSpecialAction(World world, Block block, int x, int y, int z);
}
