package com.gildedrose;

public interface ItemDecorator {

    static ItemDecorator createItemWrapper(Item item) {
        if(item.name.equals(AgedBrieDecorator.AGED_BRIE)){
            return new AgedBrieDecorator(item);
        } else if (item.name.equals(TAFKAL80ETCBackstagePass.ITEM_NAME)) {
            return new TAFKAL80ETCBackstagePass(item);
        } else if(item.name.equals(SulfurasDecorator.ITEM_NAME)){
            return new SulfurasDecorator(item);
        } else{
            return new DefaultItemDecorator(item);
        }
    }

    void ageItem();
}
