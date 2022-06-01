package uwu.taxevasion.allahhack;

import uwu.taxevasion.allahhack.commands.ForceOpCommand;
import uwu.taxevasion.allahhack.commands.ItemCommand;
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
	public static final Category CATEGORY = new Category("AllahHack", Items.ACACIA_BOAT.getDefaultStack());

	@Override
	public void onInitialize() {
		LOG.info("summoning allah");

		// Required when using @EventHandler
		MeteorClient.EVENT_BUS.registerLambdaFactory("uwu.taxevasion.allahhack", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

		// Modules
        Modules.get().add(new Airstrike());
        Modules.get().add(new AnyPlacer());
        Modules.get().add(new Boom());
        Modules.get().add(new ChunkCrash());
        Modules.get().add(new ClickNuke());
        Modules.get().add(new Tellraw());

		// Commands
        Commands.get().add(new ForceOpCommand());
		Commands.get().add(new ItemCommand());
	}

	@Override
	public void onRegisterCategories() {
		Modules.registerCategory(CATEGORY);
	}
}
