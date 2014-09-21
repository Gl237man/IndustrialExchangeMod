package com.gl237.Iexchange;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by gl237 on 21.09.2014.
 */
public class MatterValueCalculator {
    public MatterValueCalculator()
    {

    }

    public static int GetMatterValue(ItemStack itemStack)
    {
        //Получение не ванильных предметов (Item)Item.itemRegistry.getObject("wooden_shovel");
        //if (itemStack.getItem() == Items.apple) return 1;
        if (itemStack.getItem() == Items.iron_shovel) return 0;
        if (itemStack.getItem() == Items.iron_pickaxe) return 0;
        if (itemStack.getItem() == Items.iron_axe) return 0;
        if (itemStack.getItem() == Items.flint_and_steel) return 0;
        if (itemStack.getItem() == Items.apple) return 16;
        if (itemStack.getItem() == Items.arrow) return 0;
        if (itemStack.getItem() == Items.coal) return 0;
        if (itemStack.getItem() == Items.diamond) return 0;
        if (itemStack.getItem() == Items.iron_ingot) return 0;
        if (itemStack.getItem() == Items.gold_ingot) return 0;
        if (itemStack.getItem() == Items.iron_sword) return 0;
        if (itemStack.getItem() == Items.wooden_sword) return 0;
        if (itemStack.getItem() == Items.wooden_shovel) return 0;
        if (itemStack.getItem() == Items.wooden_pickaxe) return 0;
        if (itemStack.getItem() == Items.wooden_axe) return 0;
        if (itemStack.getItem() == Items.stone_sword) return 0;
        if (itemStack.getItem() == Items.stone_shovel) return 0;
        if (itemStack.getItem() == Items.stone_pickaxe) return 0;
        if (itemStack.getItem() == Items.stone_axe) return 0;
        if (itemStack.getItem() == Items.diamond_sword) return 0;
        if (itemStack.getItem() == Items.diamond_shovel) return 0;
        if (itemStack.getItem() == Items.diamond_pickaxe) return 0;
        if (itemStack.getItem() == Items.diamond_axe) return 0;
        if (itemStack.getItem() == Items.stick) return 0;
        if (itemStack.getItem() == Items.bowl) return 0;
        if (itemStack.getItem() == Items.mushroom_stew) return 0;
        if (itemStack.getItem() == Items.golden_sword) return 0;
        if (itemStack.getItem() == Items.golden_shovel) return 0;
        if (itemStack.getItem() == Items.golden_pickaxe) return 0;
        if (itemStack.getItem() == Items.golden_axe) return 0;
        if (itemStack.getItem() == Items.string) return 0;
        if (itemStack.getItem() == Items.feather) return 0;
        if (itemStack.getItem() == Items.gunpowder) return 0;
        if (itemStack.getItem() == Items.wooden_hoe) return 0;
        if (itemStack.getItem() == Items.stone_hoe) return 0;
        if (itemStack.getItem() == Items.iron_hoe) return 0;
        if (itemStack.getItem() == Items.diamond_hoe) return 0;
        if (itemStack.getItem() == Items.golden_hoe) return 0;
        if (itemStack.getItem() == Items.wheat_seeds) return 0;
        if (itemStack.getItem() == Items.wheat) return 0;
        if (itemStack.getItem() == Items.bread) return 0;
        if (itemStack.getItem() == Items.flint) return 0;
        if (itemStack.getItem() == Items.porkchop) return 0;
        if (itemStack.getItem() == Items.cooked_porkchop) return 0;
        if (itemStack.getItem() == Items.painting) return 0;
        if (itemStack.getItem() == Items.golden_apple) return 0;
        if (itemStack.getItem() == Items.sign) return 0;
        if (itemStack.getItem() == Items.wooden_door) return 0;
        if (itemStack.getItem() == Items.bucket) return 0;
        if (itemStack.getItem() == Items.water_bucket) return 0;
        if (itemStack.getItem() == Items.lava_bucket) return 0;
        if (itemStack.getItem() == Items.minecart) return 0;
        if (itemStack.getItem() == Items.saddle) return 0;
        if (itemStack.getItem() == Items.iron_door) return 0;
        if (itemStack.getItem() == Items.redstone) return 0;
        if (itemStack.getItem() == Items.snowball) return 0;
        if (itemStack.getItem() == Items.boat) return 0;
        if (itemStack.getItem() == Items.leather) return 0;
        if (itemStack.getItem() == Items.milk_bucket) return 0;
        if (itemStack.getItem() == Items.brick) return 0;
        if (itemStack.getItem() == Items.clay_ball) return 0;
        if (itemStack.getItem() == Items.reeds) return 0;
        if (itemStack.getItem() == Items.paper) return 0;
        if (itemStack.getItem() == Items.book) return 0;
        if (itemStack.getItem() == Items.slime_ball) return 0;
        if (itemStack.getItem() == Items.chest_minecart) return 0;
        if (itemStack.getItem() == Items.furnace_minecart) return 0;
        if (itemStack.getItem() == Items.egg) return 0;
        if (itemStack.getItem() == Items.compass) return 0;
        if (itemStack.getItem() == Items.clock) return 0;
        if (itemStack.getItem() == Items.glowstone_dust) return 0;
        if (itemStack.getItem() == Items.fish) return 0;
        if (itemStack.getItem() == Items.cooked_fished) return 0;
        if (itemStack.getItem() == Items.dye) return 0;
        if (itemStack.getItem() == Items.bone) return 0;
        if (itemStack.getItem() == Items.sugar) return 0;
        if (itemStack.getItem() == Items.cake) return 0;
        if (itemStack.getItem() == Items.bed) return 0;
        if (itemStack.getItem() == Items.repeater) return 0;
        if (itemStack.getItem() == Items.cookie) return 0;
        if (itemStack.getItem() == Items.melon) return 0;
        if (itemStack.getItem() == Items.pumpkin_seeds) return 0;
        if (itemStack.getItem() == Items.melon_seeds) return 0;
        if (itemStack.getItem() == Items.beef) return 0;
        if (itemStack.getItem() == Items.cooked_beef) return 0;
        if (itemStack.getItem() == Items.chicken) return 0;
        if (itemStack.getItem() == Items.cooked_chicken) return 0;
        if (itemStack.getItem() == Items.rotten_flesh) return 0;
        if (itemStack.getItem() == Items.ender_pearl) return 0;
        if (itemStack.getItem() == Items.blaze_rod) return 0;
        if (itemStack.getItem() == Items.ghast_tear) return 0;
        if (itemStack.getItem() == Items.gold_nugget) return 0;
        if (itemStack.getItem() == Items.nether_wart) return 0;
        if (itemStack.getItem() == Items.glass_bottle) return 0;
        if (itemStack.getItem() == Items.spider_eye) return 0;
        if (itemStack.getItem() == Items.fermented_spider_eye) return 0;
        if (itemStack.getItem() == Items.blaze_powder) return 0;
        if (itemStack.getItem() == Items.magma_cream) return 0;
        if (itemStack.getItem() == Items.brewing_stand) return 0;
        if (itemStack.getItem() == Items.cauldron) return 0;
        if (itemStack.getItem() == Items.ender_eye) return 0;
        if (itemStack.getItem() == Items.speckled_melon) return 0;
        if (itemStack.getItem() == Items.spawn_egg) return 0;
        if (itemStack.getItem() == Items.experience_bottle) return 0;
        if (itemStack.getItem() == Items.fire_charge) return 0;
        if (itemStack.getItem() == Items.writable_book) return 0;
        if (itemStack.getItem() == Items.written_book) return 0;
        if (itemStack.getItem() == Items.emerald) return 0;
        if (itemStack.getItem() == Items.item_frame) return 0;
        if (itemStack.getItem() == Items.flower_pot) return 0;
        if (itemStack.getItem() == Items.carrot) return 0;
        if (itemStack.getItem() == Items.potato) return 0;
        if (itemStack.getItem() == Items.baked_potato) return 0;
        if (itemStack.getItem() == Items.poisonous_potato) return 0;
        if (itemStack.getItem() == Items.golden_carrot) return 0;
        if (itemStack.getItem() == Items.skull) return 0;
        if (itemStack.getItem() == Items.carrot_on_a_stick) return 0;
        if (itemStack.getItem() == Items.nether_star) return 0;
        if (itemStack.getItem() == Items.pumpkin_pie) return 0;
        if (itemStack.getItem() == Items.fireworks) return 0;
        if (itemStack.getItem() == Items.firework_charge) return 0;
        if (itemStack.getItem() == Items.comparator) return 0;
        if (itemStack.getItem() == Items.netherbrick) return 0;
        if (itemStack.getItem() == Items.quartz) return 0;
        if (itemStack.getItem() == Items.tnt_minecart) return 0;
        if (itemStack.getItem() == Items.hopper_minecart) return 0;
        if (itemStack.getItem() == Items.iron_horse_armor) return 0;
        if (itemStack.getItem() == Items.golden_horse_armor) return 0;
        if (itemStack.getItem() == Items.diamond_horse_armor) return 0;
        if (itemStack.getItem() == Items.lead) return 0;
        if (itemStack.getItem() == Items.name_tag) return 0;
        if (itemStack.getItem() == Items.command_block_minecart) return 0;

        //if (itemStack.getItem() == command_block_minecart) return 0;
/*
        public static final ItemBow bow
        public static final ItemEnchantedBook enchanted_book
        public static final ItemEmptyMap map
        public static final ItemPotion potionitem
        public static final ItemMap filled_map
        public static final ItemShears shears
        public static final ItemFishingRod fishing_rod
        public static final ItemArmor leather_helmet
        public static final ItemArmor leather_chestplate
        public static final ItemArmor leather_leggings
        public static final ItemArmor leather_boots
        public static final ItemArmor chainmail_helmet
        public static final ItemArmor chainmail_chestplate
        public static final ItemArmor chainmail_leggings
        public static final ItemArmor chainmail_boots
        public static final ItemArmor iron_helmet
        public static final ItemArmor iron_chestplate
        public static final ItemArmor iron_leggings
        public static final ItemArmor iron_boots
        public static final ItemArmor diamond_helmet
        public static final ItemArmor diamond_chestplate
        public static final ItemArmor diamond_leggings
        public static final ItemArmor diamond_boots
        public static final ItemArmor golden_helmet
        public static final ItemArmor golden_chestplate
        public static final ItemArmor golden_leggings
        public static final ItemArmor golden_boots
*/
        return 0;
    }

}
