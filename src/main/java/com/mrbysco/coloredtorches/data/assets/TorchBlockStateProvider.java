package com.mrbysco.coloredtorches.data.assets;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TorchBlockStateProvider extends BlockStateProvider {

	public TorchBlockStateProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, ColoredTorchesMod.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		torch(TorchRegistry.WHITE_TORCH, TorchRegistry.WALL_WHITE_TORCH);
		torch(TorchRegistry.ORANGE_TORCH, TorchRegistry.WALL_ORANGE_TORCH);
		torch(TorchRegistry.MAGENTA_TORCH, TorchRegistry.WALL_MAGENTA_TORCH);
		torch(TorchRegistry.LIGHT_BLUE_TORCH, TorchRegistry.WALL_LIGHT_BLUE_TORCH);
		torch(TorchRegistry.YELLOW_TORCH, TorchRegistry.WALL_YELLOW_TORCH);
		torch(TorchRegistry.LIME_TORCH, TorchRegistry.WALL_LIME_TORCH);
		torch(TorchRegistry.PINK_TORCH, TorchRegistry.WALL_PINK_TORCH);
		torch(TorchRegistry.GRAY_TORCH, TorchRegistry.WALL_GRAY_TORCH);
		torch(TorchRegistry.LIGHT_GRAY_TORCH, TorchRegistry.WALL_LIGHT_GRAY_TORCH);
		torch(TorchRegistry.CYAN_TORCH, TorchRegistry.WALL_CYAN_TORCH);
		torch(TorchRegistry.PURPLE_TORCH, TorchRegistry.WALL_PURPLE_TORCH);
		torch(TorchRegistry.BLUE_TORCH, TorchRegistry.WALL_BLUE_TORCH);
		torch(TorchRegistry.BROWN_TORCH, TorchRegistry.WALL_BROWN_TORCH);
		torch(TorchRegistry.GREEN_TORCH, TorchRegistry.WALL_GREEN_TORCH);
		torch(TorchRegistry.RED_TORCH, TorchRegistry.WALL_RED_TORCH);
		torch(TorchRegistry.BLACK_TORCH, TorchRegistry.WALL_BLACK_TORCH);
	}

	public void torch(RegistryObject<Block> block, RegistryObject<Block> wall) {
		String blockPath = block.getId().getPath();
		ModelFile torch = models().torch(blockPath, texture(blockPath)).renderType("cutout");
		ModelFile wallTorch = models().torchWall("wall_" + blockPath, texture(blockPath)).renderType("cutout");
		simpleBlock(block.get(), torch);
		getVariantBuilder(wall.get()).forAllStates(state ->
				ConfiguredModel.builder()
						.modelFile(wallTorch)
						.rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90) % 360)
						.build());
	}

	protected ResourceLocation texture(String name) {
		return modLoc("block/" + name);
	}
}