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

package com.hearthstone.dao.impl;

import com.hearthstone.dao.HearthstoneCardDAO;
import com.hearthstone.exception.DatabaseConnectionException;
import com.hearthstone.model.HearthstoneCardModel;
import com.hearthstone.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardDAOImpl implements HearthstoneCardDAO {

	@Override
	public void addHearthstoneCard(HearthstoneCardModel hearthstoneCardModel)
		throws DatabaseConnectionException, SQLException {

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_ADD_HEARTHSTONE_CARD_MODEL_SQL)) {

			populateAddHearthstoneCardModelPreparedStatement(
				preparedStatement, hearthstoneCardModel);

			preparedStatement.executeUpdate();
		}
	}

	@Override
	public void deleteHearthstoneCard(String id)
		throws DatabaseConnectionException, SQLException {

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_DELETE_HEARTHSTONE_CARD_SQL)) {

			preparedStatement.setString(1, id);

			preparedStatement.executeUpdate();
		}
	}

	@Override
	public List<HearthstoneCardModel> getAllHearthstoneCards()
		throws DatabaseConnectionException, SQLException {

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_GET_ALL_HEARTHSTONE_CARDS_SQL)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				List<HearthstoneCardModel> hearthstoneCardModels =
					new ArrayList<>();

				while (resultSet.next()) {
					hearthstoneCardModels.add(
						createHearthstoneCardModelFromResultSet(resultSet));
				}

				return hearthstoneCardModels;
			}
		}
	}

	@Override
	public HearthstoneCardModel getHearthstoneCard(String id)
		throws DatabaseConnectionException, SQLException {

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_GET_HEARTHSTONE_CARD_SQL)) {

			preparedStatement.setString(1, id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return(createHearthstoneCardModelFromResultSet(resultSet));
				}
				else {
					return null;
				}
			}
		}
	}

	@Override
	public int getHearthstoneCardCount()
		throws DatabaseConnectionException, SQLException {

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_GET_HEARTHSTONE_CARD_COUNT_SQL);
			ResultSet resultSet = preparedStatement.executeQuery()) {

			int hearthstoneCardCount = 0;

			while (resultSet.next()) {
				hearthstoneCardCount = resultSet.getInt(1);
			}

			return hearthstoneCardCount;
		}
	}

	private static List<String> convertMechanicsToList(String mechanics) {
		if ((mechanics == null) || (mechanics == "")) {
			return new ArrayList<String>();
		}

		String[] mechanicsArray = mechanics.split(",");

		return Arrays.asList(mechanicsArray);
	}

	private static String convertMechanicsToString(List<String> mechanics) {
		if ((mechanics == null) || (mechanics.isEmpty())) {
			return "";
		}

		int mechanicsSize = mechanics.size();

		StringBuilder stringBuilder = new StringBuilder(
			(mechanicsSize * 2) - 1);

		for (int i = 0; i < mechanicsSize; i++) {
			stringBuilder.append(mechanics.get(i));

			if ((i + 1) != mechanicsSize) {
				stringBuilder.append(",");
			}
		}

		return stringBuilder.toString();
	}

	private static HearthstoneCardModel createHearthstoneCardModelFromResultSet(
			ResultSet resultSet)
		throws SQLException {

		HearthstoneCardModel hearthstoneCardModel = new HearthstoneCardModel();

		hearthstoneCardModel.setId(resultSet.getString("id"));
		hearthstoneCardModel.setSet(resultSet.getString("set"));
		hearthstoneCardModel.setName(resultSet.getString("name"));
		hearthstoneCardModel.setCost(resultSet.getInt("cost"));
		hearthstoneCardModel.setAttack(resultSet.getInt("attack"));
		hearthstoneCardModel.setHealth(resultSet.getInt("health"));
		hearthstoneCardModel.setMechanics(
			convertMechanicsToList(resultSet.getString("mechanics")));
		hearthstoneCardModel.setText(resultSet.getString("text"));
		hearthstoneCardModel.setDurability(resultSet.getInt("durability"));
		hearthstoneCardModel.setCollectible(
			resultSet.getBoolean("collectible"));
		hearthstoneCardModel.setType(resultSet.getString("type"));
		hearthstoneCardModel.setRarity(resultSet.getString("rarity"));
		hearthstoneCardModel.setPlayerClass(resultSet.getString("playerClass"));
		hearthstoneCardModel.setRace(resultSet.getString("race"));
		hearthstoneCardModel.setFaction(resultSet.getString("faction"));
		hearthstoneCardModel.setInPlayText(resultSet.getString("inPlayText"));
		hearthstoneCardModel.setFlavor(resultSet.getString("flavor"));
		hearthstoneCardModel.setArtist(resultSet.getString("artist"));
		hearthstoneCardModel.setElite(resultSet.getBoolean("elite"));
		hearthstoneCardModel.setHowToGet(resultSet.getString("howToGet"));
		hearthstoneCardModel.setHowToGetGold(
			resultSet.getString("howToGetGold"));

		return hearthstoneCardModel;
	}

	private static void populateAddHearthstoneCardModelPreparedStatement(
			PreparedStatement preparedStatement,
			HearthstoneCardModel hearthstoneCardModel)
		throws SQLException {

		preparedStatement.setString(1, hearthstoneCardModel.getId());
		preparedStatement.setString(2, hearthstoneCardModel.getSet());
		preparedStatement.setString(3, hearthstoneCardModel.getName());
		preparedStatement.setInt(4, hearthstoneCardModel.getCost());
		preparedStatement.setInt(5, hearthstoneCardModel.getAttack());
		preparedStatement.setInt(6, hearthstoneCardModel.getHealth());
		preparedStatement.setString(
			7, convertMechanicsToString(hearthstoneCardModel.getMechanics()));
		preparedStatement.setString(8, hearthstoneCardModel.getText());
		preparedStatement.setInt(9, hearthstoneCardModel.getDurability());
		preparedStatement.setBoolean(10, hearthstoneCardModel.isCollectible());
		preparedStatement.setString(11, hearthstoneCardModel.getType());
		preparedStatement.setString(12, hearthstoneCardModel.getRarity());
		preparedStatement.setString(13, hearthstoneCardModel.getPlayerClass());
		preparedStatement.setString(14, hearthstoneCardModel.getRace());
		preparedStatement.setString(15, hearthstoneCardModel.getFaction());
		preparedStatement.setString(16, hearthstoneCardModel.getInPlayText());
		preparedStatement.setString(17, hearthstoneCardModel.getFlavor());
		preparedStatement.setString(18, hearthstoneCardModel.getArtist());
		preparedStatement.setBoolean(19, hearthstoneCardModel.isElite());
		preparedStatement.setString(20, hearthstoneCardModel.getHowToGet());
		preparedStatement.setString(21, hearthstoneCardModel.getHowToGetGold());
	}

	private static final String _ADD_HEARTHSTONE_CARD_MODEL_SQL =
		"INSERT INTO HearthstoneCard(id, set, name, cost, attack, health, " +
			"mechanics, text, durability, collectible, type, rarity, " +
				"playerClass, race, faction, inPlayText, flavor, artist, " +
					"elite, howToGet, howToGetGold) VALUES(?, ?, ?, ?, ?, ?, " +
						"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String _DELETE_HEARTHSTONE_CARD_SQL =
		"DELETE FROM HearthstoneCard WHERE id = ?";

	private static final String _GET_ALL_HEARTHSTONE_CARDS_SQL =
		"SELECT * FROM HearthstoneCard";

	private static final String _GET_HEARTHSTONE_CARD_COUNT_SQL =
		"SELECT COUNT(*) FROM HearthstoneCard";

	private static final String _GET_HEARTHSTONE_CARD_SQL =
		"SELECT * FROM HearthstoneCard where id = ?";

}