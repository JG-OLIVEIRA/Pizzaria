package com.sensedia.sensezzaria.funcionalidades;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sensedia.sensezzaria.entidades.Alimento;
import com.sensedia.sensezzaria.entidades.Bebida;
import com.sensedia.sensezzaria.entidades.Pizza;
import com.sensedia.sensezzaria.entidades.Sobremesa;
import com.sensedia.sensezzaria.enums.OpcoesAlimento;
import com.sensedia.sensezzaria.excecoes.IdInvalido;
import com.sensedia.sensezzaria.excecoes.InputInvalido;
import com.sensedia.sensezzaria.excecoes.OpcaoInvalida;
import com.sensedia.sensezzaria.utils.CheckIntegerInput;


public class Menu {
    Cardapio cardapio = new Cardapio();

    CheckIntegerInput checkIntegerInput = new CheckIntegerInput();

    public void iniciaSistema(){
        System.out.println("");
        System.out.println("Bem-vindo a Sensezzaria!");
        System.out.println("Faça seu pedido!");
        System.out.println("");
    }

    public void mostraOpcoesDeCardapio(){
        try{
            System.out.println("Pizzas:");
            System.out.println("");
            cardapio.getPizzas().forEach(pizza -> System.out.println(pizza.toString()));
            System.out.println("");
            System.out.println("Bebidas:");
            System.out.println("");
            cardapio.getBebidas().forEach(bebida -> System.out.println(bebida.toString()));
            System.out.println("");
            System.out.println("Sobremesas:");
            System.out.println("");
            cardapio.getSobremesas().forEach(sobremesa -> System.out.println(sobremesa.toString()));
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

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
                    cardapio.getPizzas().forEach(pizza -> System.out.println(pizza.toString()));
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
                    cardapio.getBebidas().forEach(bebida -> System.out.println(bebida.toString()));
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
                    cardapio.getSobremesas().forEach(sobremesa -> System.out.println(sobremesa.toString()));
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

        } catch (InputInvalido | IdInvalido | OpcaoInvalida | SQLException ex){
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
