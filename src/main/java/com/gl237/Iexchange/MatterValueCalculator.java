package com.gl237.Iexchange;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Industral exchange mod
 * Created by gl237 on 21.09.2014.
 */
public class MatterValueCalculator {
    public MatterValueCalculator()
    {

    }

    public static int GetMatterValue(ItemStack itemStack) {
        /*
        Note1 1
        Button, Stone Pressure Plate 2
        Gravel, Nether Brick, Stick, Sandstone, Sandstone Slab, Flint 4
        Lever 5
        Cactus, Furnace, Medium Covalence Dust, Vines, Wooden Planks, Wooden Slab, Dye 8
        Torch 9
        Cobweb, Fence, Fishing Rod, String, Wooden Stairs 12
        Ladder, Arrow 14
        Flower, Rose, Lily Pad, Wooden Pressure Plate, Seeds, Melon Seeds, Pumpkin Seeds 16
        Wheat, Trap Door, Sticky Resin, Nether Wart, Rotten Flesh, Slimeball 24
        Note2 32
        Wool(all colors), Bone Meal, Feather 48
        Soul Sand 49
        Chest, Obsidian, Redstone, Porkchop, Beef, Fish, Chicken, Leather, Clay, Verdant Dust 64
        Redstone Torch 68
        Bread 72
        Painting 80
        Iron Bars, Rail, Book, Bone 96
        Dispenser 119
        Coal, Apple, Note Block, Spider Eye 128
        Jack 'o' Lantern, Melon, Pumpkin, Bed, Bone 144
        Moss Stone 145
        Gunpowder, Fermented Spider Eye, Saddle 192
        Glistering Melon 243
        Brick Block, Brick Slab, Clay Block, Detector Rail, Iron Ingot 256
        Bookshelf 336
        Brick Stairs, Piston 348
        Sticky Piston 372
        Cake, Glowstone Dust 384
        Blaze Powder, Bucket 768
        Water Bucket 769
        Magma Cream 792
        Lava bucket 832
        Milk bucket 833
        Lapis Lazuli 864
        TNT 964
        Ender Pearl 1, 024
        Compass 1, 088
        Minecart, Iron Helmet 1, 280
        Minecart with Furnace 1, 288
        Minecart with Chest 1, 344
        Glowstone, Iron Door, Blaze Rod 1, 536
        Brewing Stand 1, 539
        Eye of Ender 1, 792
        Golden Apple 1, 944
        Gold Ingot, Powered Rail, Azure Dust 2, 048
        Iron Block 2, 304
        Ghast Tear 4, 096
        Lapis Lazuli Block 7, 776
        Diamond, Emerald, Minium Dust 8, 192
        Diamond Shovel 8, 200
        Jukebox 8, 256
        Diamond Sword 16, 388
        Diamond Hoe 16, 392
        Enchantment Table 16, 736
        Gold Block 18, 432
        Diamond Pickaxe, Diamond Axe 24, 584
        Diamond Boots 32, 768
        Diamond Helmet 40, 960
        Diamond Leggings 57, 344
        Diamond Chestplate 65, 536
        Diamond Block 73, 728
        Note 1:Cobblestone, Cobblestone Slab, Dead Bush, Fern, Tall
        Grass, Dirt, Glass, Grass, Ice, Leaves, Mycelium, Netherrack, Sand, Snow, Stone, Stone Brick Stairs, Stone
        Bricks, Stone Slab, Stone Stairs, Basalt, Basalt Brick, Basalt Cobblestone, Marble, Marble Brick, End Stone, Ash
        Note 2:Charcoal, Crafting Table, Fence Gate, Mushroom(Red, Brown), Sapling, Wood, Sugarcane, Paper, Sugar, Egg
        */
        //Получение не ванильных предметов (Item)Item.itemRegistry.getObject("lEnergyBucketItem");
        //if (item == Items.apple) return 1;
        //Итемы
        Item item = itemStack.getItem();

        if (item == Items.iron_shovel) return 0;
        if (item == Items.iron_pickaxe) return 0;
        if (item == Items.iron_axe) return 0;
        if (item == Items.flint_and_steel) return 0;
        if (item == Items.apple) return 16;
        if (item == Items.arrow) return 0;
        if (item == Items.coal) return 0;
        if (item == Items.diamond) return 8096;
        if (item == Items.iron_ingot) return 0;
        if (item == Items.gold_ingot) return 0;
        if (item == Items.iron_sword) return 0;
        if (item == Items.wooden_sword) return 0;
        if (item == Items.wooden_shovel) return 0;
        if (item == Items.wooden_pickaxe) return 0;
        if (item == Items.wooden_axe) return 0;
        if (item == Items.stone_sword) return 0;
        if (item == Items.stone_shovel) return 0;
        if (item == Items.stone_pickaxe) return 0;
        if (item == Items.stone_axe) return 0;
        if (item == Items.diamond_sword) return 0;
        if (item == Items.diamond_shovel) return 0;
        if (item == Items.diamond_pickaxe) return 0;
        if (item == Items.diamond_axe) return 0;
        if (item == Items.stick) return 0;
        if (item == Items.bowl) return 0;
        if (item == Items.mushroom_stew) return 0;
        if (item == Items.golden_sword) return 0;
        if (item == Items.golden_shovel) return 0;
        if (item == Items.golden_pickaxe) return 0;
        if (item == Items.golden_axe) return 0;
        if (item == Items.string) return 0;
        if (item == Items.feather) return 0;
        if (item == Items.gunpowder) return 0;
        if (item == Items.wooden_hoe) return 0;
        if (item == Items.stone_hoe) return 0;
        if (item == Items.iron_hoe) return 0;
        if (item == Items.diamond_hoe) return 0;
        if (item == Items.golden_hoe) return 0;
        if (item == Items.wheat_seeds) return 0;
        if (item == Items.wheat) return 0;
        if (item == Items.bread) return 0;
        if (item == Items.flint) return 0;
        if (item == Items.porkchop) return 0;
        if (item == Items.cooked_porkchop) return 0;
        if (item == Items.painting) return 0;
        if (item == Items.golden_apple) return 0;
        if (item == Items.sign) return 0;
        if (item == Items.wooden_door) return 0;
        if (item == Items.bucket) return 0;
        if (item == Items.water_bucket) return 0;
        if (item == Items.lava_bucket) return 0;
        if (item == Items.minecart) return 0;
        if (item == Items.saddle) return 0;
        if (item == Items.iron_door) return 0;
        if (item == Items.redstone) return 0;
        if (item == Items.snowball) return 0;
        if (item == Items.boat) return 0;
        if (item == Items.leather) return 0;
        if (item == Items.milk_bucket) return 0;
        if (item == Items.brick) return 0;
        if (item == Items.clay_ball) return 0;
        if (item == Items.reeds) return 0;
        if (item == Items.paper) return 0;
        if (item == Items.book) return 0;
        if (item == Items.slime_ball) return 0;
        if (item == Items.chest_minecart) return 0;
        if (item == Items.furnace_minecart) return 0;
        if (item == Items.egg) return 0;
        if (item == Items.compass) return 0;
        if (item == Items.clock) return 0;
        if (item == Items.glowstone_dust) return 0;
        if (item == Items.fish) return 0;
        if (item == Items.cooked_fished) return 0;
        if (item == Items.dye) return 0;
        if (item == Items.bone) return 0;
        if (item == Items.sugar) return 0;
        if (item == Items.cake) return 0;
        if (item == Items.bed) return 0;
        if (item == Items.repeater) return 0;
        if (item == Items.cookie) return 0;
        if (item == Items.melon) return 0;
        if (item == Items.pumpkin_seeds) return 0;
        if (item == Items.melon_seeds) return 0;
        if (item == Items.beef) return 0;
        if (item == Items.cooked_beef) return 0;
        if (item == Items.chicken) return 0;
        if (item == Items.cooked_chicken) return 0;
        if (item == Items.rotten_flesh) return 0;
        if (item == Items.ender_pearl) return 0;
        if (item == Items.blaze_rod) return 0;
        if (item == Items.ghast_tear) return 0;
        if (item == Items.gold_nugget) return 0;
        if (item == Items.nether_wart) return 0;
        if (item == Items.glass_bottle) return 0;
        if (item == Items.spider_eye) return 0;
        if (item == Items.fermented_spider_eye) return 0;
        if (item == Items.blaze_powder) return 0;
        if (item == Items.magma_cream) return 0;
        if (item == Items.brewing_stand) return 0;
        if (item == Items.cauldron) return 0;
        if (item == Items.ender_eye) return 0;
        if (item == Items.speckled_melon) return 0;
        if (item == Items.spawn_egg) return 0;
        if (item == Items.experience_bottle) return 0;
        if (item == Items.fire_charge) return 0;
        if (item == Items.writable_book) return 0;
        if (item == Items.written_book) return 0;
        if (item == Items.emerald) return 0;
        if (item == Items.item_frame) return 0;
        if (item == Items.flower_pot) return 0;
        if (item == Items.carrot) return 0;
        if (item == Items.potato) return 0;
        if (item == Items.baked_potato) return 0;
        if (item == Items.poisonous_potato) return 0;
        if (item == Items.golden_carrot) return 0;
        if (item == Items.skull) return 0;
        if (item == Items.carrot_on_a_stick) return 0;
        if (item == Items.nether_star) return 0;
        if (item == Items.pumpkin_pie) return 0;
        if (item == Items.fireworks) return 0;
        if (item == Items.firework_charge) return 0;
        if (item == Items.comparator) return 0;
        if (item == Items.netherbrick) return 0;
        if (item == Items.quartz) return 0;
        if (item == Items.tnt_minecart) return 0;
        if (item == Items.hopper_minecart) return 0;
        if (item == Items.iron_horse_armor) return 0;
        if (item == Items.golden_horse_armor) return 0;
        if (item == Items.diamond_horse_armor) return 0;
        if (item == Items.lead) return 0;
        if (item == Items.name_tag) return 0;
        if (item == Items.command_block_minecart) return 0;
        //Блоки
        if (item == ItemBlock.getItemFromBlock(Blocks.stone)) return 1;
        if (item == ItemBlock.getItemFromBlock(Blocks.grass)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.dirt)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.cobblestone)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.planks)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.sapling)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.bedrock)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.water)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.lava)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.gravel)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.gold_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.iron_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.coal_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.log)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.log2)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.sponge)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.glass)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.lapis_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.lapis_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.dispenser)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.sandstone)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.noteblock)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.bed)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.golden_rail)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.detector_rail)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.web)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.wool)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.gold_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.iron_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.brick_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.tnt)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.bookshelf)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.mossy_cobblestone)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.obsidian)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.torch)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.mob_spawner)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.oak_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.diamond_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.diamond_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.crafting_table)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.wheat)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.farmland)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.furnace)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.lit_furnace)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.standing_sign)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.wooden_door)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.ladder)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.rail)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.stone_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.wall_sign)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.lever)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.stone_pressure_plate)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.iron_door)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.wooden_pressure_plate)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.redstone_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.lit_redstone_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.unlit_redstone_torch)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.redstone_torch)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.stone_button)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.snow_layer)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.ice)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.snow)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.cactus)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.clay)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.reeds)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.jukebox)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.fence)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.pumpkin)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.netherrack)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.soul_sand)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.glowstone)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.lit_pumpkin)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.cake)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.trapdoor)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.monster_egg)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.stonebrick)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.brown_mushroom_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.red_mushroom_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.iron_bars)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.glass_pane)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.melon_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.pumpkin_stem)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.melon_stem)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.vine)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.fence_gate)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.brick_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.stone_brick_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.waterlily)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.nether_brick)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.nether_brick_fence)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.nether_brick_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.nether_wart)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.enchanting_table)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.brewing_stand)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.end_portal)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.end_portal_frame)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.end_stone)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.dragon_egg)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.redstone_lamp)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.lit_redstone_lamp)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.cocoa)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.sandstone_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.emerald_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.ender_chest)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.tripwire)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.emerald_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.spruce_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.birch_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.jungle_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.command_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.cobblestone_wall)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.flower_pot)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.carrots)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.potatoes)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.wooden_button)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.skull)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.anvil)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.trapped_chest)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.light_weighted_pressure_plate)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.heavy_weighted_pressure_plate)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.redstone_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.quartz_ore)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.quartz_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.quartz_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.activator_rail)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.dropper)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.stained_hardened_clay)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.hay_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.carpet)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.hardened_clay)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.coal_block)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.packed_ice)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.acacia_stairs)) return 0;
        if (item == ItemBlock.getItemFromBlock(Blocks.dark_oak_stairs)) return 0;
        
        
        //if (item == command_block_minecart) return 0;
