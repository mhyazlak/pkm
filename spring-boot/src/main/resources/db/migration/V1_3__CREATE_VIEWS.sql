CREATE VIEW Pokemon_VIEW AS
    SELECT p.*,
           (base_hp + base_atk + base_def + base_spa + base_spd + base_spe) as base_total
    FROM Pokemon p;
