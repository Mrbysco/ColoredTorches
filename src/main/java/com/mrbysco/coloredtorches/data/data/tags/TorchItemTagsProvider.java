package com.mrbysco.coloredtorches.data.data.tags;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class TorchItemTagsProvider extends ItemTagsProvider {
	public TorchItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
								 TagsProvider<Block> blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTagProvider.contentsGetter(), ColoredTorchesMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {

	}
}