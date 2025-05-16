package com.sum;

import com.sum.init.SUMFuels;
import com.sum.init.SUMItemGroups;
import com.sum.init.SUMItems;
import com.sum.init.SUMLootTables;
import com.sum.init.SUMVillagerTrades;

import net.fabricmc.api.ModInitializer;

public class SUM implements ModInitializer {
	
	@Override
	public void onInitialize() {
		
		SUMItems.init();
		SUMFuels.init();
		SUMLootTables.init();
		SUMVillagerTrades.init();
		SUMItemGroups.init();
		
	}
	
}