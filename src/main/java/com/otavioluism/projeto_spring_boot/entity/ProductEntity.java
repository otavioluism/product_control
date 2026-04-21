package com.otavioluism.projeto_spring_boot.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "produtos")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;
    private Long preco;

    public ProductEntity(String nome, Long preco) {
        this.nome = nome;
        this.preco = preco;
    }

    protected ProductEntity() {}

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPreco(){
        return this.preco;
    }

    public void setPreco(Long preco){
        this.preco = preco;
    }

}
