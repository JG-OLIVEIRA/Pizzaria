package com.sensedia.sensezzaria;

import com.sensedia.sensezzaria.entidades.Pedido;
import com.sensedia.sensezzaria.funcionalidades.Menu;
import com.sensedia.sensezzaria.services.PedidoService;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();

        PedidoService pedidoService = new PedidoService();

        while(true){
            Pedido pedido = pedidoService.createPedido();

            menu.iniciaSistema();
            menu.mostraOpcoesDeCardapio();
            menu.requisitaPedidos(pedido);
            menu.mostraItensDoPedidos(pedido.getAlimentos());

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
