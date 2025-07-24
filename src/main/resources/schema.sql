DROP TABLE IF EXISTS sector;

CREATE TABLE sector(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    parent_id INT REFERENCES sector(id)
);