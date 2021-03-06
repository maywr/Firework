package com.firework.client.Features.CommandsSystem.Commands.Chat;

import com.firework.client.Features.CommandsSystem.Command;
import com.firework.client.Features.CommandsSystem.CommandManager;
import com.firework.client.Features.CommandsSystem.CommandManifest;
import com.firework.client.Features.Modules.Client.Notifications;
import com.firework.client.Firework;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

@CommandManifest(label="prefix")
public class PrefixCommand
extends Command {
    @Override
    public void execute(String[] args) {
        Notifications.notificate();
        JSONObject obj = new JSONObject();
        obj.put("Prefix", args[1]);
        try (FileWriter file = new FileWriter(Firework.FIREWORK_DIRECTORY + "Prefix.json");){
            file.write(obj.toJSONString());
            CommandManager.prefix = args[1];
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
