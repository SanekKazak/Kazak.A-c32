CREATE TABLE hotels
(
    id          UUID NOT NULL,
    place_count INTEGER,
    name        VARCHAR(255),
    CONSTRAINT pk_hotels PRIMARY KEY (id)
);