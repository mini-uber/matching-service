CREATE TABLE matching
(
    id        BIGINT NOT NULL,
    user_id   BIGINT NULL,
    driver_id BIGINT NULL,
    CONSTRAINT pk_matching PRIMARY KEY (id)
);