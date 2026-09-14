CREATE TABLE users (
                       id                              BIGSERIAL PRIMARY KEY,
                       email                           VARCHAR(255) NOT NULL UNIQUE,
                       phone                           VARCHAR(30) UNIQUE,
                       password_hash                   VARCHAR(255) NOT NULL,
                       fullname                        VARCHAR(255) NOT NULL,
                       role                            VARCHAR(20) NOT NULL,
                       is_verified                     BOOLEAN NOT NULL DEFAULT FALSE,
                       otp_hash                        VARCHAR(255),
                       otp_expires_at                  TIMESTAMP,
                       otp_attempts                    SMALLINT NOT NULL DEFAULT 0,
                       reset_password_otp_hash         TIMESTAMP,
                       reset_password_otp_expires_at   TIMESTAMP,
                       reset_password_otp_attempts     SMALLINT NOT NULL DEFAULT 0,
                       created_at                      TIMESTAMP NOT NULL DEFAULT now(),
                       updated_at                      TIMESTAMP NOT NULL DEFAULT now()
);