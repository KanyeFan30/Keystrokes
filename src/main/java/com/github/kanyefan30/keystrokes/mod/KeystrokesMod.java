package com.github.kanyefan30.keystrokes.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class KeystrokesMod extends Gui {
    private final Minecraft mc = Minecraft.getMinecraft();

    private static final int KEY_WIDTH = 20;
    private static final int GAP = 1;
    private static final int SPACE_WIDTH = 3 * KEY_WIDTH + 2 * GAP;
    private static final int SPACE_HEIGHT = 12;
    private static final int MB_WIDTH = 30;
    private static final int BUTTON_HEIGHT = 20;

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        ScaledResolution sr = new ScaledResolution(mc);
        int screenWidth = sr.getScaledWidth();
        int screenHeight = sr.getScaledHeight();

        int baseX = screenWidth - GAP;
        int baseY = screenHeight - GAP;
        renderKey(baseX - 2 * KEY_WIDTH - GAP, baseY - 3 * BUTTON_HEIGHT - 3 * GAP - SPACE_HEIGHT, "W", mc.gameSettings.keyBindForward);
        renderKey(baseX - SPACE_WIDTH, baseY - 2 * BUTTON_HEIGHT - 2 * GAP - SPACE_HEIGHT, "A", mc.gameSettings.keyBindLeft);
        renderKey(baseX - 2 * KEY_WIDTH - GAP, baseY - 2 * BUTTON_HEIGHT - 2 * GAP - SPACE_HEIGHT, "S", mc.gameSettings.keyBindBack);
        renderKey(baseX - KEY_WIDTH, baseY - 2 * BUTTON_HEIGHT - 2 * GAP - SPACE_HEIGHT, "D", mc.gameSettings.keyBindRight);
        renderKey(baseX - SPACE_WIDTH, baseY - SPACE_HEIGHT - GAP - BUTTON_HEIGHT, "LMB", mc.gameSettings.keyBindAttack);
        renderKey(baseX - MB_WIDTH, baseY - SPACE_HEIGHT - GAP - BUTTON_HEIGHT, "RMB", mc.gameSettings.keyBindUseItem);
        renderKey(baseX - SPACE_WIDTH, baseY - SPACE_HEIGHT, "-", mc.gameSettings.keyBindJump);
    }

    private void renderKey(int x, int y, String key, KeyBinding keyBinding) {
        int boxColour = 0x66000000;
        int keyColour = 0xFFFFFFFF;
        if (keyBinding.isKeyDown()) {
            boxColour = 0x66FFFFFF;
            keyColour = 0xFF000000;
        }

        int letterWidth = mc.fontRendererObj.getStringWidth(key);
        int letterHeight = mc.fontRendererObj.FONT_HEIGHT;
        int boxWidth = getBoxWidth(key);
        int boxHeight = getBoxHeight(key);
        drawRect(x, y, x + boxWidth, y + boxHeight, boxColour);
        mc.fontRendererObj.drawString(key, x + (boxWidth - letterWidth) / 2, y + (boxHeight - letterHeight) / 2, keyColour);
    }

    private int getBoxWidth(String key) {
        if (Objects.equals(key, "-")) {
            return SPACE_WIDTH;
        } else if (Objects.equals(key, "LMB") || Objects.equals(key, "RMB")) {
            return MB_WIDTH;
        } else {
            return KEY_WIDTH;
        }
    }

    private int getBoxHeight(String key) {
        if (Objects.equals(key, "-")) {
            return SPACE_HEIGHT;
        } else {
            return BUTTON_HEIGHT;
        }
    }
}