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

package com.hearthstone.util;

import com.hearthstone.exception.DatabaseConnectionException;

import java.nio.charset.StandardCharsets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.RunScript;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jonathan McCann
 */
public class DatabaseUtil {

	public static Connection getDatabaseConnection()
		throws DatabaseConnectionException {

		try {
			Class.forName("org.h2.Driver");

			return DriverManager.getConnection(_databaseURL);
		}
		catch (ClassNotFoundException | SQLException exception) {
			_log.error(
				"Could not get a database connection. Please check your " +
					"database settings in 'config.properties'");

			throw new DatabaseConnectionException(exception);
		}
	}

	public static void initializeDatabase() throws SQLException {
		RunScript.execute(
			_databaseURL, null, null, _databaseFile, StandardCharsets.UTF_8,
			false);
	}

	public static void setDatabaseFile(String databaseFile) {
		_databaseFile = databaseFile;
	}

	public static void setDatabaseURL(String databaseURL) {
		_databaseURL = databaseURL;
	}

	private static final Logger _log = LoggerFactory.getLogger(
		DatabaseUtil.class);

	private static String _databaseFile =
		"src/main/resources/sql/hearthstone.sql";
	private static String _databaseURL =
		"jdbc:h2:file:./db/hearthstone;MV_STORE=FALSE;IGNORECASE=TRUE";

}