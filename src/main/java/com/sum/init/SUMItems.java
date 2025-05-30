package com.sum.init;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class SUMItems {
	
	public static final RegistryKey<Item> BROWN_COAL_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("sum", "brown_coal"));
	
	public static final Item BROWN_COAL = new Item(new Item.Settings().registryKey(BROWN_COAL_KEY));
	
	public static void init() {
		
		registerItem(BROWN_COAL, BROWN_COAL_KEY);
		
		isFuel(BROWN_COAL, 1200);
		isFuel(SUMBlocks.BROWN_COAL_BLOCK.asItem(), 12000);
		
	}
	
	private static void registerItem(Item item, RegistryKey<Item> registryKey) {
		
		Registry.register(Registries.ITEM, registryKey, item);
		
	}
	
	private static void isFuel(Item item, int burnTime) {
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(item, burnTime);
			
		});
		
	}

}