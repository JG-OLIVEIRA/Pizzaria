package com.sensezzaria.funcionalidades;
import java.util.List;
import java.util.Scanner;

import com.sensezzaria.entidades.Alimento;
import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;
import com.sensezzaria.enums.OpcoesAlimento;
import com.sensezzaria.excecoes.IdInvalido;
import com.sensezzaria.excecoes.InputInvalido;
import com.sensezzaria.excecoes.OpcaoInvalida;
import com.sensezzaria.utils.CheckIntegerInput;


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

    CheckIntegerInput checkIntegerInput = new CheckIntegerInput();

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

    public void requisitaPedidos(Pedido pedido) throws InputInvalido {

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

        try {

            String opcaoInput = scanner.next();

            Integer op1 = checkIntegerInput.verify(opcaoInput);

            OpcoesAlimento meuEnum = OpcoesAlimento.valueOf(op1);

            Boolean existe;

            switch (meuEnum) {
                case PIZZA:
                    pizzas.forEach(pizza -> System.out.println(pizza.toString()));
                    System.out.println("");
                    System.out.println("Agora digite o id da pizza que deseja: ");

                    Integer pizzaId = scanner.nextInt();

                    existe = cardapio
                            .getPizzas()
                            .stream()
                            .map(pizza -> pizza.getId())
                            .anyMatch(id -> id == Long.valueOf(pizzaId));

                    if(!existe){
                        throw new IdInvalido();
                    }

                    Pizza pizza = cardapio.getPizzas().get(pizzaId - 1);
                    System.out.println(pizza.toString());
                    pedido.adicionaAlimento(pizza);
                    break;

                case BEBIDA:
                    bebidas.forEach(bebida -> System.out.println(bebida.toString()));
                    System.out.println("");
                    System.out.println("Agora digite o id da bebida que deseja: ");

                    Integer bebidaId = scanner.nextInt();

                    existe = cardapio
                            .getBebidas()
                            .stream()
                            .map(bebida -> bebida.getId())
                            .anyMatch(id -> id == Long.valueOf(bebidaId));

                    if(!existe){
                        throw new IdInvalido();
                    }

                    Bebida bebida = cardapio.getBebidas().get(bebidaId - 1);
                    System.out.println(bebida.toString());
                    pedido.adicionaAlimento(bebida);
                    break;

                case SOBREMESA:
                    sobremesas.forEach(sobremesa -> System.out.println(sobremesa.toString()));
                    System.out.println("");
                    System.out.println("Agora digite o id da sobremesa que deseja: ");

                    Integer sobremesaId = scanner.nextInt();

                    existe = cardapio
                            .getSobremesas()
                            .stream()
                            .map(sobremesa -> sobremesa.getId())
                            .anyMatch(id -> id == Long.valueOf(sobremesaId));

                    if(!existe){
                        throw new IdInvalido();
                    }

                    Sobremesa sobremesa = cardapio.getSobremesas().get(sobremesaId - 1);
                    System.out.println(sobremesa.toString());
                    pedido.adicionaAlimento(sobremesa);
                    break;
            }

        } catch (InputInvalido | IdInvalido | OpcaoInvalida ex){
            System.out.println(ex.getMessage());
            requisitaPedidos(pedido);
        }

        mostraItensDoPedidos(pedido.getAlimentos());

        System.out.println("");
        System.out.println("1 - Fechar conta.");
        System.out.println("2 - Continuar pedido.");
        System.out.println("3 - Editar pedido.");
        System.out.println("");

        Integer op2 = scanner.nextInt();

        switch (op2){
            case 1:
                fechaConta(pedido);
                break;
            case 2:
                requisitaPedidos(pedido);
                break;
            case 3:
                editaPedido(pedido);
                System.out.println("Digite uma opção válida");
                requisitaPedidos(pedido);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void editaPedido(Pedido pedido) {
        System.out.println("");
        System.out.println("Pedidos feitos: ");
        pedido.getAlimentos().forEach(alimento -> System.out.println(alimento.toString()));

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Remover item do pedido.");
        System.out.println("2 - Adicionar mais um item.");

        Integer op1 = scanner.nextInt();

        switch (op1){
            case 1:
                System.out.println("Numero do item na lista do pedido: ");
                Integer index = scanner.nextInt();
                pedido.removeAlimento(index - 1);
            case 2:
                requisitaPedidos(pedido);
            default:
                System.out.println("Digite uma opção válida");
                editaPedido(pedido);
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


        String op = scanner.next();

        Integer numero = checkIntegerInput.verify(op);

        return numero;
    }
}
