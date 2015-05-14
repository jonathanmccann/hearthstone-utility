CREATE TABLE IF NOT EXISTS HearthstoneCard (
	id VARCHAR(100) NOT NULL PRIMARY KEY,
	set VARCHAR(100) null,
	name VARCHAR(100) null,
	cost INT null,
	attack INT null,
	health INT null,
	mechanics VARCHAR(100) null,
	text VARCHAR(100) null,
	durability INT null,
	collectible BOOLEAN null,
	type VARCHAR(100) null,
	rarity VARCHAR(100) null,
	playerClass VARCHAR(100) null,
	race VARCHAR(100) null,
	faction VARCHAR(100) null,
	inPlayText VARCHAR(100) null,
	flavor VARCHAR(100) null,
	artist VARCHAR(100) null,
	elite BOOLEAN null,
	howToGet VARCHAR(100) null,
	howToGetGold VARCHAR(100) null
);

CREATE TABLE IF NOT EXISTS Release (
	version DOUBLE NOT NULL PRIMARY KEY,
);