package com.mrbysco.coloredtorches.client;

import com.mrbysco.coloredtorches.client.particle.ColoredFlameParticle;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;

public class ClientHandler {
	public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ParticleRegistry.COLORED_FLAME.get(), ColoredFlameParticle.Provider::new);
	}
}
