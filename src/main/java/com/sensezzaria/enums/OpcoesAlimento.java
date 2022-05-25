package com.sensezzaria.enums;

import java.util.Arrays;
import java.util.NoSuchElementException;

import com.sensezzaria.excecoes.OpcaoInvalida;

public enum OpcoesAlimento {
    PIZZA(1), BEBIDA(2), SOBREMESA(3);

    private int value;

    private OpcoesAlimento(int value) {
        this.value = value;
    }

    public static OpcoesAlimento valueOf(int value) {
        try{
            return Arrays.stream(values()).filter(val -> val.value == value).findFirst().get();
        } catch (NoSuchElementException ex){
            throw new OpcaoInvalida();
        }
    }
}
