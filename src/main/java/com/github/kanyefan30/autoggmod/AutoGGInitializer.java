package com.github.kanyefan30.autoggmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "autogg", useMetadata = true)
public class AutoGGInitializer {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new AutoGGHandler());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
