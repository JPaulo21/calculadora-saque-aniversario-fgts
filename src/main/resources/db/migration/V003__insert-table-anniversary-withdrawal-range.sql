INSERT INTO withdraw.anniversary_withdrawal_range (
    initial_range,
    range_limit,
    rate,
    fixed_additional_amount
)
VALUES (0, 500, 50, 0),
       (500.01, 1000, 40, 50),
       (1000.01, 5000, 30, 150),
       (5000.01, 10000, 20, 650),
       (10000.01, 15000, 15, 1150),
       (15000.01, 20000, 10, 1900),
       (20000.01, 99999999, 5, 2900);