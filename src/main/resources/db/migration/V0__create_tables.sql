DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS quotation;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS job;
CREATE TABLE invoice (id BIGINT AUTO_INCREMENT,data TINYBLOB NOT NULL,filename VARCHAR(30),file_type VARCHAR(30),PRIMARY KEY (id));
CREATE TABLE quotation (id BIGINT AUTO_INCREMENT,data TINYBLOB NOT NULL,filename VARCHAR(30),file_type VARCHAR(30),PRIMARY KEY (id));
CREATE TABLE customer (id BIGINT AUTO_INCREMENT,first_name VARCHAR(30),last_name VARCHAR(30),phone_number VARCHAR(30),email_address VARCHAR(30),PRIMARY KEY (id));
CREATE TABLE job (id BIGINT AUTO_INCREMENT,customer_id BIGINT,street VARCHAR(30),city VARCHAR(30),postcode VARCHAR(30),job_status VARCHAR(30),CHECK (job_status IN ('REJECTED', 'PENDING', 'IN_PROGRESS', 'COMPLETE')),price NUMERIC(19, 2),quotation_id BIGINT,invoice_id BIGINT,PRIMARY KEY (id),FOREIGN KEY (customer_id) REFERENCES customer(id),FOREIGN KEY (quotation_id) REFERENCES quotation(id),FOREIGN KEY (invoice_id) REFERENCES invoice(id));