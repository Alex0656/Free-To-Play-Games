CREATE TABLE users (
    email varchar(255) NOT NULL CONSTRAINT users_pkey PRIMARY KEY,
    name varchar(255),
    password varchar(255),
    authority varchar(255)
);

ALTER TABLE users
    OWNER TO games_dev,
    ADD CONSTRAINT  proper_email
        CHECK ( email ~* '^[A-Za-z0-9._+%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$'),
    ADD CONSTRAINT proper_password
        CHECK ( password <> ''),
    ADD CONSTRAINT proper_role
        CHECK ( authority IN ('ADMIN', 'SUPER_ADMIN'));

CREATE VIEW super_admins AS
    SELECT * FROM users WHERE users.authority LIKE '%SUPER_ADMIN%'
