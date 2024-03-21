package com.gildedrose;

public class TAFKAL80ETCBackstagePass implements ItemDecorator {

    public static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    protected TAFKAL80ETCBackstagePass(Item item) {
        this.item = item;
    }

    public void ageItem() {
        applyQualityAdaptations();

        applyAging();

        if (isExpired()) {
            applyExtraAdaptationsToQualityForExpiredItem();
        }
    }

    private void applyQualityAdaptations() {
        if (item.quality < GildedRose.MAX_QUALITY) {
            incrementItemQuality();

            additionalIncrementQualityForBackstagePass();
        }
    }

    private void applyAging() {
        item.sellIn = item.sellIn - 1;
    }

    private void applyExtraAdaptationsToQualityForExpiredItem() {
        item.quality = 0;
    }

    private boolean isExpired() {
        return this.item.sellIn < 0;
    }

    private final Item item;

    private void incrementItemQuality() {
        item.quality = item.quality + 1;
    }

    private void additionalIncrementQualityForBackstagePass() {
        if (item.sellIn < 11) {
            if (item.quality < GildedRose.MAX_QUALITY) {
                incrementItemQuality();
            }
        }

        if (item.sellIn < 6) {
            if (item.quality < GildedRose.MAX_QUALITY) {
                incrementItemQuality();
            }
        }
    }
}
