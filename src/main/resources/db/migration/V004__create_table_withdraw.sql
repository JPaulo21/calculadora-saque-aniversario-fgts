CREATE TABLE withdraw.withdrawal_inquiry  (
    id SERIAL PRIMARY KEY,
    fgts_value NUMERIC(15,2) NOT NULL,
    anniversary_withdrawal_range_id INTEGER NOT NULL,
    withdraw_value NUMERIC(15,2) NOT NULL,
    value_range NUMERIC(15,2) NOT NULL,
    fgts_value_after_withdraw NUMERIC(15,2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_ANNIVERSARY_WITHDRAWAL_RANGE_ID
        FOREIGN KEY (anniversary_withdrawal_range_id)
        REFERENCES withdraw.anniversary_withdrawal_range(id)
);

COMMENT ON TABLE withdraw.withdrawal_inquiry IS 'Tabela para armazenar as consultas de saque realizadas pelos clientes, incluindo o valor do FGTS, o intervalo de saque, o valor do saque e o intervalo de valor.';
COMMENT ON COLUMN withdraw.withdrawal_inquiry.fgts_value IS 'Valor do FGTS do cliente no momento da consulta.';