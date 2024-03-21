package com.gildedrose.decorator;

import com.gildedrose.Item;

class AgedBrieDecorator implements ItemDecorator {

    public static final String AGED_BRIE = "Aged Brie";
    public static final int MAX_QUALITY = 50;

    protected AgedBrieDecorator(Item item) {
        this.item = item;
    }


    @Override
    public void ageItem() {
        incrementItemQuality();
        applyAging();
        if (isExpired()) {
            incrementItemQuality();
        }
    }

    private void applyAging() {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isExpired() {
        return this.item.sellIn < 0;
    }

    private final Item item;

    private void incrementItemQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
