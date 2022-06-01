package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.misc.Keybind;
import uwu.taxevasion.allahhack.Allah;

public class Tellraw extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<String> msg = sgGeneral.add(new StringSetting.Builder()
        .name("message")
        .description("message to print")
        .defaultValue("i love boys")
        .build()
    );

    private final Setting<String> players = sgGeneral.add(new StringSetting.Builder()
        .name("players")
        .description("who does it display to (can put player names)")
        .defaultValue("@a")
        .build()
    );

    private final Setting<String> color = sgGeneral.add(new StringSetting.Builder()
        .name("color")
        .description("color or hex code")
        .defaultValue("white")
        .build()
    );

    private final Setting<Boolean> bold = sgGeneral.add(new BoolSetting.Builder()
        .name("bold")
        .description("makes it bold")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> italic = sgGeneral.add(new BoolSetting.Builder()
        .name("italics")
        .description("is it italic")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> underline = sgGeneral.add(new BoolSetting.Builder()
        .name("underline")
        .description("underline")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> obf = sgGeneral.add(new BoolSetting.Builder()
        .name("obfuscate")
        .description("makes it into the allah language (why would you want this)")
        .defaultValue(false)
        .build()
    );

    private final Setting<Keybind> keybind = sgGeneral.add(new KeybindSetting.Builder()
        .name("print")
        .description("press to print the tellraw")
        .action(this::print)
        .build()
    );

    public Tellraw() {
        super(Allah.CATEGORY, "Tellraw", "allah sends an official message in chat (needs op)");
    }

    private void print() {
        String cmd = "/tellraw " + players.get() + " " + "{\"bold\":" + bold.get() + "\"color\":\"" + color.get() + ",\"italic\":" + italic.get() + ",\"obfuscated\":" + obf.get() + ",\"text\":\"" + msg.get() + ",\"underline\":" + underline.get() + "}";
        mc.player.sendChatMessage(cmd);
    }
}
