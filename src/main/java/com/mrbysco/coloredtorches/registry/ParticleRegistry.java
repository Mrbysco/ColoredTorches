package com.mrbysco.coloredtorches.registry;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.client.particle.data.ColoredFlameParticleType;
import com.mrbysco.coloredtorches.client.particle.data.ColoredFlameParticleTypeData;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleRegistry {

	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, ColoredTorchesMod.MOD_ID);
	public static final DeferredHolder<ParticleType<?>, ParticleType<ColoredFlameParticleTypeData>> COLORED_FLAME = PARTICLE_TYPES.register("colored_flame", ColoredFlameParticleType::new);
}
