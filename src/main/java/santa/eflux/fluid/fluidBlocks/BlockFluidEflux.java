package santa.eflux.fluid.fluidBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import santa.eflux.blocks.BlockEflux;
import santa.eflux.reference.Reference;

public class BlockFluidEflux extends BlockFluidClassic
{

    protected String localName;

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public BlockFluidEflux(Fluid fluid, Material material, CreativeTabs creativeTab, String name, String blockName) {
        super(fluid, material);
        this.setCreativeTab(creativeTab);
        localName = name;
        this.setBlockName(name);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(Reference.MOD_ID + ":" + localName.toLowerCase() + "Still");
        flowingIcon = register.registerIcon(Reference.MOD_ID + ":" + localName.toLowerCase() + "Flowing");
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.displaceIfPossible(world, x, y, z);
    }
}
