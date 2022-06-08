package com.sensedia.sensezzaria.utils;

import com.sensedia.sensezzaria.excecoes.InputInvalido;

public class CheckIntegerInput {
    public Integer verify(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            throw new InputInvalido();
        }
    }
}
