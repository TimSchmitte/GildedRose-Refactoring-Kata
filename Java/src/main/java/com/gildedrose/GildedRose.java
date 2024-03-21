package com.gildedrose;

class GildedRose {
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
