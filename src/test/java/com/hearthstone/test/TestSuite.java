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

package com.hearthstone.test;

import com.hearthstone.test.util.DatabaseUtilTest;
import com.hearthstone.util.DatabaseUtil;

import org.h2.tools.DeleteDbFiles;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jonathan McCann
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ DatabaseUtilTest.class })
public class TestSuite {

	@BeforeClass
	public static void setUp() {
		DatabaseUtil.setDatabaseFile(_databaseFile);
		DatabaseUtil.setDatabaseURL(_databaseURL);
	}

	@AfterClass
	public static void tearDown() {
		DeleteDbFiles.execute("./db", "testHearthstone", true);
	}

	private static String _databaseFile =
		"src/main/resources/sql/hearthstone.sql";
	private static String _databaseURL =
		"jdbc:h2:file:./db/testHearthstone;MV_STORE=FALSE";

}