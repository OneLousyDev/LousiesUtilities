package com.lousiesmods.lousiesutilities;

import com.lousiesmods.lousiesutilities.handler.registry.ItemRegistry;
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

    }

    public void enqueueIMC(InterModEnqueueEvent event)
    {

    }

    public void processIMC(InterModProcessEvent event)
    {

    }
}