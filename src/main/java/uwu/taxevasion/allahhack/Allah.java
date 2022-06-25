package uwu.taxevasion.allahhack;

import uwu.taxevasion.allahhack.commands.*;
import uwu.taxevasion.allahhack.modules.*;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Allah extends MeteorAddon {
	public static final Logger LOG = LoggerFactory.getLogger(Allah.class);
	public static final Category CATEGORY = new Category("AllahHack", Items.PLAYER_HEAD.getDefaultStack());

	@Override
	public void onInitialize() {
		LOG.info("summoning allah");

		// Required when using @EventHandler
		MeteorClient.EVENT_BUS.registerLambdaFactory("uwu.taxevasion.allahhack", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

		// alphabetical order unlike another client
        Modules.get().add(new Airstrike());
        Modules.get().add(new AnyPlacer());
        Modules.get().add(new AutoExecute());
        Modules.get().add(new AutoFemboy());
        Modules.get().add(new FlightPlus());
        Modules.get().add(new Boom());
        Modules.get().add(new ChunkCrash());
        Modules.get().add(new ClickNuke());
        Modules.get().add(new ConsoleFlood());
        Modules.get().add(new NoJumpCooldown());
        Modules.get().add(new ShulkerDupe());
        Modules.get().add(new Printer());
        Modules.get().add(new VelocityBoost());
        Modules.get().add(new InstantVoider());

        Commands.get().add(new BloatCommand());
        Commands.get().add(new ClearCommand());
        Commands.get().add(new CorruptCommand());
        Commands.get().add(new CrashCommand());
        Commands.get().add(new EffectCommand());
        Commands.get().add(new ForceOpCommand());
        Commands.get().add(new HideCommand());
        Commands.get().add(new KillCommand());
        Commands.get().add(new RenameCommand());
        Commands.get().add(new ShriekCommand());
        Commands.get().add(new StopCommand());
	}

	@Override
	public void onRegisterCategories() {
		Modules.registerCategory(CATEGORY);
	}
}
