package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemWrapper itemWrapper = new ItemWrapper(item);
            itemWrapper.applyQualityAdaptations();

            itemWrapper.applyAging();

            if (itemWrapper.isExpired()) {
                itemWrapper.applyExtraAdaptationsToQualityForExpiredItem();
            }
        }
    }

}
