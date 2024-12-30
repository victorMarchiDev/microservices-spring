package com.github.victormarchidev.mscartoes.representation;

import com.github.victormarchidev.mscartoes.domain.Cartao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public class CartaoSaveRequest {

    private String nome;
    private String bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        System.out.println("Criando cartao: " + nome + " " + bandeira + " "
                + renda.toString() + " "
                + limite.toString());
        return new Cartao(nome, bandeira, renda, limite);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}
