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

package com.hearthstone.action.impl;

import com.hearthstone.action.Action;
import com.hearthstone.dao.HearthstoneCardDAO;
import com.hearthstone.dao.impl.HearthstoneCardDAOImpl;
import com.hearthstone.exception.DatabaseConnectionException;
import com.hearthstone.model.HearthstoneCardModel;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Jonathan McCann
 */
public class CardActionImpl implements Action {

	@Override
	public void execute(String input)
		throws DatabaseConnectionException, SQLException {

		List<HearthstoneCardModel> hearthstoneCardModels =
			_hearthstoneCardDAO.getHearthstoneCardByName(input);

		for (HearthstoneCardModel hearthstoneCardModel :
				hearthstoneCardModels) {

			System.out.println("Name - " + hearthstoneCardModel.getName());
			System.out.println("Cost - " + hearthstoneCardModel.getCost());
			System.out.println("Attack - " + hearthstoneCardModel.getAttack());
			System.out.println("Health - " + hearthstoneCardModel.getHealth());
			System.out.println();
		}
	}

	private static final HearthstoneCardDAO _hearthstoneCardDAO =
		new HearthstoneCardDAOImpl();
}