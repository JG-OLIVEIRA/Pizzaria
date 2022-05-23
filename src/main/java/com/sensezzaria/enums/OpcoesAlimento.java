package com.sensezzaria.enums;

public enum OpcoesAlimento {
    PIZZA(1), BEBIDA(2), SOBREMESA(3);

        private final Integer valor;

    OpcoesAlimento(Integer valorOpcao){
        valor = valorOpcao;
    }

    public Integer getValor(){
        return valor;
    }
}
