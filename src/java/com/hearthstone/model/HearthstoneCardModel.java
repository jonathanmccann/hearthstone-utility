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

import java.util.List;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardModel {

	public HearthstoneCardModel() {
	}

	public HearthstoneCardModel(
		String id, String set, String name, List<String> mechanics, String text,
		String type, String rarity, String playerClass, String race,
		String faction, String inPlayText, String flavor, String artist,
		String howToGet, String howToGetGold, int cost, int attack, int health,
		int durability, boolean collectible, boolean elite) {

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

	public String getArtist() {
		return _artist;
	}

	public int getAttack() {
		return _attack;
	}

	public int getCost() {
		return _cost;
	}

	public int getDurability() {
		return _durability;
	}

	public String getFaction() {
		return _faction;
	}

	public String getFlavor() {
		return _flavor;
	}

	public int getHealth() {
		return _health;
	}

	public String getHowToGet() {
		return _howToGet;
	}

	public String getHowToGetGold() {
		return _howToGetGold;
	}

	public String getId() {
		return _id;
	}

	public String getInPlayText() {
		return _inPlayText;
	}

	public List<String> getMechanics() {
		return _mechanics;
	}

	public String getName() {
		return _name;
	}

	public String getPlayerClass() {
		return _playerClass;
	}

	public String getRace() {
		return _race;
	}

	public String getRarity() {
		return _rarity;
	}

	public String getSet() {
		return _set;
	}

	public String getText() {
		return _text;
	}

	public String getType() {
		return _type;
	}

	public boolean isCollectible() {
		return _collectible;
	}

	public boolean isElite() {
		return _elite;
	}

	public void setArtist(String artist) {
		_artist = artist;
	}

	public void setAttack(int attack) {
		_attack = attack;
	}

	public void setCollectible(boolean collectible) {
		_collectible = collectible;
	}

	public void setCost(int cost) {
		_cost = cost;
	}

	public void setDurability(int durability) {
		_durability = durability;
	}

	public void setElite(boolean elite) {
		_elite = elite;
	}

	public void setFaction(String faction) {
		_faction = faction;
	}

	public void setFlavor(String flavor) {
		_flavor = flavor;
	}

	public void setHealth(int health) {
		_health = health;
	}

	public void setHowToGet(String howToGet) {
		_howToGet = howToGet;
	}

	public void setHowToGetGold(String howToGetGold) {
		_howToGetGold = howToGetGold;
	}

	public void setId(String id) {
		_id = id;
	}

	public void setInPlayText(String inPlayText) {
		_inPlayText = inPlayText;
	}

	public void setMechanics(List<String> mechanics) {
		_mechanics = mechanics;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setPlayerClass(String playerClass) {
		_playerClass = playerClass;
	}

	public void setRace(String race) {
		_race = race;
	}

	public void setRarity(String rarity) {
		_rarity = rarity;
	}

	public void setSet(String set) {
		_set = set;
	}

	public void setText(String text) {
		_text = text;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _artist;
	private int _attack;
	private boolean _collectible;
	private int _cost;
	private int _durability;
	private boolean _elite;
	private String _faction;
	private String _flavor;
	private int _health;
	private String _howToGet;
	private String _howToGetGold;
	private String _id;
	private String _inPlayText;
	private List<String> _mechanics;
	private String _name;
	private String _playerClass;
	private String _race;
	private String _rarity;
	private String _set;
	private String _text;
	private String _type;

}