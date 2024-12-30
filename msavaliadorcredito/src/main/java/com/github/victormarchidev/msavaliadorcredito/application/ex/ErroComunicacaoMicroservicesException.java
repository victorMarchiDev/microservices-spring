package com.github.victormarchidev.msavaliadorcredito.application.ex;

import lombok.Getter;

@Getter
public class ErroComunicacaoMicroservicesException extends Exception{

    private Integer status;

    public ErroComunicacaoMicroservicesException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }

}
