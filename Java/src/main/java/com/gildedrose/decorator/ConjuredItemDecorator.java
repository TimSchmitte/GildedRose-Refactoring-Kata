package com.gildedrose.decorator;

import com.gildedrose.Item;

class ConjuredItemDecorator implements ItemDecorator {
    public static final String ITEM_PREFIX = "Conjured";

    protected ConjuredItemDecorator(Item item) {
        this.item = item;
    }

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

    private final Item item;

    private void decrementItemQuality() {
        if (item.quality > 1) {
            item.quality = item.quality - 2;
        }else{
            item.quality =0;
        }
    }

}
