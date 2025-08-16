package com.mrbysco.coloredtorches.client.particle.data;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class ColoredFlameParticleType extends ParticleType<ColoredFlameParticleTypeData> {
	public ColoredFlameParticleType() {
		super(false);
	}

	@Override
	public MapCodec<ColoredFlameParticleTypeData> codec() {
		return ColoredFlameParticleTypeData.CODEC;
	}

	@Override
	public StreamCodec<? super RegistryFriendlyByteBuf, ColoredFlameParticleTypeData> streamCodec() {
		return ColoredFlameParticleTypeData.STREAM_CODEC;
	}
}
