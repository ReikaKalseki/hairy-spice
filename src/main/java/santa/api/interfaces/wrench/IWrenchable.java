package santa.api.interfaces.wrench;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public interface IWrenchable
{
    //You must insert this code and implement isRotateable and wrenchSpecialAction in your wrenchable block class for this to work
    /*
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(x, y, z);
        return WrenchHandler.onBlockActivated(world, x, y, z, player, side, block);
    }


    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
        WrenchHandler.onBlockClicked(world, x, y, z, player);
    }
    */
    
    //tells if rotateable
    public boolean isRotateable();


    //anything special (activates on left click
    public boolean wrenchSpecialAction(World world, Block block, int x, int y, int z);
}