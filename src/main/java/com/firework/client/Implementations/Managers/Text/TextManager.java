package com.firework.client.Implementations.Managers.Text;

import com.firework.client.Firework;
import net.minecraft.client.Minecraft;

public class TextManager {
    Minecraft mc = Minecraft.getMinecraft();
    public static boolean customFont = true;

    public void drawStringWithShadow(String text, float x, float y, int color) {
        this.drawString(text, x, y, color, true);
    }

    public float drawString(String text, float x, float y, int color, boolean shadow) {
        if (customFont) {
            Firework.customFontManager.drawString(text, x, y, color);
        } else {
            this.mc.fontRenderer.drawString(text, x, y, color, shadow);
        }
        return x;
    }

    public int getStringWidth(String text) {
        return this.mc.fontRenderer.getStringWidth(text);
    }

    public int getFontHeight() {
        return this.mc.fontRenderer.FONT_HEIGHT;
    }
}
