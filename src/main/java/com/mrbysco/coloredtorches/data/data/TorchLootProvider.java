package com.mrbysco.coloredtorches.data.data;

import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TorchLootProvider extends LootTableProvider {
	public TorchLootProvider(PackOutput packOutput) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(ForceBlocks::new, LootContextParamSets.BLOCK)
		));
	}

	private static class ForceBlocks extends BlockLootSubProvider {

		protected ForceBlocks() {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags());
		}

		@Override
		protected void generate() {
			dropSelf(TorchRegistry.WHITE_TORCH.get());
			dropSelf(TorchRegistry.ORANGE_TORCH.get());
			dropSelf(TorchRegistry.MAGENTA_TORCH.get());
			dropSelf(TorchRegistry.LIGHT_BLUE_TORCH.get());
			dropSelf(TorchRegistry.YELLOW_TORCH.get());
			dropSelf(TorchRegistry.LIME_TORCH.get());
			dropSelf(TorchRegistry.PINK_TORCH.get());
			dropSelf(TorchRegistry.GRAY_TORCH.get());
			dropSelf(TorchRegistry.LIGHT_GRAY_TORCH.get());
			dropSelf(TorchRegistry.CYAN_TORCH.get());
			dropSelf(TorchRegistry.PURPLE_TORCH.get());
			dropSelf(TorchRegistry.BLUE_TORCH.get());
			dropSelf(TorchRegistry.BROWN_TORCH.get());
			dropSelf(TorchRegistry.GREEN_TORCH.get());
			dropSelf(TorchRegistry.RED_TORCH.get());
			dropSelf(TorchRegistry.BLACK_TORCH.get());

			dropOther(TorchRegistry.WALL_WHITE_TORCH.get(), TorchRegistry.WHITE_TORCH.get());
			dropOther(TorchRegistry.WALL_ORANGE_TORCH.get(), TorchRegistry.ORANGE_TORCH.get());
			dropOther(TorchRegistry.WALL_MAGENTA_TORCH.get(), TorchRegistry.MAGENTA_TORCH.get());
			dropOther(TorchRegistry.WALL_LIGHT_BLUE_TORCH.get(), TorchRegistry.LIGHT_BLUE_TORCH.get());
			dropOther(TorchRegistry.WALL_YELLOW_TORCH.get(), TorchRegistry.YELLOW_TORCH.get());
			dropOther(TorchRegistry.WALL_LIME_TORCH.get(), TorchRegistry.LIME_TORCH.get());
			dropOther(TorchRegistry.WALL_PINK_TORCH.get(), TorchRegistry.PINK_TORCH.get());
			dropOther(TorchRegistry.WALL_GRAY_TORCH.get(), TorchRegistry.GRAY_TORCH.get());
			dropOther(TorchRegistry.WALL_LIGHT_GRAY_TORCH.get(), TorchRegistry.LIGHT_GRAY_TORCH.get());
			dropOther(TorchRegistry.WALL_CYAN_TORCH.get(), TorchRegistry.CYAN_TORCH.get());
			dropOther(TorchRegistry.WALL_PURPLE_TORCH.get(), TorchRegistry.PURPLE_TORCH.get());
			dropOther(TorchRegistry.WALL_BLUE_TORCH.get(), TorchRegistry.BLUE_TORCH.get());
			dropOther(TorchRegistry.WALL_BROWN_TORCH.get(), TorchRegistry.BROWN_TORCH.get());
			dropOther(TorchRegistry.WALL_GREEN_TORCH.get(), TorchRegistry.GREEN_TORCH.get());
			dropOther(TorchRegistry.WALL_RED_TORCH.get(), TorchRegistry.RED_TORCH.get());
			dropOther(TorchRegistry.WALL_BLACK_TORCH.get(), TorchRegistry.BLACK_TORCH.get());
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) TorchRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
		}
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext validationContext) {
		map.forEach((location, lootTable) -> lootTable.validate(validationContext));
	}
}
