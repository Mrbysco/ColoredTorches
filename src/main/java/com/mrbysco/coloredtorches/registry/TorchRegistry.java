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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class TorchRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ColoredTorchesMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ColoredTorchesMod.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ColoredTorchesMod.MOD_ID);

	public static final RegistryObject<Block> WHITE_TORCH = registerTorch(DyeColor.WHITE);
	public static final RegistryObject<Block> ORANGE_TORCH = registerTorch(DyeColor.ORANGE);
	public static final RegistryObject<Block> MAGENTA_TORCH = registerTorch(DyeColor.MAGENTA);
	public static final RegistryObject<Block> LIGHT_BLUE_TORCH = registerTorch(DyeColor.LIGHT_BLUE);
	public static final RegistryObject<Block> YELLOW_TORCH = registerTorch(DyeColor.YELLOW);
	public static final RegistryObject<Block> LIME_TORCH = registerTorch(DyeColor.LIME);
	public static final RegistryObject<Block> PINK_TORCH = registerTorch(DyeColor.PINK);
	public static final RegistryObject<Block> GRAY_TORCH = registerTorch(DyeColor.GRAY);
	public static final RegistryObject<Block> LIGHT_GRAY_TORCH = registerTorch(DyeColor.LIGHT_GRAY);
	public static final RegistryObject<Block> CYAN_TORCH = registerTorch(DyeColor.CYAN);
	public static final RegistryObject<Block> PURPLE_TORCH = registerTorch(DyeColor.PURPLE);
	public static final RegistryObject<Block> BLUE_TORCH = registerTorch(DyeColor.BLUE);
	public static final RegistryObject<Block> BROWN_TORCH = registerTorch(DyeColor.BROWN);
	public static final RegistryObject<Block> GREEN_TORCH = registerTorch(DyeColor.GREEN);
	public static final RegistryObject<Block> RED_TORCH = registerTorch(DyeColor.RED);
	public static final RegistryObject<Block> BLACK_TORCH = registerTorch(DyeColor.BLACK);

	public static final RegistryObject<Block> WALL_WHITE_TORCH = registerWallTorch(DyeColor.WHITE, WHITE_TORCH);
	public static final RegistryObject<Block> WALL_ORANGE_TORCH = registerWallTorch(DyeColor.ORANGE, ORANGE_TORCH);
	public static final RegistryObject<Block> WALL_MAGENTA_TORCH = registerWallTorch(DyeColor.MAGENTA, MAGENTA_TORCH);
	public static final RegistryObject<Block> WALL_LIGHT_BLUE_TORCH = registerWallTorch(DyeColor.LIGHT_BLUE, LIGHT_BLUE_TORCH);
	public static final RegistryObject<Block> WALL_YELLOW_TORCH = registerWallTorch(DyeColor.YELLOW, YELLOW_TORCH);
	public static final RegistryObject<Block> WALL_LIME_TORCH = registerWallTorch(DyeColor.LIME, LIME_TORCH);
	public static final RegistryObject<Block> WALL_PINK_TORCH = registerWallTorch(DyeColor.PINK, PINK_TORCH);
	public static final RegistryObject<Block> WALL_GRAY_TORCH = registerWallTorch(DyeColor.GRAY, GRAY_TORCH);
	public static final RegistryObject<Block> WALL_LIGHT_GRAY_TORCH = registerWallTorch(DyeColor.LIGHT_GRAY, LIGHT_GRAY_TORCH);
	public static final RegistryObject<Block> WALL_CYAN_TORCH = registerWallTorch(DyeColor.CYAN, CYAN_TORCH);
	public static final RegistryObject<Block> WALL_PURPLE_TORCH = registerWallTorch(DyeColor.PURPLE, PURPLE_TORCH);
	public static final RegistryObject<Block> WALL_BLUE_TORCH = registerWallTorch(DyeColor.BLUE, BLUE_TORCH);
	public static final RegistryObject<Block> WALL_BROWN_TORCH = registerWallTorch(DyeColor.BROWN, BROWN_TORCH);
	public static final RegistryObject<Block> WALL_GREEN_TORCH = registerWallTorch(DyeColor.GREEN, GREEN_TORCH);
	public static final RegistryObject<Block> WALL_RED_TORCH = registerWallTorch(DyeColor.RED, RED_TORCH);
	public static final RegistryObject<Block> WALL_BLACK_TORCH = registerWallTorch(DyeColor.BLACK, BLACK_TORCH);

	public static final RegistryObject<Item> WHITE_TORCH_ITEM = registerTorchItem(WHITE_TORCH, WALL_WHITE_TORCH);
	public static final RegistryObject<Item> ORANGE_TORCH_ITEM = registerTorchItem(ORANGE_TORCH, WALL_ORANGE_TORCH);
	public static final RegistryObject<Item> MAGENTA_TORCH_ITEM = registerTorchItem(MAGENTA_TORCH, WALL_MAGENTA_TORCH);
	public static final RegistryObject<Item> LIGHT_BLUE_TORCH_ITEM = registerTorchItem(LIGHT_BLUE_TORCH, WALL_LIGHT_BLUE_TORCH);
	public static final RegistryObject<Item> YELLOW_TORCH_ITEM = registerTorchItem(YELLOW_TORCH, WALL_YELLOW_TORCH);
	public static final RegistryObject<Item> LIME_TORCH_ITEM = registerTorchItem(LIME_TORCH, WALL_LIME_TORCH);
	public static final RegistryObject<Item> PINK_TORCH_ITEM = registerTorchItem(PINK_TORCH, WALL_PINK_TORCH);
	public static final RegistryObject<Item> GRAY_TORCH_ITEM = registerTorchItem(GRAY_TORCH, WALL_GRAY_TORCH);
	public static final RegistryObject<Item> LIGHT_GRAY_TORCH_ITEM = registerTorchItem(LIGHT_GRAY_TORCH, WALL_LIGHT_GRAY_TORCH);
	public static final RegistryObject<Item> CYAN_TORCH_ITEM = registerTorchItem(CYAN_TORCH, WALL_CYAN_TORCH);
	public static final RegistryObject<Item> PURPLE_TORCH_ITEM = registerTorchItem(PURPLE_TORCH, WALL_PURPLE_TORCH);
	public static final RegistryObject<Item> BLUE_TORCH_ITEM = registerTorchItem(BLUE_TORCH, WALL_BLUE_TORCH);
	public static final RegistryObject<Item> BROWN_TORCH_ITEM = registerTorchItem(BROWN_TORCH, WALL_BROWN_TORCH);
	public static final RegistryObject<Item> GREEN_TORCH_ITEM = registerTorchItem(GREEN_TORCH, WALL_GREEN_TORCH);
	public static final RegistryObject<Item> RED_TORCH_ITEM = registerTorchItem(RED_TORCH, WALL_RED_TORCH);
	public static final RegistryObject<Item> BLACK_TORCH_ITEM = registerTorchItem(BLACK_TORCH, WALL_BLACK_TORCH);

	public static RegistryObject<Block> registerTorch(DyeColor color) {
		String name = color.getName() + "_torch";
		return BLOCKS.register(name, () -> new ColoredTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_50755_) -> {
			return 14;
		}).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), color));
	}

	public static RegistryObject<Block> registerWallTorch(DyeColor color, RegistryObject<Block> torchObject) {
		String name = color.getName() + "_torch";
		return BLOCKS.register("wall_" + name, () -> new ColoredWallTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_50886_) -> {
			return 14;
		}).sound(SoundType.WOOD).dropsLike(torchObject.get()).pushReaction(PushReaction.DESTROY), color));
	}

	public static RegistryObject<Item> registerTorchItem(RegistryObject<Block> torchObject, RegistryObject<Block> wallTorchObject) {
		return ITEMS.register(torchObject.getId().getPath(), () -> new StandingAndWallBlockItem(torchObject.get(), wallTorchObject.get(), new Item.Properties(), Direction.DOWN));
	}

	public static final RegistryObject<CreativeModeTab> TORCH_TAB = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(TorchRegistry.RED_TORCH.get()))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
			.title(Component.translatable("itemGroup.colored_torches"))
			.displayItems((features, output) -> {
				List<ItemStack> stacks = TorchRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
				output.acceptAll(stacks);
			}).build());
}
