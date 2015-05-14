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

package com.hearthstone.dao;

import com.hearthstone.exception.DatabaseConnectionException;
import com.hearthstone.model.HearthstoneCardModel;

import java.sql.SQLException;

import java.util.List;

/**
 * @author Jonathan McCann
 */
public interface HearthstoneCardDAO {

	public void addHearthstoneCard(HearthstoneCardModel hearthstoneCardModel)
		throws DatabaseConnectionException, SQLException;

	public void addHearthstoneCards(List<HearthstoneCardModel> hearthstoneCardModels)
		throws DatabaseConnectionException, SQLException;

	public void deleteHearthstoneCard(String id)
		throws DatabaseConnectionException, SQLException;

	public List<HearthstoneCardModel> getAllHearthstoneCards()
		throws DatabaseConnectionException, SQLException;

	public HearthstoneCardModel getHearthstoneCard(String id)
		throws DatabaseConnectionException, SQLException;

	public int getHearthstoneCardCount()
		throws DatabaseConnectionException, SQLException;

}