package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.gui.GuiTheme;
import meteordevelopment.meteorclient.gui.widgets.WWidget;
import meteordevelopment.meteorclient.gui.widgets.containers.WHorizontalList;
import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.ColorSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.settings.StringSetting;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
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

    private final Setting<SettingColor> color = sgGeneral.add(new ColorSetting.Builder()
        .name("color")
        .description("color of text")
        .defaultValue(new SettingColor())
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
        .description("makes it into the allah language")
        .defaultValue(false)
        .build()
    );

    private final Setting<Boolean> str = sgGeneral.add(new BoolSetting.Builder()
        .name("strikethrough")
        .description("i didnt even know this existed")
        .defaultValue(false)
        .build()
    );

    public Tellraw() {
        super(Allah.CATEGORY, "tellraw", "IT FUCKING WORKS HAHAHAHAHHAH");
    }

    public String red() { //apparently this is good code even though to me it looks horrifically long
        if (color.get().r < 16) {
            return "0" + Integer.toHexString(color.get().r);
        } else {
            return Integer.toHexString(color.get().r);
        }
    }

    public String green() {
        if (color.get().g < 16) {
            return "0" + Integer.toHexString(color.get().g);
        } else {
            return Integer.toHexString(color.get().g);
        }
    }

    public String blue() {
        if (color.get().b < 16) {
            return "0" + Integer.toHexString(color.get().b);
        } else {
            return Integer.toHexString(color.get().b);
        }
    }

    @Override
    public WWidget getWidget(GuiTheme theme) {
        WHorizontalList what = theme.horizontalList();
        WButton print = what.add(theme.button("Print")).widget();
        print.action = () -> {
            String cmd = ("/tellraw " + players.get() + " {\"bold\":" + bold.get() + ",\"color\":\"#" + red() + green() + blue() + "\",\"italic\":" + italic.get() + ",\"strikethrough\":" + str.get() + ",\"obfuscated\":" + obf.get() + ",\"text\":\"" + msg.get() + "\",\"underlined\":" + underline.get() + "}");
            if (isActive()) {
                mc.player.sendChatMessage(cmd);
            }
        };
        return what;
    }
}
