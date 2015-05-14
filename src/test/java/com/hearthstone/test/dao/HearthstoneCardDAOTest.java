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

package com.hearthstone.test.dao;

import com.hearthstone.dao.HearthstoneCardDAO;
import com.hearthstone.dao.impl.HearthstoneCardDAOImpl;
import com.hearthstone.exception.DatabaseConnectionException;
import com.hearthstone.model.HearthstoneCardModel;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardDAOTest {

	@Test
	public void testHearthstoneCardDAO()
		throws DatabaseConnectionException, SQLException {

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

		_hearthstoneCardDAO.addHearthstoneCard(hearthstoneCardModel);

		HearthstoneCardModel databaseHearthstoneCardModel =
			_hearthstoneCardDAO.getHearthstoneCard("testId");

		Assert.assertEquals(
			databaseHearthstoneCardModel.getId(), hearthstoneCardModel.getId());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getSet(),
			hearthstoneCardModel.getSet());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getName(),
			hearthstoneCardModel.getName());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getCost(),
			hearthstoneCardModel.getCost());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getAttack(),
			hearthstoneCardModel.getAttack());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getHealth(),
			hearthstoneCardModel.getHealth());
		Assert.assertThat(
			databaseHearthstoneCardModel.getMechanics(),
			IsIterableContainingInOrder.contains(mechanics.toArray()));
		Assert.assertEquals(
			databaseHearthstoneCardModel.getText(),
			hearthstoneCardModel.getText());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getDurability(),
			hearthstoneCardModel.getDurability());
		Assert.assertEquals(
			databaseHearthstoneCardModel.isCollectible(),
			hearthstoneCardModel.isCollectible());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getType(),
			hearthstoneCardModel.getType());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getRarity(),
			hearthstoneCardModel.getRarity());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getPlayerClass(),
			hearthstoneCardModel.getPlayerClass());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getRace(),
			hearthstoneCardModel.getRace());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getFaction(),
			hearthstoneCardModel.getFaction());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getInPlayText(),
			hearthstoneCardModel.getInPlayText());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getFlavor(),
			hearthstoneCardModel.getFlavor());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getArtist(),
			hearthstoneCardModel.getArtist());
		Assert.assertEquals(
			databaseHearthstoneCardModel.isElite(),
			hearthstoneCardModel.isElite());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getHowToGet(),
			hearthstoneCardModel.getHowToGet());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getHowToGetGold(),
			hearthstoneCardModel.getHowToGetGold());

		List<HearthstoneCardModel> databaseHearthstoneCardModels =
			_hearthstoneCardDAO.getAllHearthstoneCards();

		Assert.assertEquals(1, databaseHearthstoneCardModels.size());

		databaseHearthstoneCardModel = databaseHearthstoneCardModels.get(0);

		Assert.assertEquals(
			databaseHearthstoneCardModel.getId(), hearthstoneCardModel.getId());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getSet(),
			hearthstoneCardModel.getSet());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getName(),
			hearthstoneCardModel.getName());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getCost(),
			hearthstoneCardModel.getCost());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getAttack(),
			hearthstoneCardModel.getAttack());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getHealth(),
			hearthstoneCardModel.getHealth());
		Assert.assertThat(
			databaseHearthstoneCardModel.getMechanics(),
			IsIterableContainingInOrder.contains(mechanics.toArray()));
		Assert.assertEquals(
			databaseHearthstoneCardModel.getText(),
			hearthstoneCardModel.getText());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getDurability(),
			hearthstoneCardModel.getDurability());
		Assert.assertEquals(
			databaseHearthstoneCardModel.isCollectible(),
			hearthstoneCardModel.isCollectible());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getType(),
			hearthstoneCardModel.getType());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getRarity(),
			hearthstoneCardModel.getRarity());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getPlayerClass(),
			hearthstoneCardModel.getPlayerClass());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getRace(),
			hearthstoneCardModel.getRace());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getFaction(),
			hearthstoneCardModel.getFaction());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getInPlayText(),
			hearthstoneCardModel.getInPlayText());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getFlavor(),
			hearthstoneCardModel.getFlavor());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getArtist(),
			hearthstoneCardModel.getArtist());
		Assert.assertEquals(
			databaseHearthstoneCardModel.isElite(),
			hearthstoneCardModel.isElite());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getHowToGet(),
			hearthstoneCardModel.getHowToGet());
		Assert.assertEquals(
			databaseHearthstoneCardModel.getHowToGetGold(),
			hearthstoneCardModel.getHowToGetGold());

		int hearthstoneCardCount =
			_hearthstoneCardDAO.getHearthstoneCardCount();

		Assert.assertEquals(1, hearthstoneCardCount);

		_hearthstoneCardDAO.deleteHearthstoneCard("testId");

		hearthstoneCardCount = _hearthstoneCardDAO.getHearthstoneCardCount();

		Assert.assertEquals(0, hearthstoneCardCount);
	}

	private static final HearthstoneCardDAO _hearthstoneCardDAO =
		new HearthstoneCardDAOImpl();

}