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

import com.hearthstone.dao.ReleaseDAO;
import com.hearthstone.exception.DatabaseConnectionException;
import com.hearthstone.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jonathan McCann
 */
public class ReleaseDAOImpl implements ReleaseDAO {

	@Override
	public void addRelease(String releaseVersion)
		throws DatabaseConnectionException, SQLException {

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_ADD_RELEASE_SQL)) {

			preparedStatement.setString(1, releaseVersion);

			preparedStatement.executeUpdate();
		}
	}

	@Override
	public String getRelease()
		throws DatabaseConnectionException, SQLException {

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_GET_RELEASE_SQL)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return(resultSet.getString("version"));
				}
				else {
					return null;
				}
			}
		}
	}

	@Override
	public void updateRelease(
			String previousReleaseVersion, String releaseVersion)
		throws DatabaseConnectionException, SQLException {

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_UPDATE_RELEASE_SQL)) {

			preparedStatement.setString(1, releaseVersion);
			preparedStatement.setString(2, previousReleaseVersion);

			preparedStatement.executeUpdate();
		}
	}

	private static final String _ADD_RELEASE_SQL =
		"INSERT INTO Release(version) VALUES(?)";

	private static final String _GET_RELEASE_SQL = "SELECT * FROM Release";

	private static final String _UPDATE_RELEASE_SQL =
		"UPDATE Release SET version = ? WHERE version = ?";
}