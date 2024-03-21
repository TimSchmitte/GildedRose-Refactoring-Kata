package com.gildedrose;

import com.gildedrose.decorator.ItemDecorator;
import com.gildedrose.decorator.ItemDecoratorFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemDecorator itemDecorator = ItemDecoratorFactory.create(item);
            itemDecorator.ageItem();
        }
    }

}
