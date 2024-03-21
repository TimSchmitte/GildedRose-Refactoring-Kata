package com.gildedrose;

public class ItemWrapper {
    public ItemWrapper(Item item) {
        this.item = item;
    }

    public void applyQualityAdaptations() {
        Item item = getItem();
        if (!itemIs("Aged Brie")
            && !itemIs( "Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!itemIs( "Sulfuras, Hand of Ragnaros")) {
                    decrementItemQuality();
                    if (isConjured()) {
                        decrementItemQuality();
                    }
                }
            }
        } else {
            if (item.quality < GildedRose.MAX_QUALITY) {
                incrementItemQuality();

                if (itemIs( "Backstage passes to a TAFKAL80ETC concert")) {
                    additionalIncrementQualityForBackstagePass();
                }
            }
        }
    }

    public void applyAging() {
        if (!itemIs( "Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    public void applyExtraAdaptationsToQualityForExpiredItem() {
        if (!itemIs( "Aged Brie")) {
            if (itemIs( "Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else {
                if (item.quality > 0) {
                    if (!itemIs( "Sulfuras, Hand of Ragnaros")) {
                        decrementItemQuality();
                        if (isConjured()) {
                            decrementItemQuality();
                        }
                    }
                }
            }
        } else {
            if (item.quality < GildedRose.MAX_QUALITY) {
                incrementItemQuality();
            }
        }
    }

    public boolean isExpired() {
        return this.item.sellIn < 0;
    }

    public Item getItem() {
        return item;
    }

    private final Item item;

    private boolean itemIs(String name) {
        return item.name.equals(name);
    }

    private void incrementItemQuality() {
        item.quality = item.quality + 1;
    }

    private void decrementItemQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private boolean isConjured() {
        return item.name.startsWith("Conjured");
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
