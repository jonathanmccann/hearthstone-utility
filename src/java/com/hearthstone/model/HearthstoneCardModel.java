/**
 * Copyright (c) 2015-present Jonathan McCann
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */

package com.hearthstone.model;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardModel {
	public HearthstoneCardModel() {
	}

	public HearthstoneCardModel(
		String id, String set, String name, String mechanics,
		String text, String type, String rarity, String playerClass,
		String race, String faction, String inPlayText, String flavor,
		String artist, String howToGet, String howToGetGold, int cost,
		int attack, int health, int durability, boolean collectible,
		boolean elite) {

		_id = id;
		_set = set;
		_name = name;
		_mechanics = mechanics;
		_text = text;
		_type = type;
		_rarity = rarity;
		_playerClass = playerClass;
		_race = race;
		_faction = faction;
		_inPlayText = inPlayText;
		_flavor = flavor;
		_artist = artist;
		_howToGet = howToGet;
		_howToGetGold = howToGetGold;
		_cost = cost;
		_attack = attack;
		_health = health;
		_durability = durability;
		_collectible = collectible;
		_elite = elite;
	}

	public String getSet() {
		return _set;
	}

	public void setSet(String set) {
		_set = set;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMechanics() {
		return _mechanics;
	}

	public void setMechanics(String mechanics) {
		_mechanics = mechanics;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getRarity() {
		return _rarity;
	}

	public void setRarity(String rarity) {
		_rarity = rarity;
	}

	public String getPlayerClass() {
		return _playerClass;
	}

	public void setPlayerClass(String playerClass) {
		_playerClass = playerClass;
	}

	public String getRace() {
		return _race;
	}

	public void setRace(String race) {
		_race = race;
	}

	public String getFaction() {
		return _faction;
	}

	public void setFaction(String faction) {
		_faction = faction;
	}

	public String getInPlayText() {
		return _inPlayText;
	}

	public void setInPlayText(String inPlayText) {
		_inPlayText = inPlayText;
	}

	public String getFlavor() {
		return _flavor;
	}

	public void setFlavor(String flavor) {
		_flavor = flavor;
	}

	public String getArtist() {
		return _artist;
	}

	public void setArtist(String artist) {
		_artist = artist;
	}

	public String getHowToGet() {
		return _howToGet;
	}

	public void setHowToGet(String howToGet) {
		_howToGet = howToGet;
	}

	public String getHowToGetGold() {
		return _howToGetGold;
	}

	public void setHowToGetGold(String howToGetGold) {
		_howToGetGold = howToGetGold;
	}

	public int getCost() {
		return _cost;
	}

	public void setCost(int cost) {
		_cost = cost;
	}

	public int getAttack() {
		return _attack;
	}

	public void setAttack(int attack) {
		_attack = attack;
	}

	public int getHealth() {
		return _health;
	}

	public void setHealth(int health) {
		_health = health;
	}

	public int getDurability() {
		return _durability;
	}

	public void setDurability(int durability) {
		_durability = durability;
	}

	public boolean isCollectible() {
		return _collectible;
	}

	public void setCollectible(boolean collectible) {
		_collectible = collectible;
	}

	public boolean isElite() {
		return _elite;
	}

	public void setElite(boolean elite) {
		_elite = elite;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	private String _id;
	private String _set;
	private String _name;
	private String _mechanics;
	private String _text;
	private String _type;
	private String _rarity;
	private String _playerClass;
	private String _race;
	private String _faction;
	private String _inPlayText;
	private String _flavor;
	private String _artist;
	private String _howToGet;
	private String _howToGetGold;
	private int _cost;
	private int _attack;
	private int _health;
	private int _durability;
	private boolean _collectible;
	private boolean _elite;

}