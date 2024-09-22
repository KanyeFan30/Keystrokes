package com.github.kanyefan30.keystrokes.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.io.IOException;

public class ConfigGui extends GuiScreen {
    public static GuiScreen screenToOpenNextTick = null;

    public static final int MOUSE_LEFT = 0;
    public static final int MOUSE_RIGHT = 1;
    public static final int MOUSE_MIDDLE = 2;
    public static final int MOUSE_BACKWARD = 3;
    public static final int MOUSE_FORWARD = 4;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) return;
        if (screenToOpenNextTick != null) {
            Minecraft.getMinecraft().displayGuiScreen(screenToOpenNextTick);
            screenToOpenNextTick = null;
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        // Box colour buttons
        this.buttonList.add(new GuiButton(0, this.width / 2 - 205, this.height / 2 - 60, "Black"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 205, this.height / 2 - 35, "White"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 205, this.height / 2 - 10, "Red"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 205, this.height / 2 + 15, "Yellow"));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 205, this.height / 2 + 40, "Green"));
        this.buttonList.add(new GuiButton(5, this.width / 2 - 205, this.height / 2 + 65, "Blue"));

        // Text colour buttons
        this.buttonList.add(new GuiButton(6, this.width / 2 + 5, this.height / 2 - 60, "Black"));
        this.buttonList.add(new GuiButton(7, this.width / 2 + 5, this.height / 2 - 35, "White"));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 5, this.height / 2 - 10, "Red"));
        this.buttonList.add(new GuiButton(9, this.width / 2 + 5, this.height / 2 + 15, "Yellow"));
        this.buttonList.add(new GuiButton(10, this.width / 2 + 5, this.height / 2 + 40, "Green"));
        this.buttonList.add(new GuiButton(11, this.width / 2 + 5, this.height / 2 + 65, "Blue"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
        String keyString = "Key Colours";
        String textString = "Text Colours";
        int keyStringWidth = fr.getStringWidth(keyString);
        int textStringWidth = fr.getStringWidth(textString);

        fr.drawString(keyString, this.width - 105 - keyStringWidth / 2, this.height / 2 - 85, 0xFFFFFFFF);
        fr.drawString(keyString, this.width + 105 - textStringWidth / 2, this.height / 2 - 85, 0xFFFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == Keyboard.KEY_ESCAPE) {
            this.mc.displayGuiScreen(null);
        }
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
