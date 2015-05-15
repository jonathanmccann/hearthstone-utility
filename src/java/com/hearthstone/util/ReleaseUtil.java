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

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.hearthstone.dao.ReleaseDAO;
import com.hearthstone.dao.impl.ReleaseDAOImpl;
import com.hearthstone.exception.DatabaseConnectionException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

/**
 * @author Jonathan McCann
 */
public class ReleaseUtil {

	public static boolean isLatestVersion(String latestReleaseVersion)
		throws IOException, DatabaseConnectionException, SQLException {

		String releaseVersion = getRelease();

		if ((releaseVersion != null) &&
			releaseVersion.equals(latestReleaseVersion)) {

			return true;
		}

		return false;
	}

	public static String getRelease()
		throws DatabaseConnectionException, SQLException {

		return _releaseDAO.getRelease();
	}

	public static String getLatestReleaseVersionFromFile() throws IOException {
		JsonFactory jsonFactory = new JsonFactory();

		JsonParser jsonParser = jsonFactory.createParser(
			new File(_HEARTHSTONE_CARD_JSON_VERSION_FILE));

		return getLatestReleaseVersion(jsonParser);
	}

	public static String getLatestReleaseVersionFromURL() throws IOException {
		JsonFactory jsonFactory = new JsonFactory();

		JsonParser jsonParser = jsonFactory.createParser(
			new URL(_HEARTHSTONE_CARD_JSON_VERSION_URL));

		return getLatestReleaseVersion(jsonParser);
	}

	public static void updateReleaseVersionFromFile()
		throws IOException, DatabaseConnectionException, SQLException {

		updateReleaseVersion(getLatestReleaseVersionFromFile());
	}

	public static void updateReleaseVersionFromURL()
		throws IOException, DatabaseConnectionException, SQLException {

		updateReleaseVersion(getLatestReleaseVersionFromURL());
	}

	private static String getLatestReleaseVersion(JsonParser jsonParser)
		throws IOException {

		jsonParser.nextToken();
		jsonParser.nextToken();
		jsonParser.nextToken();

		return jsonParser.getText();
	}

	public static void setHearthstoneCardJsonVersionFile(
		String hearthstoneCardJsonVersionFile) {

		_HEARTHSTONE_CARD_JSON_VERSION_FILE = hearthstoneCardJsonVersionFile;
	}

	public static void setHearthstoneCardJsonVersionURL(
		String hearthstoneCardJsonVersionURL) {

		_HEARTHSTONE_CARD_JSON_VERSION_URL = hearthstoneCardJsonVersionURL;
	}

	public static void updateReleaseVersion(String latestReleaseVersion)
		throws DatabaseConnectionException, SQLException {

		String previousReleaseVersion = getRelease();

		if ((previousReleaseVersion == null) ||
			(previousReleaseVersion.equals(""))) {

			_releaseDAO.addRelease(latestReleaseVersion);
		}
		else {
			_releaseDAO.updateRelease(
				previousReleaseVersion, latestReleaseVersion);
		}
	}

	private static final ReleaseDAO _releaseDAO =
		new ReleaseDAOImpl();

	private static String _HEARTHSTONE_CARD_JSON_VERSION_FILE =
		"src/main/resources/version.json";

	private static String _HEARTHSTONE_CARD_JSON_VERSION_URL =
		"http://www.hearthstonejson.com/json/version.json";

}