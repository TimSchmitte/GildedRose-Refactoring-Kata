package com.gildedrose.decorator;

import com.gildedrose.*;

public class ItemDecoratorFactory {

    public static final int DEFAULT_DEGRADATION_MODIFIER = 1;

    public static ItemDecorator create(Item item) {
        if (item.name.equals(AgedBrieDecorator.AGED_BRIE)) {
            return new AgedBrieDecorator(item);
        } else if (item.name.equals(TAFKAL80ETCBackstagePass.ITEM_NAME)) {
            return new TAFKAL80ETCBackstagePass(item);
        } else if (item.name.equals(SulfurasDecorator.ITEM_NAME)) {
            return new SulfurasDecorator();
        } else {
            int degradationModifier = DEFAULT_DEGRADATION_MODIFIER;
            if (isConjured(item)) {
                degradationModifier*=2;
            }
            return new DegradingItemDecorator(item, degradationModifier);
        }
    }

    private static boolean isConjured(Item item) {
        return item.name.startsWith(ConjuredItemDecorator.ITEM_PREFIX);
    }
}
