package com.mrbysco.coloredtorches.client.particle.data;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.coloredtorches.client.ParticleColor;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;

public class ColoredFlameParticleTypeData implements ParticleOptions {
	private final ParticleType<ColoredFlameParticleTypeData> type;
	public static final Codec<ColoredFlameParticleTypeData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
					Codec.FLOAT.fieldOf("r").forGetter(d -> d.color.getRed()),
					Codec.FLOAT.fieldOf("g").forGetter(d -> d.color.getGreen()),
					Codec.FLOAT.fieldOf("b").forGetter(d -> d.color.getBlue()))
			.apply(instance, ColoredFlameParticleTypeData::new));
	public final ParticleColor color;
	@SuppressWarnings("deprecation")
	static final Deserializer<ColoredFlameParticleTypeData> DESERIALIZER = new Deserializer<ColoredFlameParticleTypeData>() {

		@Override
		public ColoredFlameParticleTypeData fromCommand(ParticleType<ColoredFlameParticleTypeData> type, StringReader reader) throws CommandSyntaxException {
			reader.expect(' ');
			return new ColoredFlameParticleTypeData(type, ParticleColor.deserialize(reader.readString()));
		}

		@Override
		public ColoredFlameParticleTypeData fromNetwork(ParticleType<ColoredFlameParticleTypeData> type, FriendlyByteBuf buffer) {
			return new ColoredFlameParticleTypeData(type, ParticleColor.deserialize(buffer.readUtf()));
		}
	};

	public ColoredFlameParticleTypeData(ParticleType<ColoredFlameParticleTypeData> particleTypeData, ParticleColor color) {
		this.type = particleTypeData;
		this.color = color;
	}

	public ColoredFlameParticleTypeData(float r, float g, float b) {
		this(ParticleRegistry.COLORED_FLAME.get(), new ParticleColor(r, g, b));
	}

	@Override
	public ParticleType<?> getType() {
		return type;
	}

	@Override
	public void writeToNetwork(FriendlyByteBuf buffer) {
	}

	@Override
	public String writeToString() {
		return null;
	}
}
