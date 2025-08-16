package com.mrbysco.coloredtorches.client.particle.data;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.coloredtorches.client.ParticleColor;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class ColoredFlameParticleTypeData implements ParticleOptions {
	private final ParticleType<ColoredFlameParticleTypeData> type;
	public static final MapCodec<ColoredFlameParticleTypeData> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
							ParticleColor.CODEC.fieldOf("color").forGetter(p_253371_ -> p_253371_.color)
					)
					.apply(instance, ColoredFlameParticleTypeData::new)
	);
	public final ParticleColor color;

	public static final StreamCodec<RegistryFriendlyByteBuf, ColoredFlameParticleTypeData> STREAM_CODEC = StreamCodec.composite(
			ParticleColor.STREAM_CODEC, data -> data.color, ColoredFlameParticleTypeData::new
	);

	public ColoredFlameParticleTypeData(ParticleType<ColoredFlameParticleTypeData> particleTypeData, ParticleColor color) {
		this.type = particleTypeData;
		this.color = color;
	}

	public ColoredFlameParticleTypeData(float r, float g, float b, float a) {
		this(ParticleRegistry.COLORED_FLAME.get(), new ParticleColor(r, g, b, a));
	}

	public ColoredFlameParticleTypeData(ParticleColor color) {
		this(ParticleRegistry.COLORED_FLAME.get(), color);
	}

	@Override
	public ParticleType<?> getType() {
		return type;
	}
}
