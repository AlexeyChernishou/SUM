package com.sum.init;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class SUMVillagerTrades {
	
	public static void init() {
		
		addTrade(VillagerProfession.BUTCHER, 2, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 16, 2, 0.05F);
		addTrade(VillagerProfession.ARMORER, 1, SUMItems.BROWN_COAL, 18, Items.EMERALD, 1, 16, 2, 0.05F);
		addTrade(VillagerProfession.FISHERMAN, 1, SUMItems.BROWN_COAL, 12, Items.EMERALD, 1, 16, 2, 0.05F);
		addTrade(VillagerProfession.TOOLSMITH, 1, SUMItems.BROWN_COAL, 16, Items.EMERALD, 1, 16, 2, 0.05F);
		addTrade(VillagerProfession.WEAPONSMITH, 1, SUMItems.BROWN_COAL, 16, Items.EMERALD, 1, 16, 2, 0.05F);
		
	}
	
	private static void addTrade(RegistryKey<VillagerProfession> profesion, int level, Item saleItem, int saleCount, Item purchaseItem, int purchaseCount, int maxUses, int villagerXP, float priceMultiplier) {
		
		TradeOfferHelper.registerVillagerOffers(profesion, level, factories -> {
			
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(saleItem, saleCount),
					new ItemStack(purchaseItem, purchaseCount), maxUses, villagerXP, priceMultiplier));
			
		});
		
	}

}