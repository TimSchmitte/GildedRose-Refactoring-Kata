package com.gildedrose.decorator;

import com.gildedrose.Item;

public class DegradingItemDecorator implements ItemDecorator {
    protected final Item item;
    private final int degradationModifier;

    public DegradingItemDecorator(Item item, int degradationModifier) {
        this.item = item;
        this.degradationModifier = degradationModifier;
    }

    @Override
    public void ageItem() {
        decrementItemQuality();
        applyAging();
        if (isExpired()) {
            decrementItemQuality();
        }
    }

    private void applyAging() {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isExpired() {
        return this.item.sellIn < 0;
    }

    public void decrementItemQuality() {
        if (item.quality > degradationModifier) {
            item.quality = item.quality - degradationModifier;
        }else{
            item.quality = 0;
        }
    }
}
