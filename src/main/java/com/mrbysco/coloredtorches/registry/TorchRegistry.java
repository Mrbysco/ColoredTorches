package com.mrbysco.coloredtorches.registry;

import com.mrbysco.coloredtorches.ColoredTorchesMod;
import com.mrbysco.coloredtorches.block.ColoredTorchBlock;
import com.mrbysco.coloredtorches.block.ColoredWallTorchBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class TorchRegistry {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ColoredTorchesMod.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ColoredTorchesMod.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ColoredTorchesMod.MOD_ID);

	public static final DeferredBlock<ColoredTorchBlock> WHITE_TORCH = registerTorch(DyeColor.WHITE);
	public static final DeferredBlock<ColoredTorchBlock> ORANGE_TORCH = registerTorch(DyeColor.ORANGE);
	public static final DeferredBlock<ColoredTorchBlock> MAGENTA_TORCH = registerTorch(DyeColor.MAGENTA);
	public static final DeferredBlock<ColoredTorchBlock> LIGHT_BLUE_TORCH = registerTorch(DyeColor.LIGHT_BLUE);
	public static final DeferredBlock<ColoredTorchBlock> YELLOW_TORCH = registerTorch(DyeColor.YELLOW);
	public static final DeferredBlock<ColoredTorchBlock> LIME_TORCH = registerTorch(DyeColor.LIME);
	public static final DeferredBlock<ColoredTorchBlock> PINK_TORCH = registerTorch(DyeColor.PINK);
	public static final DeferredBlock<ColoredTorchBlock> GRAY_TORCH = registerTorch(DyeColor.GRAY);
	public static final DeferredBlock<ColoredTorchBlock> LIGHT_GRAY_TORCH = registerTorch(DyeColor.LIGHT_GRAY);
	public static final DeferredBlock<ColoredTorchBlock> CYAN_TORCH = registerTorch(DyeColor.CYAN);
	public static final DeferredBlock<ColoredTorchBlock> PURPLE_TORCH = registerTorch(DyeColor.PURPLE);
	public static final DeferredBlock<ColoredTorchBlock> BLUE_TORCH = registerTorch(DyeColor.BLUE);
	public static final DeferredBlock<ColoredTorchBlock> BROWN_TORCH = registerTorch(DyeColor.BROWN);
	public static final DeferredBlock<ColoredTorchBlock> GREEN_TORCH = registerTorch(DyeColor.GREEN);
	public static final DeferredBlock<ColoredTorchBlock> RED_TORCH = registerTorch(DyeColor.RED);
	public static final DeferredBlock<ColoredTorchBlock> BLACK_TORCH = registerTorch(DyeColor.BLACK);

	public static final DeferredBlock<ColoredWallTorchBlock> WALL_WHITE_TORCH = registerWallTorch(DyeColor.WHITE, WHITE_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_ORANGE_TORCH = registerWallTorch(DyeColor.ORANGE, ORANGE_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_MAGENTA_TORCH = registerWallTorch(DyeColor.MAGENTA, MAGENTA_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_LIGHT_BLUE_TORCH = registerWallTorch(DyeColor.LIGHT_BLUE, LIGHT_BLUE_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_YELLOW_TORCH = registerWallTorch(DyeColor.YELLOW, YELLOW_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_LIME_TORCH = registerWallTorch(DyeColor.LIME, LIME_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_PINK_TORCH = registerWallTorch(DyeColor.PINK, PINK_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_GRAY_TORCH = registerWallTorch(DyeColor.GRAY, GRAY_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_LIGHT_GRAY_TORCH = registerWallTorch(DyeColor.LIGHT_GRAY, LIGHT_GRAY_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_CYAN_TORCH = registerWallTorch(DyeColor.CYAN, CYAN_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_PURPLE_TORCH = registerWallTorch(DyeColor.PURPLE, PURPLE_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_BLUE_TORCH = registerWallTorch(DyeColor.BLUE, BLUE_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_BROWN_TORCH = registerWallTorch(DyeColor.BROWN, BROWN_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_GREEN_TORCH = registerWallTorch(DyeColor.GREEN, GREEN_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_RED_TORCH = registerWallTorch(DyeColor.RED, RED_TORCH);
	public static final DeferredBlock<ColoredWallTorchBlock> WALL_BLACK_TORCH = registerWallTorch(DyeColor.BLACK, BLACK_TORCH);

	public static final DeferredItem<Item> WHITE_TORCH_ITEM = registerTorchItem(WHITE_TORCH, WALL_WHITE_TORCH);
	public static final DeferredItem<Item> ORANGE_TORCH_ITEM = registerTorchItem(ORANGE_TORCH, WALL_ORANGE_TORCH);
	public static final DeferredItem<Item> MAGENTA_TORCH_ITEM = registerTorchItem(MAGENTA_TORCH, WALL_MAGENTA_TORCH);
	public static final DeferredItem<Item> LIGHT_BLUE_TORCH_ITEM = registerTorchItem(LIGHT_BLUE_TORCH, WALL_LIGHT_BLUE_TORCH);
	public static final DeferredItem<Item> YELLOW_TORCH_ITEM = registerTorchItem(YELLOW_TORCH, WALL_YELLOW_TORCH);
	public static final DeferredItem<Item> LIME_TORCH_ITEM = registerTorchItem(LIME_TORCH, WALL_LIME_TORCH);
	public static final DeferredItem<Item> PINK_TORCH_ITEM = registerTorchItem(PINK_TORCH, WALL_PINK_TORCH);
	public static final DeferredItem<Item> GRAY_TORCH_ITEM = registerTorchItem(GRAY_TORCH, WALL_GRAY_TORCH);
	public static final DeferredItem<Item> LIGHT_GRAY_TORCH_ITEM = registerTorchItem(LIGHT_GRAY_TORCH, WALL_LIGHT_GRAY_TORCH);
	public static final DeferredItem<Item> CYAN_TORCH_ITEM = registerTorchItem(CYAN_TORCH, WALL_CYAN_TORCH);
	public static final DeferredItem<Item> PURPLE_TORCH_ITEM = registerTorchItem(PURPLE_TORCH, WALL_PURPLE_TORCH);
	public static final DeferredItem<Item> BLUE_TORCH_ITEM = registerTorchItem(BLUE_TORCH, WALL_BLUE_TORCH);
	public static final DeferredItem<Item> BROWN_TORCH_ITEM = registerTorchItem(BROWN_TORCH, WALL_BROWN_TORCH);
	public static final DeferredItem<Item> GREEN_TORCH_ITEM = registerTorchItem(GREEN_TORCH, WALL_GREEN_TORCH);
	public static final DeferredItem<Item> RED_TORCH_ITEM = registerTorchItem(RED_TORCH, WALL_RED_TORCH);
	public static final DeferredItem<Item> BLACK_TORCH_ITEM = registerTorchItem(BLACK_TORCH, WALL_BLACK_TORCH);

	public static DeferredBlock<ColoredTorchBlock> registerTorch(DyeColor color) {
		String name = color.getName() + "_torch";
		return BLOCKS.registerBlock(name, (properties) -> new ColoredTorchBlock(properties, color),
				BlockBehaviour.Properties.of().noCollission().instabreak()
						.lightLevel((state) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)
		);
	}

	public static DeferredBlock<ColoredWallTorchBlock> registerWallTorch(DyeColor color, DeferredBlock<ColoredTorchBlock> torchObject) {
		String name = color.getName() + "_torch";
		return BLOCKS.registerBlock("wall_" + name, (properties) -> new ColoredWallTorchBlock(properties, color),
				BlockBehaviour.Properties.of().noCollission().instabreak()
						.lightLevel((state) -> 14).sound(SoundType.WOOD)
						.pushReaction(PushReaction.DESTROY));
	}

	public static DeferredItem<Item> registerTorchItem(DeferredBlock<ColoredTorchBlock> torchObject, DeferredBlock<ColoredWallTorchBlock> wallTorchObject) {
		return ITEMS.registerItem(torchObject.getId().getPath(), (properties) ->
				new StandingAndWallBlockItem(torchObject.get(), wallTorchObject.get(), Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix());
	}

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TORCH_TAB = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(TorchRegistry.RED_TORCH.get()))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
			.title(Component.translatable("itemGroup.colored_torches"))
			.displayItems((features, output) -> {
				List<ItemStack> stacks = TorchRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
				output.acceptAll(stacks);
			}).build());
}
