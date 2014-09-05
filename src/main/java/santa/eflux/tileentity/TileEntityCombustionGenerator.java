package santa.eflux.tileentity;

import cofh.api.energy.TileEnergyHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import santa.eflux.blocks.GeneratorBase;
import santa.eflux.blocks.BlockHandler;
import santa.eflux.utility.LogHelper;

public class TileEntityCombustionGenerator extends TileEntity implements IInventory{
    public ItemStack burnable;
    int burntime = 0;

    public static final int updateRate = 100;

    public TileEntityCombustionGenerator(){
        super();
        burnable = null;
    }

    @Override
    public int getSizeInventory(){
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int slot){
        return burnable;
    }

    @Override
    public ItemStack getStackInSlotOnClosing (int par1){
        return burnable;
    }

    @Override
    public String getInventoryName(){
        return "combustiongenerator.name";
    }

    @Override
    public boolean hasCustomInventoryName(){
        return false;
    }

    @Override
    public int getInventoryStackLimit(){
        return 64;
    }

    @Override
    public void openInventory(){

    }

    @Override
    public void closeInventory(){

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack){
        return TileEntityFurnace.isItemFuel(stack);
    }

    public void update(){
        this.markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public Packet getDescriptionPacket(){
        NBTTagCompound nbtTag = new NBTTagCompound();
        writeToNBT(nbtTag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt){
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player){
        return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount){
        if (burnable != null){
            ItemStack stack;
            if (burnable.stackSize <= amount){
                stack = burnable;
                burnable = null;
                return stack;
            } else {
                stack = burnable.splitStack(amount);

                if (burnable.stackSize == 0){
                    burnable = null;
                }

                return stack;
            }
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack){
        burnable = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public void updateEntity()
    {
        int x = this.xCoord;
        int y = this.yCoord;
        int z = this.zCoord;

        if (this.worldObj.isRemote)
        {
            if (this.worldObj.getBlock(x + 1, y, z).equals(BlockHandler.generatorBase) && this.worldObj.getBlock(x - 1, y, z).equals(BlockHandler.generatorBase))
            {
                if (this.worldObj.getBlock(x, y, z + 1).equals(BlockHandler.generatorBase) && this.worldObj.getBlock(x, y, z - 1).equals(BlockHandler.generatorBase))
                {
                    if (this.worldObj.getBlock(x + 1, y, z + 1).equals(BlockHandler.generatorBase) && this.worldObj.getBlock(x - 1, y, z - 1).equals(BlockHandler.generatorBase))
                    {
                        if (this.worldObj.getBlock(x - 1, y, z + 1).equals(BlockHandler.generatorBase) && this.worldObj.getBlock(x + 1, y, z - 1).equals(BlockHandler.generatorBase))
                        {
                            if (this.worldObj.getBlock(x, y + 1, z).equals(BlockHandler.generatorBase))
                            {
                                if (this.worldObj.getBlock(x + 1, y + 1, z).equals(BlockHandler.generatorBase) && this.worldObj.getBlock(x - 1, y + 1, z).equals(BlockHandler.generatorBase))
                                {
                                    if (this.worldObj.getBlock(x, y + 1, z + 1).equals(BlockHandler.generatorBase) && this.worldObj.getBlock(x, y + 1, z - 1).equals(BlockHandler.generatorBase))
                                    {
                                        if (this.worldObj.getBlock(x + 1, y + 1, z + 1).equals(BlockHandler.generatorBase) && this.worldObj.getBlock(x - 1, y + 1, z - 1).equals(BlockHandler.generatorBase))
                                        {
                                            if (this.worldObj.getBlock(x - 1, y + 1, z + 1).equals(BlockHandler.generatorBase) && this.worldObj.getBlock(x + 1, y + 1, z - 1).equals(BlockHandler.generatorBase))
                                            {
                                                if (this.worldObj.getBlock(x, y + 2, z).equals(BlockHandler.tank))
                                                {
                                                    if (this.worldObj.getBlock(x + 1, y + 2, z).equals(BlockHandler.tank) && this.worldObj.getBlock(x - 1, y + 2, z).equals(BlockHandler.tank))
                                                    {
                                                        if (this.worldObj.getBlock(x, y + 2, z + 1).equals(BlockHandler.tank) && this.worldObj.getBlock(x, y + 2, z - 1).equals(BlockHandler.tank))
                                                        {
                                                            if (this.worldObj.getBlock(x + 1, y + 2, z + 1).equals(BlockHandler.tank) && this.worldObj.getBlock(x - 1, y + 2, z - 1).equals(BlockHandler.tank))
                                                            {
                                                                if (this.worldObj.getBlock(x - 1, y + 2, z + 1).equals(BlockHandler.tank) && this.worldObj.getBlock(x + 1, y + 2, z - 1).equals(BlockHandler.tank))
                                                                {
                                                                    this.worldObj.setTileEntity(x, y, z, new TileEntityCombustionGeneratorMulti());
                                                                    LogHelper.info("Combustion Geneator MultiBlock formed");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
