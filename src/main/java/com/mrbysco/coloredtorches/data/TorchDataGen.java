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
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TorchDataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(event.includeServer(), new TorchLootProvider(packOutput));
			generator.addProvider(event.includeServer(), new TorchRecipeProvider(packOutput));
			BlockTagsProvider provider;
			generator.addProvider(event.includeServer(), provider = new TorchBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
			generator.addProvider(event.includeServer(), new TorchItemTagsProvider(packOutput, lookupProvider, provider, existingFileHelper));
		}
		if (event.includeClient()) {
			generator.addProvider(event.includeClient(), new TorchLanguageProvider(packOutput));
			generator.addProvider(event.includeClient(), new TorchBlockStateProvider(packOutput, existingFileHelper));
			generator.addProvider(event.includeClient(), new TorchItemModelProvider(packOutput, existingFileHelper));
		}
	}
}