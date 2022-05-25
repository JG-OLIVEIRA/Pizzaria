package com.sensezzaria.utils;

import com.sensezzaria.excecoes.InputInvalido;

public class CheckIntegerInput {
    public Integer verify(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            throw new InputInvalido();
        }
    }
}
