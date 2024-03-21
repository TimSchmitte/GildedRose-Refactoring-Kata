package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            applyQualityAdaptations(items[i]);

            applyAging(items[i]);

            if (isExpired(items[i])) {
                applyExtraAdaptationsToQualityForExpiredItem(items[i]);
            }
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void applyQualityAdaptations(Item item) {
        if (!itemIs(item, "Aged Brie")
                && !itemIs(item, "Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!itemIs(item, "Sulfuras, Hand of Ragnaros")) {
                    decrementItemQuality(item);
                    if(isConjured(item)){
                        decrementItemQuality(item);
                    }
                }
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                incrementItemQuality(item);

                if (itemIs(item, "Backstage passes to a TAFKAL80ETC concert")) {
                    additionalIncrementQualityForBackstagePass(item);
                }
            }
        }
    }

    private boolean isConjured(Item item) {
        return item.name.startsWith("Conjured");
    }

    private void applyAging(Item item) {
        if (!itemIs(item, "Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void applyExtraAdaptationsToQualityForExpiredItem(Item item) {
        if (!itemIs(item, "Aged Brie")) {
            if (itemIs(item, "Backstage passes to a TAFKAL80ETC concert")) {
                setBackStagePassValueTo0(item);
            } else {
                if (item.quality > 0) {
                    if (!itemIs(item, "Sulfuras, Hand of Ragnaros")) {
                        decrementItemQuality(item);
                        if(isConjured(item)){
                            decrementItemQuality(item);
                        }
                    }
                }
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                incrementItemQuality(item);
            }
        }
    }

    private void decrementItemQuality(Item item) {
        if(item.quality > 0){
            item.quality = item.quality - 1;
        }
    }

    private void setBackStagePassValueTo0(Item item) {
        item.quality = 0;
    }

    private void additionalIncrementQualityForBackstagePass(Item item) {
        if (item.sellIn < 11) {
            if (item.quality < MAX_QUALITY) {
                incrementItemQuality(item);
            }
        }

        if (item.sellIn < 6) {
            if (item.quality < MAX_QUALITY) {
                incrementItemQuality(item);
            }
        }
    }

    private void incrementItemQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private boolean itemIs(Item item, String name) {
        return item.name.equals(name);
    }
}
