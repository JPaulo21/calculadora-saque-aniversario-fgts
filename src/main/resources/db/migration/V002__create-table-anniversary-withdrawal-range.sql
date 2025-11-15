CREATE TABLE withdraw.anniversary_withdrawal_range (
    id SERIAL PRIMARY KEY,
    initial_range NUMERIC(15,2) NOT NULL,
    range_limit NUMERIC(15,2) NOT NULL,
    rate NUMERIC(15,2) NOT NULL,
    fixed_additional_amount NUMERIC(15,2) NOT NULL
);