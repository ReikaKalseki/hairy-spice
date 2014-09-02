package santa.eflux.mechanicalpower;

import cofh.api.energy.IEnergyConnection;
import net.minecraftforge.common.util.ForgeDirection;

public interface IMechanicalEnergyHandler extends IMechanicalEnergyConnection
{
    int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate);

    int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate);


}
