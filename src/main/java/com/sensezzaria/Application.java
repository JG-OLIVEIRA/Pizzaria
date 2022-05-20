package com.sensezzaria;

import com.sensezzaria.funcionalidades.Menu;

public class Application {

    public static void main(String[] args){
        Menu menu = new Menu();

        menu.iniciaSistema();
        menu.mostraOpcoesDeCardapio();
        menu.requisitaPedidos();
        menu.mostraItensDoPedidos();
        menu.fechaConta();
    }
}
