package com.restaurante.cliente.model;

public class Restaurante {

    private String nome;
    private String tipoCozinha;
    private String endereco;

    public Restaurante(String nome, String tipoCozinha, String endereco) {
        this.nome = nome;
        this.tipoCozinha = tipoCozinha;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipoCozinha() { return tipoCozinha; }
    public void setTipoCozinha(String tipoCozinha) { this.tipoCozinha = tipoCozinha; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}