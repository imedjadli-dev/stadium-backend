CREATE TABLE reservations (
                              id          BIGSERIAL PRIMARY KEY,
                              user_id     BIGINT NOT NULL REFERENCES users(id),
                              stadium_id  BIGINT NOT NULL REFERENCES stadiums(id),
                              date        DATE NOT NULL,
                              start_time  TIME NOT NULL,
                              end_time    TIME NOT NULL,
                              price       NUMERIC(10,2) NOT NULL,
                              status      VARCHAR(20) NOT NULL DEFAULT 'PENDING',
                              version     INT NOT NULL DEFAULT 0,
                              created_at  TIMESTAMP NOT NULL DEFAULT now(),
                              updated_at  TIMESTAMP NOT NULL DEFAULT now(),
                              CONSTRAINT uq_reservation_slot UNIQUE (stadium_id, date, start_time)
);
CREATE INDEX idx_reservations_stadium_date ON reservations(stadium_id, date);
CREATE INDEX idx_reservations_user_id ON reservations(user_id);