package com.otavioluism.projeto_spring_boot.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long Id) {
        super("Procut " + Id + " not found!");
    }

}
