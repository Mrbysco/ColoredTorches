package com.mrbysco.coloredtorches.data.data;

import com.mrbysco.coloredtorches.registry.TorchRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;


public class TorchRecipeProvider extends RecipeProvider {
	public TorchRecipeProvider(PackOutput packOutput) {
		super(packOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		//Torch recipes
		torchRecipe(consumer, TorchRegistry.WHITE_TORCH_ITEM, Tags.Items.DYES_WHITE);
		torchRecipe(consumer, TorchRegistry.ORANGE_TORCH_ITEM, Tags.Items.DYES_ORANGE);
		torchRecipe(consumer, TorchRegistry.MAGENTA_TORCH_ITEM, Tags.Items.DYES_MAGENTA);
		torchRecipe(consumer, TorchRegistry.LIGHT_BLUE_TORCH_ITEM, Tags.Items.DYES_LIGHT_BLUE);
		torchRecipe(consumer, TorchRegistry.YELLOW_TORCH_ITEM, Tags.Items.DYES_YELLOW);
		torchRecipe(consumer, TorchRegistry.LIME_TORCH_ITEM, Tags.Items.DYES_LIME);
		torchRecipe(consumer, TorchRegistry.PINK_TORCH_ITEM, Tags.Items.DYES_PINK);
		torchRecipe(consumer, TorchRegistry.GRAY_TORCH_ITEM, Tags.Items.DYES_GRAY);
		torchRecipe(consumer, TorchRegistry.LIGHT_GRAY_TORCH_ITEM, Tags.Items.DYES_LIGHT_GRAY);
		torchRecipe(consumer, TorchRegistry.CYAN_TORCH_ITEM, Tags.Items.DYES_CYAN);
		torchRecipe(consumer, TorchRegistry.PURPLE_TORCH_ITEM, Tags.Items.DYES_PURPLE);
		torchRecipe(consumer, TorchRegistry.BLUE_TORCH_ITEM, Tags.Items.DYES_BLUE);
		torchRecipe(consumer, TorchRegistry.BROWN_TORCH_ITEM, Tags.Items.DYES_BROWN);
		torchRecipe(consumer, TorchRegistry.GREEN_TORCH_ITEM, Tags.Items.DYES_GREEN);
		torchRecipe(consumer, TorchRegistry.RED_TORCH_ITEM, Tags.Items.DYES_RED);
		torchRecipe(consumer, TorchRegistry.BLACK_TORCH_ITEM, Tags.Items.DYES_BLACK);
	}

	private void torchRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<Item> torchObject, TagKey<Item> tag) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, torchObject.get(), 8)
				.pattern("TTT")
				.pattern("TDT")
				.pattern("TTT")
				.define('D', tag)
				.define('T', Items.TORCH)
				.unlockedBy("has_dye", has(tag))
				.unlockedBy("has_torch", has(Items.TORCH))
				.save(consumer, new ResourceLocation(torchObject.getId().getNamespace(), torchObject.getId().getPath() + "_from_dyeing"));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, torchObject.get(), 4)
				.pattern("C")
				.pattern("D")
				.pattern("S")
				.define('C', ItemTags.COALS)
				.define('D', tag)
				.define('S', Tags.Items.RODS_WOODEN)
				.unlockedBy("has_dye", has(tag))
				.unlockedBy("has_coal", has(ItemTags.COALS))
				.unlockedBy("has_rod", has(Tags.Items.RODS_WOODEN))
				.save(consumer);
	}
}