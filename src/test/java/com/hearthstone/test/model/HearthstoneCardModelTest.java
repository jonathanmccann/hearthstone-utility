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
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardModelTest {

	@Test
	public void testGettersAndSetters() {
		HearthstoneCardModel hearthstoneCardModel = new HearthstoneCardModel();

		hearthstoneCardModel.setArtist("testArtist");
		hearthstoneCardModel.setAttack(1);
		hearthstoneCardModel.setName("testName");
		hearthstoneCardModel.setSet("testSet");
		hearthstoneCardModel.setType("testType");
		hearthstoneCardModel.setCollectible(true);
		hearthstoneCardModel.setCost(1);
		hearthstoneCardModel.setDurability(1);
		hearthstoneCardModel.setElite(true);
		hearthstoneCardModel.setFaction("testFaction");
		hearthstoneCardModel.setFlavor("testFlavor");
		hearthstoneCardModel.setHealth(1);
		hearthstoneCardModel.setHowToGet("testHowToGet");
		hearthstoneCardModel.setHowToGetGold("testHowToGetGold");
		hearthstoneCardModel.setId("testId");
		hearthstoneCardModel.setInPlayText("testInPlayText");

		List<String> mechanics = new ArrayList<>();

		mechanics.add("testFirstMechanic");
		mechanics.add("testSecondMechanic");

		hearthstoneCardModel.setMechanics(mechanics);
		hearthstoneCardModel.setPlayerClass("testPlayerClass");
		hearthstoneCardModel.setRace("testRace");
		hearthstoneCardModel.setRarity("testRarity");
		hearthstoneCardModel.setText("testText");

		Assert.assertEquals(hearthstoneCardModel.getArtist(), "testArtist");
		Assert.assertEquals(hearthstoneCardModel.getAttack(), 1);
		Assert.assertEquals(hearthstoneCardModel.getName(), "testName");
		Assert.assertEquals(hearthstoneCardModel.getSet(), "testSet");
		Assert.assertEquals(hearthstoneCardModel.getType(), "testType");
		Assert.assertEquals(hearthstoneCardModel.isCollectible(), true);
		Assert.assertEquals(hearthstoneCardModel.getCost(), 1);
		Assert.assertEquals(hearthstoneCardModel.getDurability(), 1);
		Assert.assertEquals(hearthstoneCardModel.isElite(), true);
		Assert.assertEquals(hearthstoneCardModel.getFaction(), "testFaction");
		Assert.assertEquals(hearthstoneCardModel.getFlavor(), "testFlavor");
		Assert.assertEquals(hearthstoneCardModel.getHealth(), 1);
		Assert.assertEquals(hearthstoneCardModel.getHowToGet(), "testHowToGet");
		Assert.assertEquals(
			hearthstoneCardModel.getHowToGetGold(), "testHowToGetGold");
		Assert.assertEquals(hearthstoneCardModel.getId(), "testId");
		Assert.assertEquals(
			hearthstoneCardModel.getInPlayText(), "testInPlayText");
		Assert.assertEquals(hearthstoneCardModel.getMechanics().size(), 2);
		Assert.assertEquals(
			hearthstoneCardModel.getPlayerClass(), "testPlayerClass");
		Assert.assertEquals(hearthstoneCardModel.getRace(), "testRace");
		Assert.assertEquals(hearthstoneCardModel.getRarity(), "testRarity");
		Assert.assertEquals(hearthstoneCardModel.getText(), "testText");
	}

}