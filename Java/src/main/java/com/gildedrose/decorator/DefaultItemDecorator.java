package com.gildedrose.decorator;

import com.gildedrose.Item;

class DefaultItemDecorator implements ItemDecorator {

    protected DefaultItemDecorator(Item item) {
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

    public void decrementItemQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

}
