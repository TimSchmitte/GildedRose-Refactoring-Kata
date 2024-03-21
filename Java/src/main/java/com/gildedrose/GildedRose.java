package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemDecorator itemDecorator = ItemDecorator.createItemWrapper(item);
            itemDecorator.ageItem();
        }
    }

}
