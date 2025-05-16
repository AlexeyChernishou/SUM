package com.sum.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SUMItemGroups {
	
	public static final RegistryKey<ItemGroup> SUM_MAIN_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("sum", "item_group"));
	
	public static final ItemGroup SUM_MAIN = FabricItemGroup.builder().icon(() -> new ItemStack(Items.STONE_PICKAXE)).displayName(Text.translatable("itemGroup.sum")).build();
	
	public static void init() {
		
		registerItemGroup(SUM_MAIN, SUM_MAIN_KEY);
		
		modifyItemGroup(SUMItems.BROWN_COAL, SUM_MAIN_KEY);
		
	}
	
	private static void registerItemGroup(ItemGroup itemGroup, RegistryKey<ItemGroup> registryKey) {
		
		Registry.register(Registries.ITEM_GROUP, registryKey, itemGroup);
		
	}
	
	private static void modifyItemGroup(Item item, RegistryKey<ItemGroup> registryKey) {
		
		ItemGroupEvents.modifyEntriesEvent(registryKey).register(itemGroup -> {
			
			itemGroup.add(item);
			
		});
		
	}

}