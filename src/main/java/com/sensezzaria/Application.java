package com.sensezzaria;

import java.util.List;

import com.sensezzaria.entidades.Alimento;
import com.sensezzaria.funcionalidades.Menu;
import com.sensezzaria.funcionalidades.Pedido;

public class Application {

    public static void main(String[] args)  {
        Menu menu = new Menu();

        while(true){
            Pedido pedido = new Pedido();
            List<Alimento> listaAlimentos = pedido.getAlimentos();
            menu.iniciaSistema();
            menu.mostraOpcoesDeCardapio();
            menu.requisitaPedidos(pedido);
            menu.mostraItensDoPedidos(listaAlimentos);
            Integer op = menu.encerraSistema();

            if(op == 1){
                break;
            }
        }

    }
}
