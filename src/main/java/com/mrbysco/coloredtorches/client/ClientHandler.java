package com.mrbysco.coloredtorches.client;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.client.particle.ColoredFlameParticle;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;

public class ClientHandler {
	public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ParticleRegistry.COLORED_FLAME.get(), ColoredFlameParticle.Provider::new);
	}

	public static void addPackFinders(AddPackFindersEvent event) {
		if (event.getPackType() == PackType.CLIENT_RESOURCES) {
			event.addPackFinders(ResourceLocation.fromNamespaceAndPath(ColoredTorchesMod.MOD_ID, "programmer_art"), PackType.CLIENT_RESOURCES,
					Component.literal("Programmer Art"), PackSource.BUILT_IN, false, Pack.Position.TOP);
		}
	}
}
