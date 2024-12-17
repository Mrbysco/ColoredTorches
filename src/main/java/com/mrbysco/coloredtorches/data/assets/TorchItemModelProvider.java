package com.mrbysco.coloredtorches.data.assets;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TorchItemModelProvider extends ItemModelProvider {
	public TorchItemModelProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, ColoredTorchesMod.MOD_ID, helper);
	}

	@Override
	protected void registerModels() {
		torchItem(TorchRegistry.WHITE_TORCH);
		torchItem(TorchRegistry.ORANGE_TORCH);
		torchItem(TorchRegistry.MAGENTA_TORCH);
		torchItem(TorchRegistry.LIGHT_BLUE_TORCH);
		torchItem(TorchRegistry.YELLOW_TORCH);
		torchItem(TorchRegistry.LIME_TORCH);
		torchItem(TorchRegistry.PINK_TORCH);
		torchItem(TorchRegistry.GRAY_TORCH);
		torchItem(TorchRegistry.LIGHT_GRAY_TORCH);
		torchItem(TorchRegistry.CYAN_TORCH);
		torchItem(TorchRegistry.PURPLE_TORCH);
		torchItem(TorchRegistry.BLUE_TORCH);
		torchItem(TorchRegistry.BROWN_TORCH);
		torchItem(TorchRegistry.GREEN_TORCH);
		torchItem(TorchRegistry.RED_TORCH);
		torchItem(TorchRegistry.BLACK_TORCH);
	}

	public void torchItem(RegistryObject<Block> torch) {
		String path = torch.getId().getPath();
		singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("block/" + path));
	}

	@Override
	public String getName() {
		return "Item Models";
	}
}