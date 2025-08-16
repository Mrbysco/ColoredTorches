package com.mrbysco.coloredtorches.data.assets;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

public class TorchModelProvider extends ModelProvider {
	public TorchModelProvider(PackOutput output) {
		super(output, ColoredTorchesMod.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		blockModels.createNormalTorch(TorchRegistry.WHITE_TORCH.get(), TorchRegistry.WALL_WHITE_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.ORANGE_TORCH.get(), TorchRegistry.WALL_ORANGE_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.MAGENTA_TORCH.get(), TorchRegistry.WALL_MAGENTA_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.LIGHT_BLUE_TORCH.get(), TorchRegistry.WALL_LIGHT_BLUE_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.YELLOW_TORCH.get(), TorchRegistry.WALL_YELLOW_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.LIME_TORCH.get(), TorchRegistry.WALL_LIME_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.PINK_TORCH.get(), TorchRegistry.WALL_PINK_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.GRAY_TORCH.get(), TorchRegistry.WALL_GRAY_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.LIGHT_GRAY_TORCH.get(), TorchRegistry.WALL_LIGHT_GRAY_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.CYAN_TORCH.get(), TorchRegistry.WALL_CYAN_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.PURPLE_TORCH.get(), TorchRegistry.WALL_PURPLE_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.BLUE_TORCH.get(), TorchRegistry.WALL_BLUE_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.BROWN_TORCH.get(), TorchRegistry.WALL_BROWN_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.GREEN_TORCH.get(), TorchRegistry.WALL_GREEN_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.RED_TORCH.get(), TorchRegistry.WALL_RED_TORCH.get());
		blockModels.createNormalTorch(TorchRegistry.BLACK_TORCH.get(), TorchRegistry.WALL_BLACK_TORCH.get());
	}
}
