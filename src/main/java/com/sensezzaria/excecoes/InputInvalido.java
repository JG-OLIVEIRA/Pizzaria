package com.sensezzaria.excecoes;

import java.util.InputMismatchException;

public class InputInvalido extends InputMismatchException {

    @Override
    public String getMessage() {
        return  "Foi passada uma string no lugar de um número";
    }
}
