package santa.eflux.mechanicalpower;

import net.minecraftforge.common.util.ForgeDirection;

public interface IMechanicalEnergyConnection
{
    boolean canConnectEnergy(ForgeDirection from);

}
