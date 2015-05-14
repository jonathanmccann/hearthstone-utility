CREATE TABLE IF NOT EXISTS HearthstoneCard (
	cardId LONG NOT NULL PRIMARY KEY,
	cardName VARCHAR(100) null,
	cardSet VARCHAR(100) null,
	cardType VARCHAR(100) null,
	cardRarity VARCHAR(100) null,
	cardCost VARCHAR(100) null,
	cardAttack VARCHAR(100) null,
	cardHealth VARCHAR(100) null,
	cardText VARCHAR(100) null,
	cardFlavor VARCHAR(100) null,
	cardMechanics VARCHAR(100) null
);

CREATE TABLE IF NOT EXISTS Release (
	version DOUBLE NOT NULL PRIMARY KEY,
);