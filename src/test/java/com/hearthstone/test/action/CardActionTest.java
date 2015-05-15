/**
 * Copyright (c) 2015-present Jonathan McCann
 * <p/>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */

package com.hearthstone.test.action;

import com.hearthstone.action.Action;
import com.hearthstone.action.impl.CardActionImpl;
import com.hearthstone.dao.HearthstoneCardDAO;
import com.hearthstone.dao.impl.HearthstoneCardDAOImpl;
import com.hearthstone.model.HearthstoneCardModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan McCann
 */
public class CardActionTest {

	@Before
	public void setUp() throws Exception {
		_clazz = Class.forName(CardActionImpl.class.getName());

		_classInstance = _clazz.newInstance();

		insertHearthstoneCardModel();
	}

	@After
	public void tearDown() throws Exception {
		_hearthstoneCardDAO.deleteHearthstoneCard("testId");
	}

	@Test
	public void testExecute() throws Exception {
		_cardAction.execute("testName");

		Method method = _clazz.getDeclaredMethod(
			"findHearthstoneCardByName", String.class);

		method.setAccessible(true);

		List<HearthstoneCardModel> hearthstoneCardModels =
			(List<HearthstoneCardModel>)method.invoke(
				_classInstance, "testName");

		Assert.assertEquals(1, hearthstoneCardModels.size());

		hearthstoneCardModels =
			(List<HearthstoneCardModel>)method.invoke(
				_classInstance, "test");

		Assert.assertEquals(1, hearthstoneCardModels.size());

		hearthstoneCardModels =
			(List<HearthstoneCardModel>)method.invoke(
				_classInstance, "name");

		Assert.assertEquals(1, hearthstoneCardModels.size());

		hearthstoneCardModels =
			(List<HearthstoneCardModel>)method.invoke(
				_classInstance, "stna");

		Assert.assertEquals(1, hearthstoneCardModels.size());

		hearthstoneCardModels =
			(List<HearthstoneCardModel>)method.invoke(
				_classInstance, "doesNotExist");

		Assert.assertEquals(0, hearthstoneCardModels.size());
	}

	private static void insertHearthstoneCardModel() throws Exception {
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
	}

	private static Object _classInstance;
	private static Class _clazz;

	private static final Action _cardAction = new CardActionImpl();

	private static final HearthstoneCardDAO _hearthstoneCardDAO =
		new HearthstoneCardDAOImpl();

}