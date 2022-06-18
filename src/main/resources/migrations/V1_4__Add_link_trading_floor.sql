DELETE FROM trading_floors;
--    WHERE trading_floors.name IN (SELECT trading_floors.name FROM trading_floors);

ALTER TABLE trading_floors
    ADD COLUMN link varchar NOT NULL;