/*
        //Странные блоки
        public static final BlockLiquid flowing_water = (BlockLiquid)Block.blockRegistry.getObject("flowing_water");
        public static final BlockLiquid flowing_lava = (BlockLiquid)Block.blockRegistry.getObject("flowing_lava");
        public static final BlockSand sand = (BlockSand)Block.blockRegistry.getObject("sand");
        public static final BlockLeaves leaves = (BlockLeaves)Block.blockRegistry.getObject("leaves");
        public static final BlockLeaves leaves2 = (BlockLeaves)Block.blockRegistry.getObject("leaves2");
        public static final BlockPistonBase sticky_piston = (BlockPistonBase)Block.blockRegistry.getObject("sticky_piston");
        public static final BlockTallGrass tallgrass = (BlockTallGrass)Block.blockRegistry.getObject("tallgrass");
        public static final BlockDeadBush deadbush = (BlockDeadBush)Block.blockRegistry.getObject("deadbush");
        public static final BlockPistonBase piston = (BlockPistonBase)Block.blockRegistry.getObject("piston");
        public static final BlockPistonExtension piston_head = (BlockPistonExtension)Block.blockRegistry.getObject("piston_head");
        public static final BlockPistonMoving piston_extension = (BlockPistonMoving)Block.blockRegistry.getObject("piston_extension");
        public static final BlockFlower yellow_flower = (BlockFlower)Block.blockRegistry.getObject("yellow_flower");
        public static final BlockFlower red_flower = (BlockFlower)Block.blockRegistry.getObject("red_flower");
        public static final BlockBush brown_mushroom = (BlockBush)Block.blockRegistry.getObject("brown_mushroom");
        public static final BlockBush red_mushroom = (BlockBush)Block.blockRegistry.getObject("red_mushroom");
        public static final BlockSlab double_stone_slab = (BlockSlab)Block.blockRegistry.getObject("double_stone_slab");
        public static final BlockSlab stone_slab = (BlockSlab)Block.blockRegistry.getObject("stone_slab");
        public static final BlockFire fire = (BlockFire)Block.blockRegistry.getObject("fire");
        public static final BlockChest chest = (BlockChest)Block.blockRegistry.getObject("chest");
        public static final BlockRedstoneWire redstone_wire = (BlockRedstoneWire)Block.blockRegistry.getObject("redstone_wire");
        public static final BlockPortal portal = (BlockPortal)Block.blockRegistry.getObject("portal");
        public static final BlockRedstoneRepeater unpowered_repeater = (BlockRedstoneRepeater)Block.blockRegistry.getObject("unpowered_repeater");
        public static final BlockRedstoneRepeater powered_repeater = (BlockRedstoneRepeater)Block.blockRegistry.getObject("powered_repeater");
        public static final BlockMycelium mycelium = (BlockMycelium)Block.blockRegistry.getObject("mycelium");
        public static final BlockCauldron cauldron = (BlockCauldron)Block.blockRegistry.getObject("cauldron");
        public static final BlockSlab double_wooden_slab = (BlockSlab)Block.blockRegistry.getObject("double_wooden_slab");
        public static final BlockSlab wooden_slab = (BlockSlab)Block.blockRegistry.getObject("wooden_slab");
        public static final BlockTripWireHook tripwire_hook = (BlockTripWireHook)Block.blockRegistry.getObject("tripwire_hook");
        public static final BlockBeacon beacon = (BlockBeacon)Block.blockRegistry.getObject("beacon");
        public static final BlockRedstoneComparator unpowered_comparator = (BlockRedstoneComparator)Block.blockRegistry.getObject("unpowered_comparator");
        public static final BlockRedstoneComparator powered_comparator = (BlockRedstoneComparator)Block.blockRegistry.getObject("powered_comparator");
        public static final BlockDaylightDetector daylight_detector = (BlockDaylightDetector)Block.blockRegistry.getObject("daylight_detector");
        public static final BlockHopper hopper = (BlockHopper)Block.blockRegistry.getObject("hopper");
        public static final BlockDoublePlant double_plant = (BlockDoublePlant)Block.blockRegistry.getObject("double_plant");
        public static final BlockStainedGlass stained_glass = (BlockStainedGlass)Block.blockRegistry.getObject("stained_glass");
        public static final BlockStainedGlassPane stained_glass_pane = (BlockStainedGlassPane)Block.blockRegistry.getObject("stained_glass_pane");
        
        
        
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
