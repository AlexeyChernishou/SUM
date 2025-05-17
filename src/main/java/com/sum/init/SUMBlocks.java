package com.sum.init;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class SUMBlocks {
	
	public static final RegistryKey<Block> BROWN_COAL_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("sum", "brown_coal_block"));
	
	public static final RegistryKey<Item> BROWN_COAL_BLOCK_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("sum", "brown_coal_block"));
		
	public static final Block BROWN_COAL_BLOCK = new Block(AbstractBlock.Settings.create().lootTable(null).registryKey(BROWN_COAL_BLOCK_KEY).sounds(BlockSoundGroup.STONE).strength(5, 6).requiresTool());
	
	public static void init() {
		
		registerBlock(BROWN_COAL_BLOCK, BROWN_COAL_BLOCK_KEY, BROWN_COAL_BLOCK_ITEM_KEY);
		
		isFlammable(BROWN_COAL_BLOCK, 8, 8);
		
	}
	
	private static void registerBlock(Block block, RegistryKey<Block> registryBlockKey, RegistryKey<Item> registryItemKey) {
		
		Registry.register(Registries.BLOCK, registryBlockKey, block);
		Registry.register(Registries.ITEM, registryItemKey, new BlockItem(block, new Item.Settings().registryKey(registryItemKey)));
		
	}
	
	private static void isFlammable(Block block, int burn, int spread) {
		
		FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
		
	}

}