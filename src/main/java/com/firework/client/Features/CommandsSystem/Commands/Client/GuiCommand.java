package com.firework.client.Features.CommandsSystem.Commands.Client;

import com.firework.client.Features.CommandsSystem.Command;
import com.firework.client.Features.CommandsSystem.CommandManifest;
import com.firework.client.Features.Modules.Client.Notifications;
import com.firework.client.Implementations.Gui.Gui;
import net.minecraft.client.Minecraft;

@CommandManifest(label="gui")
public class GuiCommand
extends Command {
    @Override
    public void execute(String[] args) {
        Notifications.notificate();
        Minecraft.getMinecraft().player.closeScreen();
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Minecraft.getMinecraft().displayGuiScreen(new Gui());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
