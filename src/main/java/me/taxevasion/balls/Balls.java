package me.taxevasion.balls;

import me.taxevasion.balls.commands.FunnyCommand;
import me.taxevasion.balls.commands.TpCommand;
import me.taxevasion.balls.modules.*;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Balls extends MeteorAddon {
	public static final Logger LOG = LoggerFactory.getLogger(Balls.class);
	public static final Category CATEGORY = new Category("Gayming", Items.SNOWBALL.getDefaultStack());

	@Override
	public void onInitialize() {
		LOG.info("Initializing Meteor Addon Template");

		// Required when using @EventHandler
		MeteorClient.EVENT_BUS.registerLambdaFactory("me.taxevasion.balls", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

		// Modules
        Modules.get().add(new AnyPlacer());
		Modules.get().add(new AutoSign());
		Modules.get().add(new ItemFrameDupe());

		// Commands
		Commands.get().add(new FunnyCommand());
        Commands.get().add(new TpCommand());
	}

	@Override
	public void onRegisterCategories() {
		Modules.registerCategory(CATEGORY);
	}
}
