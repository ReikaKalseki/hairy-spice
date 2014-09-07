package santa.eflux.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import santa.eflux.utility.LogHelper;
import santa.eflux.utility.NBTHelper;

import java.util.HashMap;
import java.util.Map;


public class TileEntityCombustionGeneratorMulti extends TileEntity {

    private static Map classToNameMap = new HashMap();
    private boolean hasMaster, isMaster;
    private int masterX, masterY, masterZ;

    @Override
    public void updateEntity(){
        super.updateEntity();
        if (!worldObj.isRemote){
            if (hasMaster()){
                if (isMaster()){
                    LogHelper.info("Combustion Generator MultiBlock formed");
                }
            } else {
                if (checkMultiBlockForm())
                    setupStructure();
            }
        }
    }

    public boolean checkMultiBlockForm() {
        int i = 0;
        for (int x = xCoord - 1; x < xCoord + 2; x++) {
            for (int y = yCoord; y < yCoord + 3; y++) {
                for (int z = zCoord; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileEntityCombustionGeneratorMulti)) {
                        if (this.hasMaster()) {
                            if (((TileEntityCombustionGeneratorMulti) tile).hasMaster()) i++;

                        } else if (!((TileEntityCombustionGeneratorMulti) tile).hasMaster()) i++;

                    }
                }
            }
        }
        return i > 25 && worldObj.isAirBlock(xCoord, yCoord + i, zCoord);
    }

    public void setupStructure() {
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    boolean master = (x == xCoord && y == yCoord && z == zCoord);
                    if (tile != null && (tile instanceof TileEntityCombustionGeneratorMulti)) {
                        ((TileEntityCombustionGeneratorMulti) tile).setMasterCoords(xCoord, yCoord, zCoord);
                        ((TileEntityCombustionGeneratorMulti) tile).setHasMaster(true);
                        ((TileEntityCombustionGeneratorMulti) tile).setIsMaster(master);
                    }

                }
    }

    public void reset(){
        masterX = 0;
        masterY = 0;
        masterZ = 0;
        hasMaster = false;
        isMaster = false;
    }

    public boolean checkForMaster(){
        TileEntity tile = worldObj.getTileEntity(masterX, masterY, masterZ);
        return (tile != null && (tile instanceof TileEntityCombustionGeneratorMulti));
    }

    public void resetStructure(){
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord; z < zCoord + 2; z++){
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileEntityCombustionGeneratorMulti))
                        ((TileEntityCombustionGeneratorMulti) tile).reset();
                }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbttag){

        nbttag.setString("id", "TileEntityCombustionGeneratorMulti");
        nbttag.setInteger("x", this.xCoord);
        nbttag.setInteger("y", this.yCoord);
        nbttag.setInteger("z", this.zCoord);

        nbttag.setInteger("masterX", masterX);
        nbttag.setInteger("masterY", masterY);
        nbttag.setInteger("masterZ", masterZ);
        nbttag.setBoolean("hasMaster", hasMaster);
        nbttag.setBoolean("isMaster", isMaster);

        if (hasMaster() && isMaster()){
            //filler
        }

        LogHelper.info("TileEntityCombustionGeneratorMulti wrote to NBT");
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttag){
        super.readFromNBT(nbttag);
        masterX = nbttag.getInteger("masterX");
        masterY = nbttag.getInteger("masterY");
        masterZ = nbttag.getInteger("masterZ");
        hasMaster = nbttag.getBoolean("hasMaster");
        isMaster = nbttag.getBoolean("isMaster");
        if (hasMaster() && isMaster()){
            //filler
        }
    }

    public boolean hasMaster(){
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
        return masterZ;
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