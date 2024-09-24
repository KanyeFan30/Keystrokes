package com.github.kanyefan30.keystrokes.config;

import java.util.HashMap;

public class ConfigOptions {
    public static boolean showOverlay = true;

    private static HashMap<String, Boolean> keyDisplayed = new HashMap<>();
    static {
        keyDisplayed.put("W", true);
        keyDisplayed.put("A", true);
        keyDisplayed.put("S", true);
        keyDisplayed.put("D", true);
        keyDisplayed.put("LMB", true);
        keyDisplayed.put("RMB", true);
        keyDisplayed.put("Space", true);
    }

    public static int pressedColour = 0x66FFFFFF;;
    public static int unpressedColour = 0xFF000000;
    public static int textColour = 0xFFFFFFFF;

    public static void setPressedColour(int newPressedColour) {
        pressedColour = newPressedColour;
    }

    public static void setUnpressedColour(int newUnpressedColour) {
        unpressedColour = newUnpressedColour;
    }

    public static void toggleOverlayDisplay() {
        showOverlay = !showOverlay;
    }

    public static void toggleKeyDisplay(String key) {
        if (keyDisplayed.get(key) == null) {
            return;
        }
        keyDisplayed.put(key, !keyDisplayed.get(key));
    }
}
