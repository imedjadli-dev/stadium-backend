CREATE TABLE stadiums (
                          id             BIGSERIAL PRIMARY KEY,
                          owner_id       BIGINT NOT NULL REFERENCES users(id),
                          title          VARCHAR(255) NOT NULL,
                          location       VARCHAR(255) NOT NULL,
                          price          NUMERIC(10,2) NOT NULL,
                          description    TEXT,
                          opening_time   TIME NOT NULL,
                          closing_time   TIME NOT NULL,
                          slot_duration  INT NOT NULL DEFAULT 60,
                          deleted_at     TIMESTAMP,
                          created_at     TIMESTAMP NOT NULL DEFAULT now(),
                          updated_at     TIMESTAMP NOT NULL DEFAULT now()
);
CREATE INDEX idx_stadiums_owner_id ON stadiums(owner_id);

CREATE TABLE stadium_equipments (
                                    stadium_id    BIGINT NOT NULL REFERENCES stadiums(id) ON DELETE CASCADE,
                                    equipment_id  BIGINT NOT NULL REFERENCES equipments(id) ON DELETE CASCADE,
                                    PRIMARY KEY (stadium_id, equipment_id)
);