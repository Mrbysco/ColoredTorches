package com.mrbysco.coloredtorches;

import com.mojang.logging.LogUtils;
import com.mrbysco.coloredtorches.client.ClientHandler;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ColoredTorchesMod.MOD_ID)
public class ColoredTorchesMod {
	public static final String MOD_ID = "colored_torches";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ColoredTorchesMod(IEventBus eventBus, ModContainer container, Dist dist) {
		TorchRegistry.BLOCKS.register(eventBus);
		TorchRegistry.ITEMS.register(eventBus);
		TorchRegistry.CREATIVE_MODE_TABS.register(eventBus);

		ParticleRegistry.PARTICLE_TYPES.register(eventBus);

		if (dist.isClient()) {
			eventBus.addListener(ClientHandler::registerParticleFactories);
			eventBus.addListener(ClientHandler::addPackFinders);
		}
	}
}
