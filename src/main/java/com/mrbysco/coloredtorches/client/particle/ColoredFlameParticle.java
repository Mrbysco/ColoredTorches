package com.mrbysco.coloredtorches.client.particle;

import com.mrbysco.coloredtorches.client.ParticleColor;
import com.mrbysco.coloredtorches.client.particle.data.ColoredFlameParticleTypeData;
import com.mrbysco.coloredtorches.registry.ParticleRegistry;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.RisingParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ColoredFlameParticle extends RisingParticle {

	ColoredFlameParticle(ClientLevel level, double p_106801_, double p_106802_, double p_106803_, double p_106804_, double p_106805_, double p_106806_, float r, float g, float b) {
		super(level, p_106801_, p_106802_, p_106803_, p_106804_, p_106805_, p_106806_);
		this.rCol = r;
		this.gCol = g;
		this.bCol = b;
	}

	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	public void move(double x, double y, double z) {
		this.setBoundingBox(this.getBoundingBox().move(x, y, z));
		this.setLocationFromBoundingbox();
	}

	public float getQuadSize(float scaleFactor) {
		float f = ((float) this.age + scaleFactor) / (float) this.lifetime;
		return this.quadSize * (1.0F - f * f * 0.5F);
	}

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

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<ColoredFlameParticleTypeData> {
		private final SpriteSet sprite;

		public Provider(SpriteSet spriteSet) {
			this.sprite = spriteSet;
		}

		public Particle createParticle(ColoredFlameParticleTypeData data, ClientLevel p_106839_, double p_106840_, double p_106841_, double p_106842_, double p_106843_, double p_106844_, double p_106845_) {
			ColoredFlameParticle coloredFlameParticle = new ColoredFlameParticle(p_106839_, p_106840_, p_106841_, p_106842_, p_106843_, p_106844_, p_106845_, data.color.getRed(), data.color.getGreen(), data.color.getBlue());
			coloredFlameParticle.pickSprite(this.sprite);
			return coloredFlameParticle;
		}

		public static ParticleOptions createData(ParticleColor color) {
			return new ColoredFlameParticleTypeData(ParticleRegistry.COLORED_FLAME.get(), color);
		}
	}
}