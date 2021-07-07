package com.lousiesmods.lousiesutilities.handler.registry;

import com.lousiesmods.lousiesutilities.Reference;
import com.lousiesmods.lousiesutilities.item.SlimeLocatorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

    public static final RegistryObject<Item> SLIME_LOCATOR = ITEMS.register("slime_locator", SlimeLocatorItem::new);

    public static void registerItems()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
