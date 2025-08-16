package com.mrbysco.coloredtorches.data.assets;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TorchLanguageProvider extends LanguageProvider {
	public TorchLanguageProvider(PackOutput packOutput) {
		super(packOutput, ColoredTorchesMod.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		//Creative Tab
		add("itemGroup.colored_torches", "Colored Torches");

		addBlock(TorchRegistry.WHITE_TORCH, "White Torch");
		addBlock(TorchRegistry.ORANGE_TORCH, "Orange Torch");
		addBlock(TorchRegistry.MAGENTA_TORCH, "Magenta Torch");
		addBlock(TorchRegistry.LIGHT_BLUE_TORCH, "Light Blue Torch");
		addBlock(TorchRegistry.YELLOW_TORCH, "Yellow Torch");
		addBlock(TorchRegistry.LIME_TORCH, "Lime Torch");
		addBlock(TorchRegistry.PINK_TORCH, "Pink Torch");
		addBlock(TorchRegistry.GRAY_TORCH, "Gray Torch");
		addBlock(TorchRegistry.LIGHT_GRAY_TORCH, "Light Gray Torch");
		addBlock(TorchRegistry.CYAN_TORCH, "Cyan Torch");
		addBlock(TorchRegistry.PURPLE_TORCH, "Purple Torch");
		addBlock(TorchRegistry.BLUE_TORCH, "Blue Torch");
		addBlock(TorchRegistry.BROWN_TORCH, "Brown Torch");
		addBlock(TorchRegistry.GREEN_TORCH, "Green Torch");
		addBlock(TorchRegistry.RED_TORCH, "Red Torch");
		addBlock(TorchRegistry.BLACK_TORCH, "Black Torch");
	}
}