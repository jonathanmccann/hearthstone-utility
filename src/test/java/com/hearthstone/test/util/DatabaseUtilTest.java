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

package com.hearthstone.test.util;

import com.hearthstone.exception.DatabaseConnectionException;
import com.hearthstone.util.DatabaseUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Jonathan McCann
 */
public class DatabaseUtilTest {

	@Test
	public void testGetDatabaseConnection() throws DatabaseConnectionException{
		Connection connection = DatabaseUtil.getDatabaseConnection();

		Assert.assertNotNull(connection);
	}

	@Test
	public void testInitializeDatabase() throws SQLException {
		DatabaseUtil.initializeDatabase();
	}

}