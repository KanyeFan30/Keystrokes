package com.github.kanyefan30.keystrokes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "keystrokes", version = "1.1", acceptedMinecraftVersions = "[1.8.9]", useMetadata = true)
public class KeystrokesInitializer {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new KeystrokesMod());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
