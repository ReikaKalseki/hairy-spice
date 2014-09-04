package santa.eflux.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by elijahfoster-wysocki on 9/2/14.
 */
public class TileEntityCombustionGeneratorMulti extends TileEntity {
    private boolean hasMaster, isMaster;
    private int masterX, masterY, masterZ;

    @Override
    public void writeToNBT(NBTTagCompound data){
        super.writeToNBT(data);
        data.setInteger("masterX", masterX);
        data.setInteger("masterY", masterY);
        data.setInteger("masterZ", masterZ);
        data.setBoolean("hasMaster", hasMaster);
        data.setBoolean("isMaster", isMaster);
    }

    @Override
    public void readFromNBT(NBTTagCompound data){
        super.readFromNBT(data);
        data.setInteger("masterX", masterX);
        data.setInteger("masterY", masterY);
        data.setInteger("masterZ", masterZ);
        data.setBoolean("hasMaster", hasMaster);
        data.setBoolean("isMaster", isMaster);
    }

    public boolean haMaster(){
        return hasMaster;
    }

    public boolean isMaster(){
        return isMaster;
    }

    public int getMasterX(){
        return masterX;
    }

    public int getMasterY(){
        return masterY;
    }

    public int getMasterZ(){
        return masterY;
    }

    public void setHasMaster(boolean bool){
        hasMaster = bool;
    }

    public void setIsMaster(boolean bool){
        isMaster = bool;
    }

    public void setMasterCoords(int x, int y, int z){
        masterX = x;
        masterY = y;
        masterZ = z;
    }


}
