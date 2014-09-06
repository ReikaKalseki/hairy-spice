package santa.eflux.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import santa.eflux.reference.Info;
import santa.eflux.reference.Reference;

import java.util.List;

public class Hammer extends ItemEflux
{
    public Hammer()
    {
        super(Info.Items.HAMMER_UNLOCALIZED, Reference.EFLUX_TAB);
        this.isDamageable();
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote) {
            if (world.getBlock(x, y, z).equals(Blocks.iron_block)) {
                world.setBlock(x, y, z, Blocks.air);
                for (int i = 0; i < 3; i++) {
                    world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ItemHandler.ironHard)));
                }
                int itemDamage = itemStack.getItemDamage();
                itemStack.setItemDamage(itemDamage + 1);
                int itemDamageAfter = itemStack.getItemDamage();
                if (itemDamageAfter >= Info.Items.HAMMER_MAX_DAMAGE) {
                    itemStack.stackSize = 0;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add("This " + Info.Items.HAMMER_NAME +  " has been used " + itemStack.getItemDamage() + "/" + Info.Items.HAMMER_MAX_DAMAGE + " times");

    }

}
