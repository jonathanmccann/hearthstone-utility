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

package com.hearthstone.test.dao;

import com.hearthstone.dao.ReleaseDAO;
import com.hearthstone.dao.impl.ReleaseDAOImpl;
import com.hearthstone.exception.DatabaseConnectionException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author Jonathan McCann
 */
public class ReleaseDAOTest {

	@Test
	public void testReleaseDAO()
		throws DatabaseConnectionException, SQLException {

		_releaseDAO.addRelease("4.0.1");

		Assert.assertEquals("4.0.1", _releaseDAO.getRelease());

		_releaseDAO.updateRelease("4.0.1", "4.0.2");

		Assert.assertEquals("4.0.2", _releaseDAO.getRelease());
	}

	private static final ReleaseDAO _releaseDAO = new ReleaseDAOImpl();
}