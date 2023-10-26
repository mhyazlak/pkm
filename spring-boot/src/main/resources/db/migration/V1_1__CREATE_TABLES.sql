CREATE TABLE Pokemon (
    id                    BIGINT auto_increment NOT NULL,
    name                  VARCHAR(25) NOT NULL,
    type_one              ENUM(
                              'NORMAL', 'FIRE', 'WATER', 'ELECTRIC', 'GRASS', 'ICE',
                              'FIGHTING', 'POISON', 'GROUND', 'FLYING', 'PSYCHIC', 'BUG',
                              'ROCK', 'GHOST', 'DARK', 'DRAGON', 'STEEL', 'FAIRY'
                           ),
    type_two              ENUM(
                              'NORMAL', 'FIRE', 'WATER', 'ELECTRIC', 'GRASS', 'ICE',
                              'FIGHTING', 'POISON', 'GROUND', 'FLYING', 'PSYCHIC', 'BUG',
                              'ROCK', 'GHOST', 'DARK', 'DRAGON', 'STEEL', 'FAIRY'
                           ) NULL,
    base_hp               INT NOT NULL,
    base_atk              INT NOT NULL,
    base_def              INT NOT NULL,
    base_spa              INT NOT NULL,
    base_spd              INT NOT NULL,
    base_spe              INT NOT NULL,
    pokemon_display_sprite VARCHAR(200) NOT NULL,
    pokemon_icon_b64 TEXT,
    PRIMARY KEY (id)
);
