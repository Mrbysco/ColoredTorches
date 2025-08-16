package com.mrbysco.coloredtorches.data;

import com.mrbysco.coloredtorches.data.assets.TorchBlockStateProvider;
import com.mrbysco.coloredtorches.data.assets.TorchItemModelProvider;
import com.mrbysco.coloredtorches.data.assets.TorchLanguageProvider;
import com.mrbysco.coloredtorches.data.data.TorchLootProvider;
import com.mrbysco.coloredtorches.data.data.TorchRecipeProvider;
import com.mrbysco.coloredtorches.data.data.tags.TorchBlockTagsProvider;
import com.mrbysco.coloredtorches.data.data.tags.TorchItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TorchDataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(true, new TorchLootProvider(packOutput, lookupProvider));
			generator.addProvider(true, new TorchRecipeProvider(packOutput, lookupProvider));
			BlockTagsProvider provider;
			generator.addProvider(true, provider = new TorchBlockTagsProvider(packOutput, lookupProvider, helper));
			generator.addProvider(true, new TorchItemTagsProvider(packOutput, lookupProvider, provider, helper));
		}
		if (event.includeClient()) {
			generator.addProvider(true, new TorchLanguageProvider(packOutput));
			generator.addProvider(true, new TorchBlockStateProvider(packOutput, helper));
			generator.addProvider(true, new TorchItemModelProvider(packOutput, helper));
		}
	}
}