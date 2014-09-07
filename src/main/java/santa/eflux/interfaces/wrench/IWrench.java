package santa.eflux.interfaces.wrench;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public interface IWrench
{
    //tells if it is a wrench
    public boolean isWrench();

    //what happens on right click
    public void rightClick(World world, Block block, int x, int y, int z, int side);

    //what happens on right shift click
    public void rightShiftClick(World world, int x, int y, int z, Block block, int side);

    //what happens on left click
    public void leftClick(World world, Block block, int x, int y, int z);
}
