package com.lousiesmods.lousiesutilities;

import com.lousiesmods.lousiesutilities.handler.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Reference
{
    public static final String MOD_ID = "lousiesutilities";

    public static final ItemGroup CREATIVE_TAB_ITEMS = new ItemGroup("creativeTabItems")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ItemRegistry.SLIME_LOCATOR.get());
        }
    };
}
