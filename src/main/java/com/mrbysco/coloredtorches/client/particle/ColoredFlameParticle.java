package com.mrbysco.coloredtorches.client.particle;

import com.mrbysco.coloredtorches.client.ParticleColor;
import com.mrbysco.coloredtorches.client.particle.data.ColoredFlameParticleTypeData;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.RisingParticle;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class ColoredFlameParticle extends RisingParticle {

	public ColoredFlameParticle(ClientLevel level, double x, double y, double z,
	                            double xSpeed, double ySpeed, double zSpeed,
	                            TextureAtlasSprite atlasSprite, ParticleColor particleColor
	) {
		super(level, x, y, z, xSpeed, ySpeed, zSpeed, atlasSprite);
		this.setColor(particleColor.getRed(), particleColor.getGreen(), particleColor.getBlue());
	}

	@Override
	public void move(double x, double y, double z) {
		this.setBoundingBox(this.getBoundingBox().move(x, y, z));
		this.setLocationFromBoundingbox();
	}

	@Override
	public float getQuadSize(float scaleFactor) {
		float f = ((float) this.age + scaleFactor) / (float) this.lifetime;
		return this.quadSize * (1.0F - f * f * 0.5F);
	}

	@Override
	public SingleQuadParticle.Layer getLayer() {
		return SingleQuadParticle.Layer.OPAQUE;
	}

	@Override
	public int getLightColor(float partialTick) {
		float f = ((float) this.age + partialTick) / (float) this.lifetime;
		f = Mth.clamp(f, 0.0F, 1.0F);
		int i = super.getLightColor(partialTick);
		int j = i & 255;
		int k = i >> 16 & 255;
		j += (int) (f * 15.0F * 16.0F);
		if (j > 240) {
			j = 240;
		}

		return j | k << 16;
	}

	public static class Provider implements ParticleProvider<ColoredFlameParticleTypeData> {
		private final SpriteSet sprite;

		public Provider(SpriteSet spriteSet) {
			this.sprite = spriteSet;
		}

		@Override
		public Particle createParticle(
				ColoredFlameParticleTypeData type,
				ClientLevel level,
				double x,
				double y,
				double z,
				double xSpeed,
				double ySpeed,
				double zSpeed,
				RandomSource randomSource
		) {
			return new ColoredFlameParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprite.get(randomSource), type.color);
		}

		public static ParticleOptions createData(ParticleColor color) {
			return new ColoredFlameParticleTypeData(ParticleRegistry.COLORED_FLAME.get(), color);
		}
	}
}