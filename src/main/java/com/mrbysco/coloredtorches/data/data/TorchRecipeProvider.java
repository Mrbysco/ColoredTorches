package com.mrbysco.coloredtorches.data.data;

import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.concurrent.CompletableFuture;


public class TorchRecipeProvider extends RecipeProvider {
	public TorchRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
		super(provider, recipeOutput);
	}

	@Override
	protected void buildRecipes() {
		//Torch recipes
		torchRecipe(output, TorchRegistry.WHITE_TORCH_ITEM, Tags.Items.DYES_WHITE);
		torchRecipe(output, TorchRegistry.ORANGE_TORCH_ITEM, Tags.Items.DYES_ORANGE);
		torchRecipe(output, TorchRegistry.MAGENTA_TORCH_ITEM, Tags.Items.DYES_MAGENTA);
		torchRecipe(output, TorchRegistry.LIGHT_BLUE_TORCH_ITEM, Tags.Items.DYES_LIGHT_BLUE);
		torchRecipe(output, TorchRegistry.YELLOW_TORCH_ITEM, Tags.Items.DYES_YELLOW);
		torchRecipe(output, TorchRegistry.LIME_TORCH_ITEM, Tags.Items.DYES_LIME);
		torchRecipe(output, TorchRegistry.PINK_TORCH_ITEM, Tags.Items.DYES_PINK);
		torchRecipe(output, TorchRegistry.GRAY_TORCH_ITEM, Tags.Items.DYES_GRAY);
		torchRecipe(output, TorchRegistry.LIGHT_GRAY_TORCH_ITEM, Tags.Items.DYES_LIGHT_GRAY);
		torchRecipe(output, TorchRegistry.CYAN_TORCH_ITEM, Tags.Items.DYES_CYAN);
		torchRecipe(output, TorchRegistry.PURPLE_TORCH_ITEM, Tags.Items.DYES_PURPLE);
		torchRecipe(output, TorchRegistry.BLUE_TORCH_ITEM, Tags.Items.DYES_BLUE);
		torchRecipe(output, TorchRegistry.BROWN_TORCH_ITEM, Tags.Items.DYES_BROWN);
		torchRecipe(output, TorchRegistry.GREEN_TORCH_ITEM, Tags.Items.DYES_GREEN);
		torchRecipe(output, TorchRegistry.RED_TORCH_ITEM, Tags.Items.DYES_RED);
		torchRecipe(output, TorchRegistry.BLACK_TORCH_ITEM, Tags.Items.DYES_BLACK);
	}

	private void torchRecipe(RecipeOutput output, DeferredItem<? extends Item> torchObject, TagKey<Item> tag) {
		shaped(RecipeCategory.MISC, torchObject.get(), 8)
				.pattern("TTT")
				.pattern("TDT")
				.pattern("TTT")
				.define('D', tag)
				.define('T', Items.TORCH)
				.unlockedBy("has_dye", has(tag))
				.unlockedBy("has_torch", has(Items.TORCH))
				.save(output, ResourceLocation.fromNamespaceAndPath(torchObject.getId().getNamespace(), torchObject.getId().getPath() + "_from_dyeing").toString());

		shaped(RecipeCategory.MISC, torchObject.get(), 4)
				.pattern("C")
				.pattern("D")
				.pattern("S")
				.define('C', ItemTags.COALS)
				.define('D', tag)
				.define('S', Tags.Items.RODS_WOODEN)
				.unlockedBy("has_dye", has(tag))
				.unlockedBy("has_coal", has(ItemTags.COALS))
				.unlockedBy("has_rod", has(Tags.Items.RODS_WOODEN))
				.save(output);
	}

	public static class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<Provider> completableFuture) {
			super(output, completableFuture);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
			return new TorchRecipeProvider(provider, recipeOutput);
		}

		@Override
		public String getName() {
			return "Colored Torches Recipes";
		}
	}
}