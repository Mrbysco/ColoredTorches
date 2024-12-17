package com.mrbysco.coloredtorches;

import com.mojang.logging.LogUtils;
import com.mrbysco.coloredtorches.client.ClientHandler;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ColoredTorchesMod.MOD_ID)
public class ColoredTorchesMod {
	public static final String MOD_ID = "colored_torches";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ColoredTorchesMod() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		TorchRegistry.BLOCKS.register(eventBus);
		TorchRegistry.ITEMS.register(eventBus);
		TorchRegistry.CREATIVE_MODE_TABS.register(eventBus);

		ParticleRegistry.PARTICLE_TYPES.register(eventBus);

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.addListener(ClientHandler::registerParticleFactories);
		});
	}
}
