package com.github.alexthe666.iceandfire.core;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.github.alexthe666.iceandfire.enums.EnumDragonArmor;
import com.github.alexthe666.iceandfire.enums.EnumDragonEgg;
import com.github.alexthe666.iceandfire.item.ItemBestiary;
import com.github.alexthe666.iceandfire.item.ItemDragonArmor;
import com.github.alexthe666.iceandfire.item.ItemDragonBone;
import com.github.alexthe666.iceandfire.item.ItemDragonBow;
import com.github.alexthe666.iceandfire.item.ItemDragonEgg;
import com.github.alexthe666.iceandfire.item.ItemDragonScales;
import com.github.alexthe666.iceandfire.item.ItemDragonSkull;
import com.github.alexthe666.iceandfire.item.ItemGeneric;
import com.github.alexthe666.iceandfire.item.ItemModAxe;
import com.github.alexthe666.iceandfire.item.ItemModHoe;
import com.github.alexthe666.iceandfire.item.ItemModPickaxe;
import com.github.alexthe666.iceandfire.item.ItemModShovel;
import com.github.alexthe666.iceandfire.item.ItemModSword;
import com.github.alexthe666.iceandfire.item.ItemSilverArmor;

public class ModItems {

	public static Item bestiary;
	public static Item manuscript;
	public static Item sapphireGem;
	public static Item silverIngot;
	public static Item silverNugget;
	public static Item silver_helmet;
	public static Item silver_chestplate;
	public static Item silver_leggings;
	public static Item silver_boots;
	public static Item silver_sword;
	public static Item silver_shovel;
	public static Item silver_pickaxe;
	public static Item silver_axe;
	public static Item silver_hoe;
	public static Item dragonegg_red;
	public static Item dragonegg_green;
	public static Item dragonegg_bronze;
	public static Item dragonegg_gray;
	public static Item dragonegg_blue;
	public static Item dragonegg_white;
	public static Item dragonegg_sapphire;
	public static Item dragonegg_silver;
	public static Item dragonscales_red;
	public static Item dragonscales_green;
	public static Item dragonscales_bronze;
	public static Item dragonscales_gray;
	public static Item dragonscales_blue;
	public static Item dragonscales_white;
	public static Item dragonscales_sapphire;
	public static Item dragonscales_silver;
	public static Item dragonbone;
	public static Item witherbone;
	public static Item wither_shard;
	public static Item dragonbone_sword;
	public static Item dragonbone_shovel;
	public static Item dragonbone_pickaxe;
	public static Item dragonbone_axe;
	public static Item dragonbone_hoe;
	public static Item dragonbone_arrow;
	public static Item dragonbone_bow;
	public static Item dragon_skull;
	public static Item dragon_armor_iron;

