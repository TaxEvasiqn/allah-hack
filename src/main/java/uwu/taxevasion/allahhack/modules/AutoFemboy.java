package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.game.SendMessageEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.message.MessageSignature;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import uwu.taxevasion.allahhack.Allah;

public class AutoFemboy extends Module {
    public AutoFemboy() {
        super(Allah.CATEGORY, "auto-femboy", "im a little femboy uwu");
    }

    @EventHandler
    private void onMessageSend(SendMessageEvent event) {
        event.cancel();
        String owo = event.message;
        String a = owo.replaceAll("o", "owo");
        String b = a.replaceAll("u", "uwu");
        String c = b.replaceAll("r", "w");
        String d = c.replaceAll("l", "w");
        mc.getNetworkHandler().sendPacket(new ChatMessageC2SPacket(d, MessageSignature.none(), false));
    }
}
