-- =============================
-- ADD COLUMNS IF NOT EXISTS
-- =============================

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS is_deleted BOOLEAN NOT NULL DEFAULT FALSE;

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS created_by BIGINT;

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS updated_by BIGINT;

-- =============================
-- INDEX (optional but recommended)
-- =============================

CREATE INDEX IF NOT EXISTS idx_users_is_deleted ON users(is_deleted);