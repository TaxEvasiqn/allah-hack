package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.gui.GuiTheme;
import meteordevelopment.meteorclient.gui.widgets.WWidget;
import meteordevelopment.meteorclient.gui.widgets.containers.WHorizontalList;
import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import org.apache.commons.lang3.RandomStringUtils;
import uwu.taxevasion.allahhack.Allah;

import java.util.ArrayList;


public class Printer extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Modes> mode = sgGeneral.add(new EnumSetting.Builder<Modes>()
        .name("mode")
        .description("how to like do it")
        .defaultValue(Modes.Tellraw)
        .build());

    private final Setting<TitleModes> tmode = sgGeneral.add(new EnumSetting.Builder<TitleModes>()
        .name("mode")
        .description("you know the drill")
        .defaultValue(TitleModes.title)
        .visible(() -> mode.get() == Modes.Title)
        .build());

    private final Setting<Integer> time = sgGeneral.add(new IntSetting.Builder()
        .name("time")
        .description("how long it stays on the players screen in ticks")
        .defaultValue(200)
        .sliderRange(0, 5000)
        .visible(() -> mode.get() == Modes.Title)
        .build());

    private final Setting<Integer> fadein = sgGeneral.add(new IntSetting.Builder()
        .name("fade-in")
        .description("how long it takes to fade in")
        .defaultValue(0)
        .sliderRange(0, 100)
        .visible(() -> mode.get() == Modes.Title)
        .build());

    private final Setting<Integer> fadeout = sgGeneral.add(new IntSetting.Builder()
        .name("fade-out")
        .description("how long it takes to fade out")
        .defaultValue(0)
        .sliderRange(0, 100)
        .visible(() -> mode.get() == Modes.Title)
        .build());

    private final Setting<String> msg = sgGeneral.add(new StringSetting.Builder()
        .name("message")
        .description("message to print")
        .defaultValue("i love boys")
        .build());

    private final Setting<String> players = sgGeneral.add(new StringSetting.Builder()
        .name("players")
        .description("who does it display to (can put player names)")
        .defaultValue("@a")
        .build());

    private final Setting<SettingColor> color = sgGeneral.add(new ColorSetting.Builder()
        .name("color")
        .description("color of text")
        .defaultValue(new SettingColor())
        .build());

    private final Setting<Boolean> bold = sgGeneral.add(new BoolSetting.Builder()
        .name("bold")
        .description("makes it bold")
        .defaultValue(false)
        .build());

    private final Setting<Boolean> italic = sgGeneral.add(new BoolSetting.Builder()
        .name("italics")
        .description("is it italic")
        .defaultValue(false)
        .build());

    private final Setting<Boolean> underline = sgGeneral.add(new BoolSetting.Builder()
        .name("underline")
        .description("underline")
        .defaultValue(false)
        .build());

    private final Setting<Boolean> obf = sgGeneral.add(new BoolSetting.Builder()
        .name("obfuscate")
        .description("makes it into the allah language")
        .defaultValue(false)
        .build());

    private final Setting<Boolean> str = sgGeneral.add(new BoolSetting.Builder()
        .name("strikethrough")
        .description("i didnt even know this existed")
        .defaultValue(false)
        .build());

    public Printer() {
        super(Allah.CATEGORY, "printer", "inshallah it sends a message from the heavens");
    }

    //Color
    public String red() {
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

    //the printing
    @Override
    public WWidget getWidget(GuiTheme theme) {
        WHorizontalList what = theme.horizontalList();
        WButton print = what.add(theme.button("Print")).widget();
        print.action = () -> {
            if (isActive()) {
                if (mode.get() == Modes.Tellraw) {
                    String cmd = ("/tellraw " + players.get() + " {\"bold\":" + bold.get() + ",\"color\":\"#" + red() + green() + blue() + "\",\"italic\":" + italic.get() + ",\"strikethrough\":" + str.get() + ",\"obfuscated\":" + obf.get() + ",\"text\":\"" + msg.get() + "\",\"underlined\":" + underline.get() + "}");
                    mc.player.sendChatMessage(cmd);
                } else if (mode.get() == Modes.Title) {
                    String cmd = ("/title " + players.get() + " " + tmode.get().toString() + " {\"bold\":" + bold.get() + ",\"color\":\"#" + red() + green() + blue() + "\",\"italic\":" + italic.get() + ",\"strikethrough\":" + str.get() + ",\"obfuscated\":" + obf.get() + ",\"text\":\"" + msg.get() + "\",\"underlined\":" + underline.get() + "}");
                    mc.player.sendChatMessage("/title " + players.get() + " times " + fadein.get() + " " + time.get() + " " + fadeout.get());
                    mc.player.sendChatMessage(cmd);
                } else {
                    String id = RandomStringUtils.randomAlphanumeric(5).toLowerCase();
                    String cmd = ("/bossbar add " + id + " {\"bold\":" + bold.get() + ",\"color\":\"#" + red() + green() + blue() + "\",\"italic\":" + italic.get() + ",\"strikethrough\":" + str.get() + ",\"obfuscated\":" + obf.get() + ",\"text\":\"" + msg.get() + "\",\"underlined\":" + underline.get() + "}");
                    mc.player.sendChatMessage(cmd);
                    mc.player.sendChatMessage("/bossbar set " + id + " players " + players.get());
                }
            }
        };

        WButton clear = what.add(theme.button("Clear")).widget();
        clear.action = () -> {
            if (isActive()) { // clearing bossbar is very hard
                mc.player.sendChatMessage("/title " + players.get() + " clear");
            }
        };
        return what;
    }

    public enum Modes {
        Tellraw, Title, Bossbar
    }

    public enum TitleModes {
        actionbar, title
    }
}
