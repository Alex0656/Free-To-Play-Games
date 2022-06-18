CREATE TABLE IF NOT EXISTS discounts (
  id varchar NOT NULL,
  trading_floor_id varchar NOT NULL,
  description varchar
);

ALTER TABLE discounts
    ADD CONSTRAINT  discount_pkey PRIMARY KEY (id),
    ADD CONSTRAINT trading_floor_fkey FOREIGN KEY (trading_floor_id) REFERENCES trading_floors(name);