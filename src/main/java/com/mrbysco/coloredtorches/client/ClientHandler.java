package com.mrbysco.coloredtorches.client;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.client.particle.ColoredFlameParticle;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;

public class ClientHandler {
	public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ParticleRegistry.COLORED_FLAME.get(), ColoredFlameParticle.Provider::new);
	}

	public static void addPackFinders(AddPackFindersEvent event) {
		if (event.getPackType() == PackType.CLIENT_RESOURCES) {
			var resourcePath = ModList.get().getModFileById(ColoredTorchesMod.MOD_ID).getFile().findResource("programmer_art");
			var pack = Pack.readMetaAndCreate("builtin/programmer_art",
					Component.literal("Programmer Art"),
					false,
					(path) -> new PathPackResources(path, resourcePath, false),
					PackType.CLIENT_RESOURCES,
					Pack.Position.TOP,
					PackSource.BUILT_IN);
			event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
		}
	}
}
