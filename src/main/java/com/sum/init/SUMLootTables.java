package com.sum.init;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class SUMLootTables {
	
	public static void init() {
		
		addLoot(SUMItems.BROWN_COAL, "chests/underwater_ruin_big", 1.0F, 2, 6);
		addLoot(SUMItems.BROWN_COAL, "chests/underwater_ruin_small", 1.0F, 2, 6);
		addLoot(SUMItems.BROWN_COAL, "chests/woodland_mansion", 0.2F, 2, 6);
		addLoot(SUMItems.BROWN_COAL, "chests/stronghold_crossing", 0.4F, 4, 10);
		addLoot(SUMItems.BROWN_COAL, "chests/shipwreck_supply", 0.4F, 4, 10);
		addLoot(SUMItems.BROWN_COAL, "chests/ancient_city", 0.5F, 8, 20);
		addLoot(SUMItems.BROWN_COAL, "chests/abandoned_mineshaft", 0.4F, 4, 10);
		addLoot(SUMItems.BROWN_COAL, "chests/igloo_chest", 1.0F, 2, 6);
		addLoot(SUMItems.BROWN_COAL, "chests/simple_dungeon", 0.4F, 2, 6);
		addLoot(SUMItems.BROWN_COAL, "chests/village/village_butcher", 0.3F, 2, 5);
		addLoot(SUMItems.BROWN_COAL, "chests/village/village_fisher", 0.5F, 2, 5);
		addLoot(SUMItems.BROWN_COAL, "chests/village/village_snowy_house", 0.5F, 2, 6);
		addLoot(SUMItems.BROWN_COAL, "chests/village/village_toolsmith", 0.15F, 2, 5);
		
	}
	
	private static void addLoot(Item item, String lootTable, float chance, float min, float max) {
		
		Identifier identifier = Identifier.of("minecraft", lootTable);
		
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
			
			if (identifier.equals(key.getValue())) {
				
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(chance))
						.with(ItemEntry.builder(item))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)));
				
				tableBuilder.pool(poolBuilder.build());
				
			}
			
		});
		
	}

}