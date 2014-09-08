package santa.api.interfaces.wrench;

public interface IWrench
{
    //For this to work you must insert this code into your wrench class and implement isWrench
    /*
    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(x, y, z);
        return WrenchHandler.onItemUse(itemStack, player, world, x, y, z, side, block);
    }

    @Override
    public boolean isWrench() {
        return true;
    }
    */
    //tells if it is a wrench
    public boolean isWrench();
}
