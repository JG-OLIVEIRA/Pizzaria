package com.sensezzaria.funcionalidades;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sensezzaria.entidades.Alimento;
import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;
import com.sensezzaria.enums.OpcoesAlimento;

public class Menu {
    Cardapio cardapio = new Cardapio();
    List<Pizza> listaDePizzas = cardapio.getPizzas();
    List<Bebida> listaDeBebidas = cardapio.getBebidas();
    List<Sobremesa> listaDeSobremesas = cardapio.getSobremessas();

    public void iniciaSistema(){
        System.out.println("");
        System.out.println("Bem-vindo a Sensezzaria!");
        System.out.println("Faça seu pedido!");
        System.out.println("");
    }

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

    public void requisitaPedidos(Pedido pedido){
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("O que você vai pedir?");
        System.out.println("");

        for(OpcoesAlimento opcoes: OpcoesAlimento.values()) {
            System.out.println(opcoes.getValor() + " - " + opcoes.toString());
        }

        System.out.println("Resposta: ");

        Integer opcaoInput = scanner.nextInt();

        switch (opcaoInput) {
            case 1:
                System.out.println("");
                System.out.println("Agora digite o id da pizza que deseja: ");

                Integer pizzaId = scanner.nextInt();

                Pizza pizza = listaDePizzas.get(pizzaId - 1);
                pedido.adicionaPizza(pizza);
                break;
            case 2:
                System.out.println("");
                System.out.println("Agora digite o id da bebida que deseja: ");

                Integer bebidaId = scanner.nextInt();

                Bebida bebida = listaDeBebidas.get(bebidaId - 1);
                pedido.adicionaBebida(bebida);
                break;
            case 3:
                System.out.println("");
                System.out.println("Agora digite o id da sobremesa que deseja: ");

                Integer sobremesaId = scanner.nextInt();

                Sobremesa sobremesa = listaDeSobremesas.get(sobremesaId - 1);
                pedido.adicionaSobremesa(sobremesa);
                break;
        }

        System.out.println("");
        System.out.println("1 - Fechar conta");
        System.out.println("2 - Continuar pedindo");
        System.out.println("");

        Integer op2 = scanner.nextInt();

        if(op2 == 2){
            requisitaPedidos(pedido);
        }

    }

    public void fechaConta(Pedido pedido){
        Double valorTotal = pedido.getValorTotal();
        System.out.println("Total a ser pago: R$" + valorTotal);
    }

    public void mostraItensDoPedidos(List<Alimento> listaDoPedido){
        System.out.println("");
        System.out.println("Pedidos feitos: ");
        listaDoPedido.forEach(alimento -> System.out.println(alimento.toString()));
        System.out.println("");
    }

    public Integer encerraSistema() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("1 - Encerra sistema");
        System.out.println("2 - Voltar ao menu");
        System.out.println("");

        Integer numero = scanner.nextInt();

        return numero;
    }
}
