package com.github.kanyefan30.autoggmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "AutoGGMod", useMetadata = true)
public class AutoGGMod {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new OnClientTick());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
