package com.sensezzaria.funcionalidades;

import java.util.List;
import java.util.Scanner;

import com.sensezzaria.entidades.Alimento;
import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;

public class Menu {
    Cardapio cardapio = new Cardapio();
    Pedido pedido = new Pedido();
    List<Pizza> listaDePizzas = cardapio.getPizzas();
    List<Bebida> listaDeBebidas = cardapio.getBebidas();
    List<Sobremesa> listaDeSobremesas = cardapio.getSobremessas();

    List<Alimento> listaDeAlimentosDoPedido = pedido.getAlimentosDoPedido();

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

    public void requisitaPedidos(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("O que você vai pedir?");
        System.out.println("1 - Pizza");
        System.out.println("2 - Bebida");
        System.out.println("3 - Sobremesa");
        System.out.println("Resposta: ");

        Integer op = scanner.nextInt();

        if(op == 1) {
            System.out.println("");
            System.out.println("Agora digite o id da pizza que deseja: ");

            Integer pizzaId = scanner.nextInt();

            Pizza pizza = listaDePizzas.get(pizzaId - 1);
            pedido.adicionaPizza(pizza);
        }

        if(op == 2){
            System.out.println("");
            System.out.println("Agora digite o id da bebida que deseja: ");

            Integer bebidaId = scanner.nextInt();

            Bebida bebida = listaDeBebidas.get(bebidaId - 1);
            pedido.adicionaBebida(bebida);
        }

        if(op == 3){
            System.out.println("");
            System.out.println("Agora digite o id da sobremesa que deseja: ");

            Integer sobremesaId = scanner.nextInt();

            Sobremesa sobremesa = listaDeSobremesas.get(sobremesaId - 1);
            pedido.adicionaSobremesa(sobremesa);
        }

        System.out.println("");
        System.out.println("1 - Fechar conta");
        System.out.println("2 - Continuar pedindo");
        System.out.println("");

        Integer op2 = scanner.nextInt();

        if(op2 == 2){
            requisitaPedidos();
        }
    }

    public void fechaConta(){
        Double valorTotal = pedido.getValorTotal();
        System.out.println("Total a ser pago: R$" + valorTotal);
    }

    public void mostraItensDoPedidos(){
        System.out.println("Pedidos feitos: ");
        listaDeAlimentosDoPedido.forEach(alimento -> System.out.println(alimento.toString()));
    }
}
