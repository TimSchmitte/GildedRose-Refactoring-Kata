package com.gildedrose;

public class DefaultItemDecorator implements ItemDecorator {

    protected DefaultItemDecorator(Item item) {
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
        if (item.quality > 0) {
            decrementItemQuality();
        }
    }

    private void applyAging() {
        item.sellIn = item.sellIn - 1;
    }

    private void applyExtraAdaptationsToQualityForExpiredItem() {
        if (item.quality > 0) {
            decrementItemQuality();
        }
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
