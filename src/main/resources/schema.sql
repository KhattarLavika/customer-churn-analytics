CREATE TABLE IF NOT EXISTS customer
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

    customer_id VARCHAR(20) NOT NULL UNIQUE,
    gender VARCHAR(10) NOT NULL,
    senior_citizen BOOLEAN NOT NULL,
    partner BOOLEAN NOT NULL,
    dependents BOOLEAN NOT NULL,
    tenure INTEGER NOT NULL,

    phone_service BOOLEAN NOT NULL,
    multiple_lines VARCHAR(30),
    internet_service VARCHAR(20),
    online_security VARCHAR(30),
    online_backup VARCHAR(30),
    device_protection VARCHAR(30),
    tech_support VARCHAR(30),
    streaming_tv VARCHAR(30),
    streaming_movies VARCHAR(30),

    contract VARCHAR(30),
    paperless_billing BOOLEAN NOT NULL,
    payment_method VARCHAR(40),

    monthly_charges NUMERIC(10,2) NOT NULL,
    total_charges NUMERIC(10,2),
    churn BOOLEAN NOT NULL
);
