package com.mrbysco.coloredtorches.client.particle.data;

import com.mojang.serialization.Codec;
import net.minecraft.core.particles.ParticleType;

public class ColoredFlameParticleType extends ParticleType<ColoredFlameParticleTypeData> {
	public ColoredFlameParticleType() {
		super(false, ColoredFlameParticleTypeData.DESERIALIZER);
	}

	@Override
	public Codec<ColoredFlameParticleTypeData> codec() {
		return ColoredFlameParticleTypeData.CODEC;
	}
}
