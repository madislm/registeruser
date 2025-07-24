DROP TABLE IF EXISTS user_sector;
DROP TABLE IF EXISTS sector;
DROP TABLE IF EXISTS "user";

CREATE TABLE sector(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    parent_id INT REFERENCES sector(id)
);

CREATE TABLE "user"(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    agreed_to_terms BOOL NOT NULL
);

CREATE TABLE user_sector(
    user_id INT REFERENCES "user"(id),
    sector_id INT REFERENCES sector(id)
);