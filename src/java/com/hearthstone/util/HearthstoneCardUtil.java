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
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.hearthstone.dao.HearthstoneCardDAO;
import com.hearthstone.dao.impl.HearthstoneCardDAOImpl;
import com.hearthstone.model.HearthstoneCardModel;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardUtil {

	public static List<HearthstoneCardModel> getHearthstoneCardJson(
			JsonParser jsonParser)
		throws IOException {

		List<HearthstoneCardModel> hearthstoneCardModels = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper();

		jsonParser.nextToken();

		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			String set = jsonParser.getCurrentName();

			jsonParser.nextToken();

			while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
				HearthstoneCardModel hearthstoneCardModel = mapper.readValue(
					jsonParser, HearthstoneCardModel.class);

				hearthstoneCardModel.setSet(set);

				hearthstoneCardModels.add(hearthstoneCardModel);
			}
		}

		jsonParser.close();

		return hearthstoneCardModels;
	}

	public static List<HearthstoneCardModel> getHearthstoneCardJsonFromURL()
		throws IOException {

		JsonFactory jsonFactory = new JsonFactory();

		JsonParser jsonParser = jsonFactory.createParser(
			new URL(_HEARTHSTONE_CARD_JSON_URL));

		return getHearthstoneCardJson(jsonParser);
	}

	public static List<HearthstoneCardModel> getHearthstoneCardJsonFromFile()
		throws IOException {

		JsonFactory jsonFactory = new JsonFactory();

		JsonParser jsonParser = jsonFactory.createParser(
			new File(_HEARTHSTONE_CARD_JSON_FILE));

		return getHearthstoneCardJson(jsonParser);
	}

	public static void populateHearthstoneCardDatabaseFromFile()
		throws Exception {

		if (ReleaseUtil.isLatestVersion(
				ReleaseUtil.getLatestReleaseVersionFromFile())) {

			return;
		}

		List<HearthstoneCardModel> hearthstoneCardModels =
			getHearthstoneCardJsonFromFile();

		_hearthstoneCardDAO.addHearthstoneCards(hearthstoneCardModels);

		ReleaseUtil.updateReleaseVersionFromFile();
	}

	public static void populateHearthstoneCardDatabaseFromURL()
		throws Exception {

		if (ReleaseUtil.isLatestVersion(
				ReleaseUtil.getLatestReleaseVersionFromURL())) {

			return;
		}

		List<HearthstoneCardModel> hearthstoneCardModels =
			getHearthstoneCardJsonFromURL();

		_hearthstoneCardDAO.addHearthstoneCards(hearthstoneCardModels);

		ReleaseUtil.updateReleaseVersionFromURL();
	}

	public static void setHearthstoneCardJsonFile(
		String hearthstoneCardJsonFile) {

		_HEARTHSTONE_CARD_JSON_FILE = hearthstoneCardJsonFile;
	}

	public static void setHearthstoneCardJsonURL(
		String hearthstoneCardJsonURL) {

		_HEARTHSTONE_CARD_JSON_URL = hearthstoneCardJsonURL;
	}

	private static final HearthstoneCardDAO _hearthstoneCardDAO =
		new HearthstoneCardDAOImpl();

	private static String _HEARTHSTONE_CARD_JSON_FILE =
		"src/main/resources/AllSets.json";

	private static String _HEARTHSTONE_CARD_JSON_URL =
		"http://www.hearthstonejson.com/json/AllSets.json";

}