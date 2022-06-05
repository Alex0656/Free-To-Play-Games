CREATE TABLE IF NOT EXISTS trading_floors (
    name varchar,
    img bytea
);

ALTER TABLE trading_floors
    OWNER TO games_dev,
    ADD CONSTRAINT trading_floors_pkey
        PRIMARY KEY (name),
    ADD CONSTRAINT proper_name
        CHECK ( name <> '' )
