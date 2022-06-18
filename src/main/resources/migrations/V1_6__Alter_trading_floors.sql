DELETE FROM trading_floors;

ALTER TABLE trading_floors
    DROP CONSTRAINT trading_floors_pkey;

ALTER TABLE trading_floors
    RENAME COLUMN name TO id;

ALTER TABLE trading_floors
    ADD COLUMN name varchar NOT NULL;

ALTER TABLE trading_floors
    ADD CONSTRAINT trading_floors_pkey PRIMARY KEY (id);