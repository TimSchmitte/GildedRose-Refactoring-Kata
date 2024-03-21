package com.gildedrose.decorator;

import com.gildedrose.*;

public class ItemDecoratorFactory {
    public static ItemDecorator create(Item item) {
        if (item.name.equals(AgedBrieDecorator.AGED_BRIE)) {
            return new AgedBrieDecorator(item);
        } else if (item.name.equals(TAFKAL80ETCBackstagePass.ITEM_NAME)) {
            return new TAFKAL80ETCBackstagePass(item);
        } else if (item.name.equals(SulfurasDecorator.ITEM_NAME)) {
            return new SulfurasDecorator();
        } else if (item.name.startsWith(ConjuredItemDecorator.ITEM_PREFIX)) {
            return new DegradingItemDecorator(item, 2);
        } else {
            return new DegradingItemDecorator(item, 1);
        }
    }
}
