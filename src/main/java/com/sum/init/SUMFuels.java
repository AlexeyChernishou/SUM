package com.sum.init;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;

public class SUMFuels {
	
	public static void init() {
		
		isFuel(SUMItems.BROWN_COAL, 1200);
		
	}
	
	private static void isFuel(Item item, int burnTime) {
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			
			builder.add(item, burnTime);
			
		});
		
	}

}