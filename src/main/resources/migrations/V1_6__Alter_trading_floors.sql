DELETE FROM trading_floors;

ALTER TABLE discounts
    DROP CONSTRAINT trading_floor_fkey;

ALTER TABLE trading_floors
    DROP CONSTRAINT trading_floors_pkey;

ALTER TABLE trading_floors
    RENAME COLUMN name TO id;

ALTER TABLE trading_floors
    ADD COLUMN name varchar NOT NULL;

ALTER TABLE trading_floors
    ADD CONSTRAINT trading_floors_pkey PRIMARY KEY (id);

ALTER TABLE discounts
    ADD CONSTRAINT trading_floor_fkey FOREIGN KEY (trading_floor_id) REFERENCES trading_floors(id);;