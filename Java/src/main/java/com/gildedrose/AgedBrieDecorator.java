package com.gildedrose;

public class AgedBrieDecorator implements ItemDecorator {

    public static final String AGED_BRIE = "Aged Brie";

    protected AgedBrieDecorator(Item item) {
        this.item = item;
    }


    @Override
    public void ageItem() {
        applyQualityAdaptations();
        applyAging();
        if (isExpired()) {
            applyExtraAdaptationsToQualityForExpiredItem();
        }
    }

    private void applyQualityAdaptations() {
        if (this.item.quality < GildedRose.MAX_QUALITY) {
            incrementItemQuality();

        }
    }

    private void applyAging() {
        item.sellIn = item.sellIn - 1;
    }

    private void applyExtraAdaptationsToQualityForExpiredItem() {
        if (item.quality < GildedRose.MAX_QUALITY) {
            incrementItemQuality();
        }
    }

    private boolean isExpired() {
        return this.item.sellIn < 0;
    }

    private final Item item;

    private void incrementItemQuality() {
        item.quality = item.quality + 1;
    }
}
