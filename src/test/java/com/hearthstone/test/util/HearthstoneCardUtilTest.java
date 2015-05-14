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

package com.hearthstone.test.util;

import com.hearthstone.model.HearthstoneCardModel;
import com.hearthstone.util.HearthstoneCardUtil;

import java.io.IOException;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardUtilTest {

	@Test
	public void testGetHearthstoneCardJson() throws IOException {
		HearthstoneCardUtil.setHearthstoneCardJson(_TEST_HEARTHSTONE_CARD_JSON);

		List<HearthstoneCardModel> hearthstoneCardModels =
			HearthstoneCardUtil.getHearthstoneCardJson();

		Assert.assertEquals(hearthstoneCardModels.size(), 4);

		HearthstoneCardModel hearthstoneCardModel = hearthstoneCardModels.get(
			0);

		Assert.assertEquals(hearthstoneCardModel.getSet(), "Basic");
		Assert.assertEquals(hearthstoneCardModel.getId(), "CS2_112");
		Assert.assertEquals(hearthstoneCardModel.getName(), "Arcanite Reaper");
		Assert.assertEquals(hearthstoneCardModel.getType(), "Weapon");
		Assert.assertEquals(hearthstoneCardModel.getFaction(), "Neutral");
		Assert.assertEquals(hearthstoneCardModel.getRarity(), "Common");
		Assert.assertEquals(hearthstoneCardModel.getCost(), 5);
		Assert.assertEquals(hearthstoneCardModel.getAttack(), 5);
		Assert.assertEquals(hearthstoneCardModel.getDurability(), 2);
		Assert.assertEquals(
			hearthstoneCardModel.getFlavor(),
			"No… actually you should fear the Reaper.");
		Assert.assertEquals(
			hearthstoneCardModel.getArtist(), "Stefan Kopinski");
		Assert.assertEquals(hearthstoneCardModel.isCollectible(), true);
		Assert.assertEquals(hearthstoneCardModel.getPlayerClass(), "Warrior");
		Assert.assertEquals(
			hearthstoneCardModel.getHowToGet(), "Unlocked at Level 10.");
		Assert.assertEquals(
			hearthstoneCardModel.getHowToGetGold(), "Unlocked at Level 51.");

		hearthstoneCardModel = hearthstoneCardModels.get(1);

		Assert.assertEquals(hearthstoneCardModel.getSet(), "Basic");
		Assert.assertEquals(hearthstoneCardModel.getId(), "EX1_066");
		Assert.assertEquals(
			hearthstoneCardModel.getName(), "Acidic Swamp Ooze");
		Assert.assertEquals(hearthstoneCardModel.getType(), "Minion");
		Assert.assertEquals(hearthstoneCardModel.getFaction(), "Alliance");
		Assert.assertEquals(hearthstoneCardModel.getRarity(), "Common");
		Assert.assertEquals(hearthstoneCardModel.getCost(), 2);
		Assert.assertEquals(hearthstoneCardModel.getAttack(), 3);
		Assert.assertEquals(hearthstoneCardModel.getHealth(), 2);
		Assert.assertEquals(
			hearthstoneCardModel.getText(),
			"<b>Battlecry:</b> Destroy your opponent's weapon.");
		Assert.assertEquals(
			hearthstoneCardModel.getFlavor(),
			"Oozes love Flamenco.  Don't ask.");
		Assert.assertEquals(hearthstoneCardModel.getArtist(), "Chris Rahn");
		Assert.assertEquals(hearthstoneCardModel.isCollectible(), true);
		Assert.assertEquals(
			hearthstoneCardModel.getHowToGetGold(),
			"Unlocked at Rogue Level 57.");

		hearthstoneCardModel = hearthstoneCardModels.get(2);

		Assert.assertEquals(
			hearthstoneCardModel.getSet(), "Blackrock Mountain");
		Assert.assertEquals(hearthstoneCardModel.getId(), "BRM_031");
		Assert.assertEquals(hearthstoneCardModel.getName(), "Chromaggus");
		Assert.assertEquals(hearthstoneCardModel.getType(), "Minion");
		Assert.assertEquals(hearthstoneCardModel.getRarity(), "Legendary");
		Assert.assertEquals(hearthstoneCardModel.getCost(), 8);
		Assert.assertEquals(hearthstoneCardModel.getAttack(), 6);
		Assert.assertEquals(hearthstoneCardModel.getHealth(), 8);
		Assert.assertEquals(
			hearthstoneCardModel.getText(),
			"Whenever you draw a card, put another copy into your hand.");
		Assert.assertEquals(
			hearthstoneCardModel.getFlavor(),
			"Left head and right head can never agree about what to eat for " +
				"dinner, so they always end up just eating ramen again.");
		Assert.assertEquals(hearthstoneCardModel.getArtist(), "Todd Lockwood");
		Assert.assertEquals(hearthstoneCardModel.isCollectible(), true);
		Assert.assertEquals(hearthstoneCardModel.isElite(), true);
		Assert.assertEquals(hearthstoneCardModel.getRace(), "Dragon");
		Assert.assertEquals(
			hearthstoneCardModel.getHowToGet(),
			"Unlocked by completing Blackwing Lair.");
		Assert.assertEquals(
			hearthstoneCardModel.getHowToGetGold(),
			"Can be crafted after completing Blackwing Lair.");

		hearthstoneCardModel = hearthstoneCardModels.get(3);

		Assert.assertEquals(hearthstoneCardModel.getSet(), "Classic");
		Assert.assertEquals(hearthstoneCardModel.getId(), "EX1_559");
		Assert.assertEquals(
			hearthstoneCardModel.getName(), "Archmage Antonidas");
		Assert.assertEquals(hearthstoneCardModel.getType(), "Minion");
		Assert.assertEquals(hearthstoneCardModel.getFaction(), "Neutral");
		Assert.assertEquals(hearthstoneCardModel.getRarity(), "Legendary");
		Assert.assertEquals(hearthstoneCardModel.getCost(), 7);
		Assert.assertEquals(hearthstoneCardModel.getAttack(), 5);
		Assert.assertEquals(hearthstoneCardModel.getHealth(), 7);
		Assert.assertEquals(
			hearthstoneCardModel.getText(),
			"Whenever you cast a spell, add a 'Fireball' spell to your hand.");
		Assert.assertEquals(
			hearthstoneCardModel.getInPlayText(), "Grand Magus");
		Assert.assertEquals(
			hearthstoneCardModel.getFlavor(),
			"Antonidas was the Grand Magus of the Kirin Tor, and Jaina's " +
				"mentor.  This was a big step up from being Grand Magus of "+
					"Jelly Donuts.");
		Assert.assertEquals(hearthstoneCardModel.getArtist(), "Wayne Reynolds");
		Assert.assertEquals(hearthstoneCardModel.isCollectible(), true);
		Assert.assertEquals(hearthstoneCardModel.isElite(), true);
		Assert.assertEquals(hearthstoneCardModel.getPlayerClass(), "Mage");
	}

	private static final String _TEST_HEARTHSTONE_CARD_JSON =
		"src/test/resources/test.json";

}