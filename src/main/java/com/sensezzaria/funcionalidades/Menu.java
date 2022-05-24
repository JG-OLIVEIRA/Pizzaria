package com.sensezzaria.funcionalidades;
import java.util.List;
import java.util.Scanner;

import com.sensezzaria.entidades.Alimento;
import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;
import com.sensezzaria.enums.OpcoesAlimento;

public class Menu {
    List<Bebida> bebidas = List.of(
            new Bebida(1L, "Coca-coca", 0.25F, 2.5F),
            new Bebida(2L, "Coca-coca", 1F, 9F),
            new Bebida(3L, "Guaraná", 0.25F, 2.5F),
            new Bebida(4L, "Guaraná", 1F, 8.5F),
            new Bebida(5L, "Skol-Beats", 0.35F, 7F)
    );

    List<Pizza> pizzas = List.of(
            new Pizza(1L, "Mussarela", 8, 36F),
            new Pizza(2L, "Mussarela", 12, 67F),
            new Pizza(3L, "Margherita", 8, 37F),
            new Pizza(4L, "Margherita", 12, 70F),
            new Pizza(5L, "Caprese", 8, 40F),
            new Pizza(6L, "Caprese", 12, 77F),
            new Pizza(7L, "Três Queijos", 8,  47F),
            new Pizza(8L, "Três Queijos", 12,  83F),
            new Pizza(9L, "Quatro Queijos", 8, 50F),
            new Pizza(10L, "Quatro Queijos", 12, 83F)
    );

    List<Sobremesa> sobremesas = List.of(
            new Sobremesa(1L, "Bolo", 5F),
            new Sobremesa(2L, "Pudim", 3.5F)
    );

    Cardapio cardapio = new Cardapio(bebidas, pizzas, sobremesas);

    public void iniciaSistema(){
        System.out.println("");
        System.out.println("Bem-vindo a Sensezzaria!");
        System.out.println("Faça seu pedido!");
        System.out.println("");
    }

    public void mostraOpcoesDeCardapio(){
        System.out.println("Pizzas:");
        System.out.println("");
        pizzas.forEach(pizza -> System.out.println(pizza.toString()));
        System.out.println("");
        System.out.println("Bebidas:");
        System.out.println("");
        bebidas.forEach(bebida -> System.out.println(bebida.toString()));
        System.out.println("");
        System.out.println("Sobremesas:");
        System.out.println("");
        sobremesas.forEach(sobremesa -> System.out.println(sobremesa.toString()));
    }

    public void requisitaPedidos(Pedido pedido){
        Scanner scanner = new Scanner(System.in);

        int i = 1;
        System.out.println("");
        for(OpcoesAlimento opcoes: OpcoesAlimento.values()) {
            System.out.println(i + " - " + opcoes.toString());
            i++;
        }

        System.out.println("");
        System.out.println("O que você vai pedir?");
        System.out.println("");


        Integer opcaoInput = scanner.nextInt();

        OpcoesAlimento meuEnum = OpcoesAlimento.valueOf(opcaoInput);

        switch (meuEnum) {
            case PIZZA:
                System.out.println("");
                System.out.println("Agora digite o id da pizza que deseja: ");

                Integer pizzaId = scanner.nextInt();

                Pizza pizza = cardapio.getPizzas().get(pizzaId - 1);
                pedido.adicionaAlimento(pizza);
                break;
            case BEBIDA:
                System.out.println("");
                System.out.println("Agora digite o id da bebida que deseja: ");

                Integer bebidaId = scanner.nextInt();

                Bebida bebida = cardapio.getBebidas().get(bebidaId - 1);
                pedido.adicionaAlimento(bebida);
                break;
            case SOBREMESA:
                System.out.println("");
                System.out.println("Agora digite o id da sobremesa que deseja: ");

                Integer sobremesaId = scanner.nextInt();

                Sobremesa sobremesa = cardapio.getSobremesas().get(sobremesaId - 1);
                pedido.adicionaAlimento(sobremesa);
                break;
        }

        System.out.println("");
        System.out.println("1 - Fechar conta.");
        System.out.println("2 - Continuar pedido.");
        System.out.println("3 - Editar pedido.");
        System.out.println("");

        Integer op2 = scanner.nextInt();

        if(op2 == 2){
            requisitaPedidos(pedido);
        }

        if(op2 == 3){
            editaPedido(pedido);
        }
    }

    public void editaPedido(Pedido pedido){
        System.out.println("");
        System.out.println("Pedidos feitos: ");
        pedido.getAlimentos().forEach(alimento -> System.out.println(alimento.toString()));

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Remover item do pedido.");
        System.out.println("2 - Adicionar mais um item.");

        Integer op1 = scanner.nextInt();

        if(op1 == 1){
            System.out.println("Numero do item na lista do pedido: ");
            Integer index = scanner.nextInt();
            pedido.removeAlimento(index - 1);
        }

        if(op1 == 2){
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
