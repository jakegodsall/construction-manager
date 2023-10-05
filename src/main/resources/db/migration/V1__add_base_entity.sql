ALTER TABLE customer
    ADD COLUMN created_date TIMESTAMP,
    ADD COLUMN last_modified_date TIMESTAMP;

ALTER TABLE job
    ADD COLUMN created_date TIMESTAMP,
    ADD COLUMN last_modified_date TIMESTAMP;