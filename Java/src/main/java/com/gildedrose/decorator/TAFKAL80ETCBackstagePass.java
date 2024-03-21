package com.gildedrose.decorator;

import com.gildedrose.Item;

class TAFKAL80ETCBackstagePass implements ItemDecorator {

    public static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MAX_QUALITY = 50;

    protected TAFKAL80ETCBackstagePass(Item item) {
        this.item = item;
    }

    public void ageItem() {
        applyAging();
        if (isExpired()) {
            item.quality = 0;
        } else {
            incrementItemQuality();
            if (item.sellIn < 10) {
                incrementItemQuality();
            }
            if (item.sellIn < 5) {
                incrementItemQuality();
            }
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
