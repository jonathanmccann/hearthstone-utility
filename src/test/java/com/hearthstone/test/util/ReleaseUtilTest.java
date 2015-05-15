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
import com.hearthstone.util.ReleaseUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Jonathan McCann
 */
public class ReleaseUtilTest {

	@Before
	public void setUp()
		throws DatabaseConnectionException, IOException, SQLException {

		ReleaseUtil.setHearthstoneCardJsonVersionFile(
			"src/test/resources/version.json");
		ReleaseUtil.updateReleaseVersionFromFile();
	}

	@Test
	public void testGetRelease()
		throws DatabaseConnectionException, SQLException {

		Assert.assertEquals("4.0.1", ReleaseUtil.getRelease());
	}

	@Test
	public void testIsLatestVersion()
		throws DatabaseConnectionException, SQLException, IOException {

		Assert.assertFalse(ReleaseUtil.isLatestVersion("4.0.0"));
		Assert.assertTrue(ReleaseUtil.isLatestVersion("4.0.1"));
		Assert.assertTrue(ReleaseUtil.isLatestVersion(
			ReleaseUtil.getLatestReleaseVersionFromFile()));
	}
}