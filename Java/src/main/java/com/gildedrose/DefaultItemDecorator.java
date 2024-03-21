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
            if (!itemIs("Sulfuras, Hand of Ragnaros")) {
                decrementItemQuality();
                if (isConjured()) {
                    decrementItemQuality();
                }
            }
        }
    }

    private void applyAging() {
        if (!itemIs( "Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void applyExtraAdaptationsToQualityForExpiredItem() {
        if (item.quality > 0) {
            if (!itemIs("Sulfuras, Hand of Ragnaros")) {
                decrementItemQuality();
                if (isConjured()) {
                    decrementItemQuality();
                }
            }
        }
    }

    private boolean isExpired() {
        return this.item.sellIn < 0;
    }

    private final Item item;

    private boolean itemIs(String name) {
        return item.name.equals(name);
    }

    private void decrementItemQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private boolean isConjured() {
        return item.name.startsWith("Conjured");
    }

}
