package com.sensezzaria.funcionalidades;

import java.util.List;
import java.util.Scanner;

import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;

public class Menu {
    Cardapio cardapio = new Cardapio();
    Pedido pedido = new Pedido();
    List<Pizza> listaDePizzas = cardapio.getPizzas();
    List<Bebida> listaDeBebidas = cardapio.getBebidas();
    List<Sobremesa> listaDeSobremesas = cardapio.getSobremessas();

    public void mostraOpcoesDeCardapio(){
        System.out.println("Pizzas:");
        System.out.println("");
        listaDePizzas.forEach(pizza -> System.out.println(pizza.toString()));
        System.out.println("");
        System.out.println("Bebidas:");
        System.out.println("");
        listaDeBebidas.forEach(bebida -> System.out.println(bebida.toString()));
        System.out.println("");
        System.out.println("Sobremesas:");
        System.out.println("");
        listaDeSobremesas.forEach(sobremesa -> System.out.println(sobremesa.toString()));
    }

    public void iniciaSistema(){
        System.out.println("");
        System.out.println("Bem-vindo a Sensezzaria!");
        System.out.println("Faça seu pedido!");
        System.out.println("");
    }

    public void requisitaPedidos(String nome){
        Scanner scanner = new Scanner(System.in);

        if(nome == "pizza") {
            System.out.println("");
            System.out.println("Agora digite o id da pizza que deseja: ");

            Integer pizzaId = scanner.nextInt();

            Pizza pizza = listaDePizzas.get(pizzaId);
            pedido.adicionaPizza(pizza);
        }

        if(nome == "bebida"){
            System.out.println("");
            System.out.println("Agora digite o id da bebida que deseja: ");

            Integer bebidaId = scanner.nextInt();

            Bebida bebida = listaDeBebidas.get(bebidaId);
            pedido.adicionaBebida(bebida);
        }

        if(nome == "sobremesa"){
            System.out.println("");
            System.out.println("Agora digite o id da sobremesa que deseja: ");

            Integer sobremesaId = scanner.nextInt();

            Sobremesa sobremesa = listaDeSobremesas.get(sobremesaId);
            pedido.adicionaSobremesa(sobremesa);
        }
    }

    public void fechaConta(){
        Double valorTotal = pedido.getValorTotal();
        System.out.println("Total a ser pago: R$" + valorTotal);
    }
}
