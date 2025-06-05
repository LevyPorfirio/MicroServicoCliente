package com.restaurante.cliente.model;

public class Restaurante {

    private String nome;
    private String cnpj;
    private String categoria;
    private String endereco;

    public Restaurante() {}

    public Restaurante(String nome, String cnpj, String categoria, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.categoria = categoria;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
