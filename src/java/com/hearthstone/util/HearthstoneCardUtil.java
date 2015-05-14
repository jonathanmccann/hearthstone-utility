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

import java.io.File;
import java.io.IOException;

/**
 * @author Jonathan McCann
 */
public class HearthstoneCardUtil {

	public static void getHearthstoneCardJson() throws IOException {
		JsonFactory jsonFactory = new JsonFactory();

		JsonParser jsonParser = jsonFactory.createParser(
			new File(_HEARTHSTONE_CARD_JSON));

		jsonParser.nextToken();

		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			String cardSet = jsonParser.getCurrentName();

			jsonParser.nextToken();

			while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
				while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
					String key = jsonParser.getText();

					jsonParser.nextToken();

					String value = jsonParser.getText();

					if (key.equalsIgnoreCase("mechanics")) {
						while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
							System.out.println(
								key + " - " + jsonParser.getText());
						}
					}
					else {
						System.out.println(key + " - " + value);
					}
				}

				System.out.println();
			}
		}

		jsonParser.close();
	}

	private static final String _HEARTHSTONE_CARD_JSON =
		"src/main/resources/AllSets.json";
}