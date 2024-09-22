package com.github.kanyefan30.keystrokes.config;

public class Colour {
    public static int pressedColour = 0x66FFFFFF;;
    public static int unpressedColour = 0xFF000000;
    public static int textColour = 0xFFFFFFFF;

    public static void setPressedColour(int newPressedColour) {
        pressedColour = newPressedColour;
    }

    public static void setUnpressedColour(int newUnpressedColour) {
        unpressedColour = newUnpressedColour;
    }
}
