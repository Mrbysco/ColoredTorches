package com.mrbysco.coloredtorches.block;

import com.mrbysco.coloredtorches.client.ParticleColor;
import com.mrbysco.coloredtorches.client.particle.ColoredFlameParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ColoredWallTorchBlock extends WallTorchBlock {
	public final ParticleColor color;

	public ColoredWallTorchBlock(Properties properties, DyeColor dyeColor) {
		super(properties, ParticleTypes.FLAME);
		this.color = ParticleColor.fromInt(dyeColor.getFireworkColor());
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource randomSource) {
		Direction direction = blockState.getValue(FACING);
		double d0 = (double) pos.getX() + 0.5D;
		double d1 = (double) pos.getY() + 0.7D;
		double d2 = (double) pos.getZ() + 0.5D;
		double d3 = 0.22D;
		double d4 = 0.27D;
		Direction direction1 = direction.getOpposite();
		level.addParticle(ParticleTypes.SMOKE, d0 + 0.27D * (double) direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double) direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
		level.addParticle(ColoredFlameParticle.Provider.createData(color), d0 + 0.27D * (double) direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double) direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
	}

}
