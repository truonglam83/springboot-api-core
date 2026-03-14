INSERT INTO test (username, created_by, updated_by)
VALUES
    ('admin', 1, 1),
    ('john_doe', 1, 1),
    ('jane_doe', 1, 1)
    ON CONFLICT (username) DO NOTHING;