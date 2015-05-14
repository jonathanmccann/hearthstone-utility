CREATE TABLE IF NOT EXISTS HearthstoneCard (
	id VARCHAR(100) NOT NULL PRIMARY KEY,
	set VARCHAR(100) null,
	name VARCHAR(100) null,
	cost INT null,
	attack INT null,
	health INT null,
	mechanics VARCHAR(250) null,
	text VARCHAR(250) null,
	durability INT null,
	collectible BOOLEAN null,
	type VARCHAR(100) null,
	rarity VARCHAR(100) null,
	playerClass VARCHAR(100) null,
	race VARCHAR(100) null,
	faction VARCHAR(100) null,
	inPlayText VARCHAR(250) null,
	flavor VARCHAR(250) null,
	artist VARCHAR(100) null,
	elite BOOLEAN null,
	howToGet VARCHAR(250) null,
	howToGetGold VARCHAR(250) null
);

CREATE TABLE IF NOT EXISTS Release (
	version DOUBLE NOT NULL PRIMARY KEY,
);