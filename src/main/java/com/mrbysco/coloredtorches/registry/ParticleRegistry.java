package com.mrbysco.coloredtorches.registry;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.client.particle.data.ColoredFlameParticleType;
import com.mrbysco.coloredtorches.client.particle.data.ColoredFlameParticleTypeData;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleRegistry {

	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ColoredTorchesMod.MOD_ID);
	public static final RegistryObject<ParticleType<ColoredFlameParticleTypeData>> COLORED_FLAME = PARTICLE_TYPES.register("colored_flame", ColoredFlameParticleType::new);
}
