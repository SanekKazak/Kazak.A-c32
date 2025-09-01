CREATE TABLE users
(
    id          UUID NOT NULL,
    username    VARCHAR(255) UNIQUE,
    password    VARCHAR(255),
    authorities TEXT[],
    CONSTRAINT pk_users PRIMARY KEY (id)
);