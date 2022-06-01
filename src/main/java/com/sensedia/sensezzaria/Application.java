package com.sensedia.sensezzaria;

import com.sensedia.sensezzaria.entidades.Alimento;
import com.sensedia.sensezzaria.funcionalidades.Menu;
import com.sensedia.sensezzaria.funcionalidades.Pedido;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Menu menu = new Menu();

        while(true){
            Pedido pedido = new Pedido();
            List<Alimento> listaAlimentos = pedido.getAlimentos();
            menu.iniciaSistema();
            menu.mostraOpcoesDeCardapio();
            menu.requisitaPedidos(pedido);
            menu.mostraItensDoPedidos(listaAlimentos);
            Integer op = menu.encerraSistema();

            while(true){
                if(op == 1 || op == 2){
                    break;
                } else{
                    System.out.println("Opção inválida");
                    op = menu.encerraSistema();
                }
            }

            if(op == 1){
                break;
            }


        }
    }
}
