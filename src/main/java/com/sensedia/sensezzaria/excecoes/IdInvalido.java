package com.sensedia.sensezzaria.excecoes;

public class IdInvalido extends Exception{

    @Override
    public String getMessage() {
        return  "Digite um id válido";
    }
}
