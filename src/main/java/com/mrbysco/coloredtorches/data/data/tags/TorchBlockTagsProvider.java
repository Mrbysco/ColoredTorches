package com.mrbysco.coloredtorches.data.data.tags;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class TorchBlockTagsProvider extends BlockTagsProvider {
	public TorchBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, ColoredTorchesMod.MOD_ID);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(BlockTags.WALL_POST_OVERRIDE).add(
				TorchRegistry.WHITE_TORCH.get(),
				TorchRegistry.ORANGE_TORCH.get(),
				TorchRegistry.MAGENTA_TORCH.get(),
				TorchRegistry.LIGHT_BLUE_TORCH.get(),
				TorchRegistry.YELLOW_TORCH.get(),
				TorchRegistry.LIME_TORCH.get(),
				TorchRegistry.PINK_TORCH.get(),
				TorchRegistry.GRAY_TORCH.get(),
				TorchRegistry.LIGHT_GRAY_TORCH.get(),
				TorchRegistry.CYAN_TORCH.get(),
				TorchRegistry.PURPLE_TORCH.get(),
				TorchRegistry.BLUE_TORCH.get(),
				TorchRegistry.BROWN_TORCH.get(),
				TorchRegistry.GREEN_TORCH.get(),
				TorchRegistry.RED_TORCH.get(),
				TorchRegistry.BLACK_TORCH.get()
		);
	}
}