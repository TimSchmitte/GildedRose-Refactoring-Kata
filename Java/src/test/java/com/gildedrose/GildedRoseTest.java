package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GildedRoseTest {
    @Test
    void defaultItemShouldDegradeBy1PerDay() {

        Item item = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{
            item
        });

        gildedRose.updateQuality();
        sellInAndQualityShouldBe(item, 9, 19);
    }

    @Test
    void defaultItemQualityShouldDegradeTwiceAsFastWhenSellDateHasPassed() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{
            item
        });

        updateQuality(gildedRose, 11);
        sellInAndQualityShouldBe(item, -1, 8);
    }

    @Test
    void defaultItemQualityShouldNeverGoBelowZero() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{
            item
        });

        updateQuality(gildedRose, 50);
        sellInAndQualityShouldBe(item, -40, 0);
    }


    @Test
    void goodWineQualityShouldIncreaseWhenItGetsOlder() {
        Item item = new Item("Aged Brie", 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{
            item
        });

        updateQuality(gildedRose, 5);
        sellInAndQualityShouldBe(item, 5, 25);
    }

    /**
     * Not explicitly mentioned in the requirements => good wine increases in quality twice as fast after sell date
     */
    @Test
    void goodWineQualityShouldIncreaseTwiceAsFastAfterSellDate() {
        Item item = new Item("Aged Brie", -1, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{
            item
        });

        updateQuality(gildedRose, 5);
        sellInAndQualityShouldBe(item, -6, 30);
    }



    @Test
    void qualityOfAnyItemShouldNeverIncreaseAbove50() {
        Item item = new Item("Aged Brie", 10, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{
            item
        });

        updateQuality(gildedRose, 1);
        sellInAndQualityShouldBe(item, 9, 50);
    }

    @Test
    void bDAWGKeyChainShouldNeverDegradeAndNeverHasToBeSold() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{
            item
        });

        updateQuality(gildedRose, 10);
        sellInAndQualityShouldBe(item, 1, 80);
    }

    @Test
    void backStagePassesIncreaseInQualityAsSellInValueApproaches() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        updateQuality(gildedRose, 10);
        sellInAndQualityShouldBe(item, 10, 20);

        updateQuality(gildedRose, 5);
        sellInAndQualityShouldBe(item, 5, 30);

        updateQuality(gildedRose, 5);
        sellInAndQualityShouldBe(item, 0, 45);

        updateQuality(gildedRose, 1);
        sellInAndQualityShouldBe(item, -1, 0);
    }

    private static void sellInAndQualityShouldBe(Item item, int sellIn, int quality) {
        assertThat(item.sellIn).isEqualTo(sellIn);
        assertThat(item.quality).isEqualTo(quality);
    }


    private static void updateQuality(GildedRose gildedRose, int amount) {
        for (int i = 0; i < amount; i++) {
            gildedRose.updateQuality();
        }
    }

}
