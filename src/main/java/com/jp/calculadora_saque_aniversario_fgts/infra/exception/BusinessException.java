package com.jp.calculadora_saque_aniversario_fgts.infra.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
