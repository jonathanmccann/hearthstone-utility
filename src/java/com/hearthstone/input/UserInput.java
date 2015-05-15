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

package com.hearthstone.input;

import com.hearthstone.action.Action;
import com.hearthstone.action.impl.CardActionImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Jonathan McCann
 */
public class UserInput {

	public static void receiveUserInput() {
		initializeActionMap();

		Scanner scanner = new Scanner(System.in);

		for (userPrompt(); scanner.hasNextLine(); userPrompt()) {
			String line = scanner.nextLine();

			Action action = actionMap.get(line);

			if (action != null) {
				action.execute("test");
			}
		}
	}

	private static void initializeActionMap() {
		actionMap.put("card", new CardActionImpl());
	}

	private static void userPrompt() {
		System.out.print(">> ");
	}

	private static final Map<String, Action> actionMap = new HashMap<>();

}