package com.lousiesmods.lousiesutilities.handler.registry;

import com.lousiesmods.lousiesutilities.Reference;
import com.lousiesmods.lousiesutilities.item.SlimeLocatorItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundRegistry
{
    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);

    public static final RegistryObject<SoundEvent> SLIME_LOCATOR = SOUNDS.register("slime_locator", () -> new SoundEvent(new ResourceLocation(Reference.MOD_ID, "slime_locator")));

    public static void registerSounds()
    {
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
