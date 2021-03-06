package com.firework.client.Features.CommandsSystem.Commands;

import com.firework.client.Features.CommandsSystem.Command;
import com.firework.client.Features.CommandsSystem.CommandManifest;
import com.firework.client.Features.Modules.Client.Notifications;
import net.minecraft.client.renderer.GlStateManager;

@CommandManifest(label="scale")
public class ScaleCommand
extends Command {
    @Override
    public void execute(String[] args) {
        Notifications.notificate();
        super.execute(args);
        float scale = Float.parseFloat(args[0]);
        GlStateManager.scale((float)scale, (float)scale, (float)scale);
    }
}
