package com.firework.client.Features.Modules.Combat;

import com.firework.client.Features.Modules.Module;
import com.firework.client.Features.Modules.ModuleArgs;
import com.firework.client.Implementations.Events.PacketEvent;
import com.firework.client.Implementations.Settings.Setting;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@ModuleArgs(name="Velocity", category=Module.Category.COMBAT)
public class Velocity
extends Module {
    public Setting<Boolean> push = new Setting<Boolean>("Push", true, this);

    @SubscribeEvent
    public void onPacketReceive(PacketEvent.Receive e) {
        if (e.getPacket() instanceof SPacketEntityVelocity && ((SPacketEntityVelocity)((Object)e.getPacket())).getEntityID() == this.mc.player.getEntityId()) {
            e.setCanceled(true);
        }
        if (e.getPacket() instanceof SPacketExplosion) {
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPush(PlayerSPPushOutOfBlocksEvent e) {
        if (this.push.getValue().booleanValue()) {
            e.setCanceled(true);
        }
    }
}
