package santa.eflux.tileentity;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;
import santa.eflux.blocks.BlockHandler;
import santa.eflux.items.ItemHandler;
import santa.eflux.mechanicalpower.IMechanicalEnergyConnection;

/**
 * Created by elijahfoster-wysocki on 9/5/14.
 */
public class TileEntityMetalCompressor extends TileEntity implements IEnergyHandler, IInventory, IMechanicalEnergyConnection{

    EnergyStorage battery = new EnergyStorage(14);
    protected ItemStack[] slots;

    public int burntime;

    String burntimeTag = "burntime";

    public TileEntityMetalCompressor(){
        slots = new ItemStack[12];
        burntime = 3;
    }

    @Override
    public void updateEntity(){
        super.updateEntity();

        if (worldObj.isRemote)
            return;
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from){
        return true;
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate){
        return battery.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate){
        return 0;
    }

    @Override
    public int getEnergyStored(ForgeDirection from){
        return battery.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from){
        return battery.getMaxEnergyStored();
    }

    public float getScaledEnergyStored(){
        return (float)battery.getEnergyStored() / (float)battery.getMaxEnergyStored() * 100.0F;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        battery.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        battery.writeToNBT(nbt);
    }

    public static int getItemBurnTime(ItemStack stack){
        return 1600;
    }

    public static boolean isItemFuel(ItemStack stack){
        Item item = stack.getItem();
        if (item == Items.coal) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSizeInventory(){
        return 3;
    }

    @Override
    public ItemStack getStackInSlot(int slot){
        return slots[slot];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2){
        if (this.slots[par1] != null){
            ItemStack itemstack;

            if (this.slots[par1].stackSize <= par2){
                itemstack = this.slots[par1];
                this.slots[par1] = null;
                return itemstack;
            } else {
                itemstack = this.slots[par1].splitStack(par2);

                if (this.slots[par1].stackSize == 0){
                    this.slots[par1] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1){
        return null;
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2){
        this.slots[par1] = par2;

        if (par2 != null && par2.stackSize > this.getInventoryStackLimit()){
            par2.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName(){
        return "Metal Compressor";
    }

    @Override
    public boolean hasCustomInventoryName(){
        return true;
    }

    @Override
    public int getInventoryStackLimit(){
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player){
        return true;
    }

    @Override
    public void openInventory(){

    }

    @Override
    public void closeInventory(){

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack){
        if (stack == new ItemStack(ItemHandler.ironHard)){
            return true;
        } else {
            return false;
        }
    }





}
