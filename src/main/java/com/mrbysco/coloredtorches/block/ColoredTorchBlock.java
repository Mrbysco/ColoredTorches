package com.mrbysco.coloredtorches.block;

import com.mrbysco.coloredtorches.client.ParticleColor;
import com.mrbysco.coloredtorches.client.particle.ColoredFlameParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ColoredTorchBlock extends TorchBlock {
	public final ParticleColor color;

	public ColoredTorchBlock(Properties properties, DyeColor dyeColor) {
		super(ParticleTypes.FLAME, properties);
		this.color = new ParticleColor(dyeColor.getFireworkColor());
	}

	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource randomSource) {
		double d0 = (double) pos.getX() + 0.5D;
		double d1 = (double) pos.getY() + 0.7D;
		double d2 = (double) pos.getZ() + 0.5D;
		level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);

		//Colored flame
		level.addParticle(ColoredFlameParticle.Provider.createData(color), d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}
}
