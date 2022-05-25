package com.sensezzaria.excecoes;

import java.util.NoSuchElementException;

public class OpcaoInvalida extends NoSuchElementException {

    @Override
    public String getMessage() {
        return "Opção inválida";
    }
}
