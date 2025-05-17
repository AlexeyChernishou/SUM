package com.sum;

import com.sum.init.SUMBlocks;
import com.sum.init.SUMItemGroups;
import com.sum.init.SUMItems;
import com.sum.init.SUMLootTables;
import com.sum.init.SUMVillagerTrades;

import net.fabricmc.api.ModInitializer;

public class SUM implements ModInitializer {
	
	public static final String MOD_ID = "sum";
	
	@Override
	public void onInitialize() {
		
		SUMBlocks.init();
		SUMItems.init();
		SUMLootTables.init();
		SUMVillagerTrades.init();
		SUMItemGroups.init();
		
	}
	
}