package com.lousiesmods.lousiesutilities;

import com.lousiesmods.lousiesutilities.handler.registry.ItemRegistry;
import com.lousiesmods.lousiesutilities.handler.registry.SoundRegistry;
import com.lousiesmods.lousiesutilities.item.SlimeLocatorItem;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class LousiesUtilities
{
    public LousiesUtilities()
    {
        ItemRegistry.registerItems();
        SoundRegistry.registerSounds();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }

    public void serverSetup(FMLCommonSetupEvent event)
    {

    }

    public void clientSetup(FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> ItemModelsProperties.register(ItemRegistry.SLIME_LOCATOR.get(), new ResourceLocation(Reference.MOD_ID, "active"), (ItemStack stack, ClientWorld worldIn, LivingEntity entityIn) -> SlimeLocatorItem.isActive(stack)? 2 : 0));
    }

    public void enqueueIMC(InterModEnqueueEvent event)
    {

    }

    public void processIMC(InterModProcessEvent event)
    {

    }
}
