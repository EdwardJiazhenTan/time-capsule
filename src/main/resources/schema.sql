CREATE TABLE IF NOT EXISTS time_capsules (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    scheduled_send_date TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sent_at TIMESTAMP,
    user_id BIGINT  -- NULL for MVP, will link to users table later
);

-- Index for scheduler performance
CREATE INDEX IF NOT EXISTS idx_status_scheduled
ON time_capsules(status, scheduled_send_date);
