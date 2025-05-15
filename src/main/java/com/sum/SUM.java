package com.sum;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SUM implements ModInitializer {
	
	public static final RegistryKey<ItemGroup> SUM_MAIN_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("sum", "item_group"));
	
	public static final ItemGroup SUM_MAIN = FabricItemGroup.builder().icon(() -> new ItemStack(Items.STONE_PICKAXE)).displayName(Text.translatable("itemGroup.sum")).build();
	
	@Override
	public void onInitialize() {
		
		Registry.register(Registries.ITEM_GROUP, SUM_MAIN_KEY, SUM_MAIN);
		
		ItemGroupEvents.modifyEntriesEvent(SUM_MAIN_KEY).register(itemGroup -> {
			
		});
		
	}
	
}