	public static ArmorMaterial silverMetal = EnumHelper.addArmorMaterial("Silver", "iceandfire:armor_silverMetal", 25, new int[] { 2, 7, 6, 2 }, 20, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0);
	public static ArmorMaterial red = EnumHelper.addArmorMaterial("DragonRed", "iceandfire:armor_red", 25, new int[] { 2, 7, 6, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0);
	public static ArmorMaterial bronze = EnumHelper.addArmorMaterial("DragonBronze", "iceandfire:armor_bronze", 25, new int[] { 2, 7, 6, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0);
	public static ArmorMaterial green = EnumHelper.addArmorMaterial("DragonGreen", "iceandfire:armor_green", 25, new int[] { 2, 7, 6, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0);
	public static ArmorMaterial gray = EnumHelper.addArmorMaterial("DragonGray", "iceandfire:armor_gray", 25, new int[] { 2, 7, 6, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0);
	public static ToolMaterial silverTools = EnumHelper.addToolMaterial("Silver", 2, 460, 11.0F, 1.0F, 18);
	public static ToolMaterial boneTools = EnumHelper.addToolMaterial("Dragonbone", 4, 1660, 10.0F, 4.0F, 22);

	public static void init() {
		bestiary = new ItemBestiary();
		manuscript = new ItemGeneric("manuscript", "iceandfire.manuscript");
		sapphireGem = new ItemGeneric("sapphire_gem", "iceandfire.sapphireGem");
		silverIngot = new ItemGeneric("silver_ingot", "iceandfire.silverIngot");
		silverNugget = new ItemGeneric("silver_nugget", "iceandfire.silverNugget");
		silver_helmet = new ItemSilverArmor(silverMetal, 0, EntityEquipmentSlot.HEAD, "armor_silverMetal_helmet", "iceandfire.silver_helmet");
		silver_chestplate = new ItemSilverArmor(silverMetal, 1, EntityEquipmentSlot.CHEST, "armor_silverMetal_chestplate", "iceandfire.silver_chestplate");
		silver_leggings = new ItemSilverArmor(silverMetal, 2, EntityEquipmentSlot.LEGS, "armor_silverMetal_leggings", "iceandfire.silver_leggings");
		silver_boots = new ItemSilverArmor(silverMetal, 3, EntityEquipmentSlot.FEET, "armor_silverMetal_boots", "iceandfire.silver_boots");
		silver_sword = new ItemModSword(silverTools, "silver_sword", "iceandfire.silver_sword");
		silver_shovel = new ItemModShovel(silverTools, "silver_shovel", "iceandfire.silver_shovel");
		silver_pickaxe = new ItemModPickaxe(silverTools, "silver_pickaxe", "iceandfire.silver_pickaxe");
		silver_axe = new ItemModAxe(silverTools, "silver_axe", "iceandfire.silver_axe");
		silver_hoe = new ItemModHoe(silverTools, "silver_hoe", "iceandfire.silver_hoe");
		dragonegg_red = new ItemDragonEgg("dragonegg_red", EnumDragonEgg.RED);
		dragonegg_green = new ItemDragonEgg("dragonegg_green", EnumDragonEgg.GREEN);
		dragonegg_bronze = new ItemDragonEgg("dragonegg_bronze", EnumDragonEgg.BRONZE);
		dragonegg_gray = new ItemDragonEgg("dragonegg_gray", EnumDragonEgg.GRAY);
		dragonegg_blue = new ItemDragonEgg("dragonegg_blue", EnumDragonEgg.BLUE);
		dragonegg_white = new ItemDragonEgg("dragonegg_white", EnumDragonEgg.WHITE);
		dragonegg_sapphire = new ItemDragonEgg("dragonegg_sapphire", EnumDragonEgg.SAPPHIRE);
		dragonegg_silver = new ItemDragonEgg("dragonegg_silver", EnumDragonEgg.SILVER);
		dragonscales_red = new ItemDragonScales("dragonscales_red", EnumDragonEgg.RED);
		dragonscales_green = new ItemDragonScales("dragonscales_green", EnumDragonEgg.GREEN);
		dragonscales_bronze = new ItemDragonScales("dragonscales_bronze", EnumDragonEgg.BRONZE);
		dragonscales_gray = new ItemDragonScales("dragonscales_gray", EnumDragonEgg.GRAY);
		dragonscales_blue = new ItemDragonScales("dragonscales_blue", EnumDragonEgg.BLUE);
		dragonscales_white = new ItemDragonScales("dragonscales_white", EnumDragonEgg.WHITE);
		dragonscales_sapphire = new ItemDragonScales("dragonscales_sapphire", EnumDragonEgg.SAPPHIRE);
		dragonscales_silver = new ItemDragonScales("dragonscales_silver", EnumDragonEgg.SILVER);
		EnumDragonArmor.initArmors();
		dragonbone = new ItemDragonBone();
		witherbone = new ItemGeneric("witherbone", "iceandfire.witherbone");
		wither_shard = new ItemGeneric("wither_shard", "iceandfire.wither_shard");
		dragonbone_sword = new ItemModSword(boneTools, "dragonbone_sword", "iceandfire.dragonbone_sword");
		dragonbone_shovel = new ItemModShovel(boneTools, "dragonbone_shovel", "iceandfire.dragonbone_shovel");
		dragonbone_pickaxe = new ItemModPickaxe(boneTools, "dragonbone_pickaxe", "iceandfire.dragonbone_pickaxe");
		dragonbone_axe = new ItemModAxe(boneTools, "dragonbone_axe", "iceandfire.dragonbone_axe");
		dragonbone_hoe = new ItemModHoe(boneTools, "dragonbone_hoe", "iceandfire.dragonbone_hoe");
		dragonbone_arrow = new ItemGeneric("dragonbone_arrow", "iceandfire.dragonbone_arrow");
		dragonbone_bow = new ItemDragonBow();
		dragon_skull = new ItemDragonSkull();
		dragon_armor_iron = new ItemDragonArmor(0, "dragonarmor_iron");
	}
}
