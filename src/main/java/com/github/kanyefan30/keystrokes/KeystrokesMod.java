package com.github.kanyefan30.keystrokes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KeystrokesMod extends Gui {
    private final Minecraft mc = Minecraft.getMinecraft();
    private static final int BOX_WIDTH = 20;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        ScaledResolution sr = new ScaledResolution(mc);
        int screenWidth = sr.getScaledWidth();
        int screenHeight = sr.getScaledHeight();

        int baseX = screenWidth - 100;
        int baseY = screenHeight - 80;
        renderKey(baseX, baseY, "W", mc.gameSettings.keyBindForward);
        renderKey(baseX - 20, baseY + 20, "A", mc.gameSettings.keyBindLeft);
        renderKey(baseX, baseY + 20, "S", mc.gameSettings.keyBindBack);
        renderKey(baseX + 20, baseY + 20, "D", mc.gameSettings.keyBindRight);
        renderKey(baseX, baseY + 40, "—", mc.gameSettings.keyBindJump);
        renderKey(baseX - 20, baseY + 60, "LMB", mc.gameSettings.keyBindAttack);
        renderKey(baseX + 20, baseY + 60, "RMB", mc.gameSettings.keyBindUseItem);
    }

    private void renderKey(int x, int y, String key, KeyBinding keyBinding) {
        int boxColour = 0x66000000;
        int keyColour = 0xFFFFFFFF;
        if (keyBinding.isKeyDown()) {
            boxColour = 0x66FFFFFF;
            keyColour = 0xFF000000;
        }

        drawRect(x, y, x + BOX_WIDTH, y + BOX_WIDTH, boxColour);
        int letterWidth = mc.fontRendererObj.getStringWidth(key);
        int letterHeight = mc.fontRendererObj.FONT_HEIGHT;
        mc.fontRendererObj.drawString(key, x + (BOX_WIDTH - letterWidth) / 2, y + (BOX_WIDTH - letterHeight) / 2, keyColour);
    }
}
