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

package com.hearthstone.test.model;

import com.hearthstone.model.HearthstoneCardModel;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardModelTest {

	@Test
	public void testGettersAndSetters() {
		HearthstoneCardModel hearthstoneCardModel = new HearthstoneCardModel();

		hearthstoneCardModel.setId("testId");
		hearthstoneCardModel.setSet("testSet");
		hearthstoneCardModel.setName("testName");
		hearthstoneCardModel.setCost(1);
		hearthstoneCardModel.setAttack(1);
		hearthstoneCardModel.setHealth(1);

		List<String> mechanics = new ArrayList<>();

		mechanics.add("testFirstMechanic");
		mechanics.add("testSecondMechanic");

		hearthstoneCardModel.setMechanics(mechanics);
		hearthstoneCardModel.setText("testText");
		hearthstoneCardModel.setDurability(1);
		hearthstoneCardModel.setCollectible(true);
		hearthstoneCardModel.setType("testType");
		hearthstoneCardModel.setRarity("testRarity");
		hearthstoneCardModel.setPlayerClass("testPlayerClass");
		hearthstoneCardModel.setRace("testRace");
		hearthstoneCardModel.setFaction("testFaction");
		hearthstoneCardModel.setInPlayText("testInPlayText");
		hearthstoneCardModel.setFlavor("testFlavor");
		hearthstoneCardModel.setArtist("testArtist");
		hearthstoneCardModel.setElite(true);
		hearthstoneCardModel.setHowToGet("testHowToGet");
		hearthstoneCardModel.setHowToGetGold("testHowToGetGold");

		Assert.assertEquals("testId", hearthstoneCardModel.getId());
		Assert.assertEquals("testSet", hearthstoneCardModel.getSet());
		Assert.assertEquals("testName", hearthstoneCardModel.getName());
		Assert.assertEquals(1, hearthstoneCardModel.getCost());
		Assert.assertEquals(1, hearthstoneCardModel.getAttack());
		Assert.assertEquals(1, hearthstoneCardModel.getHealth());
		Assert.assertThat(
			hearthstoneCardModel.getMechanics(),
			IsIterableContainingInOrder.contains(mechanics.toArray()));
		Assert.assertEquals("testText", hearthstoneCardModel.getText());
		Assert.assertEquals(1, hearthstoneCardModel.getDurability());
		Assert.assertEquals(true, hearthstoneCardModel.isCollectible());
		Assert.assertEquals("testType", hearthstoneCardModel.getType());
		Assert.assertEquals("testRarity", hearthstoneCardModel.getRarity());
		Assert.assertEquals(
			"testPlayerClass", hearthstoneCardModel.getPlayerClass());
		Assert.assertEquals("testRace", hearthstoneCardModel.getRace());
		Assert.assertEquals("testFaction", hearthstoneCardModel.getFaction());
		Assert.assertEquals(
			"testInPlayText", hearthstoneCardModel.getInPlayText());
		Assert.assertEquals("testFlavor", hearthstoneCardModel.getFlavor());
		Assert.assertEquals("testArtist", hearthstoneCardModel.getArtist());
		Assert.assertEquals(true, hearthstoneCardModel.isElite());
		Assert.assertEquals("testHowToGet", hearthstoneCardModel.getHowToGet());
		Assert.assertEquals(
			"testHowToGetGold", hearthstoneCardModel.getHowToGetGold());
	}

}