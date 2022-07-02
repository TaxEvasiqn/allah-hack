package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import uwu.taxevasion.allahhack.Allah;

import java.util.List;

public class AutoExecute extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<List<String>> cmds = sgGeneral.add(new StringListSetting.Builder()
        .name("commands")
        .description("Commands to run")
        .defaultValue(List.of("/say wow", "/tellraw @a {\"text\":\"balls\"}"))
        .build());

    public AutoExecute() {
        super(Allah.CATEGORY, "auto-execute", "Automatically executes commands on activate");
    }

    @EventHandler
    public void onActivate() {
        if (!(cmds.get().isEmpty())) {
            for (int i = 0; i < cmds.get().size(); i++) {
                mc.player.sendChatMessage(cmds.get().get(i));
            }
            info("Tried to run commands, toggling.");
            toggle();
        } else {
            error("you need commands idiot");
            toggle();
        }
    }
}
