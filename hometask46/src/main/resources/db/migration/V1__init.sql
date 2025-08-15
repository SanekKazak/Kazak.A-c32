CREATE TABLE courses(
    id        UUID NOT NULL,
    name      VARCHAR(255),
    lifecycle INTEGER,
    cost      DECIMAL,
    is_active BOOLEAN,
    CONSTRAINT pk_courses PRIMARY KEY (id)
);