package com.sensedia.sensezzaria.funcionalidades;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sensedia.sensezzaria.entidades.*;
import com.sensedia.sensezzaria.enums.OpcoesAlimento;
import com.sensedia.sensezzaria.excecoes.IdInvalido;
import com.sensedia.sensezzaria.excecoes.InputInvalido;
import com.sensedia.sensezzaria.excecoes.OpcaoInvalida;
import com.sensedia.sensezzaria.services.AlimentoPedidoService;
import com.sensedia.sensezzaria.services.BebidaService;
import com.sensedia.sensezzaria.services.PizzaService;
import com.sensedia.sensezzaria.services.SobremesaService;
import com.sensedia.sensezzaria.utils.CheckIntegerInput;


public class Menu {
    Cardapio cardapio = new Cardapio();
    AlimentoPedidoService alimentoPedidoService = new AlimentoPedidoService();

    PizzaService pizzaService = new PizzaService();
    BebidaService bebidaService = new BebidaService();
    SobremesaService sobremesaService = new SobremesaService();
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

    public void cadastraPizza() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("Cadastre uma pizza: ");
        System.out.println("");

        System.out.println("Digite o sabor: ");

        String sabor = scanner.next();

        System.out.println("Digite o tamanho: ");

        Integer tamanho = scanner.nextInt();

        System.out.println("Digite o valor: ");

        String valor = scanner.next();

        Pizza pizza = pizzaService.createPizza(sabor, tamanho, Float.parseFloat(valor));

        System.out.println(pizza);
    }

    public void cadastraBebida() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("Cadastre uma bebida: ");
        System.out.println("");

        System.out.println("Digite o nome: ");

        String nome = scanner.next();

        System.out.println("Digite o medida: ");

        Float medida = scanner.nextFloat();

        System.out.println("Digite o valor: ");

        String valor = scanner.next();

        Bebida bebida = bebidaService.createBebida(nome, medida, Float.parseFloat(valor));

        System.out.println(bebida);
    }

    public void cadastraSobremesa() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("Cadastre uma sobremesa: ");
        System.out.println("");

        System.out.println("Digite o nome: ");

        String nome = scanner.next();

        System.out.println("Digite o valor: ");

        String valor = scanner.next();

        Sobremesa sobremesa = sobremesaService.createSobremesa(nome, Float.parseFloat(valor));

        System.out.println(sobremesa);
    }

    public void requisitaPedidos(Pedido pedido) throws InputInvalido, SQLException {

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

                    Optional<Pizza> pizza = cardapio
                                    .getPizzas()
                                    .stream()
                                    .filter(p -> p.getId() == Long.valueOf(pizzaId))
                                    .findFirst();

                    System.out.println(pizza.get());
                    pedido.adicionaAlimento(pizza.get());
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

                    Optional<Bebida> bebida =  cardapio
                            .getBebidas()
                            .stream()
                            .filter(b -> b.getId() == Long.valueOf(bebidaId))
                            .findFirst();

                    System.out.println(bebida.get());
                    pedido.adicionaAlimento(bebida.get());
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

                    Optional<Sobremesa> sobremesa = cardapio
                            .getSobremesas()
                            .stream()
                            .filter(s -> s.getId() == Long.valueOf(sobremesaId))
                            .findFirst();

                    System.out.println(sobremesa.get());
                    pedido.adicionaAlimento(sobremesa.get());
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

    public void editaPedido(Pedido pedido) throws SQLException {
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
        alimentoPedidoService.addItensAoPedido(pedido);
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
        System.out.println("3 - Cadatrar produtos");
        System.out.println("4 - Editar produtos");
        System.out.println("5 - Excluir produtos");
        System.out.println("");


        String op = scanner.next();

        Integer numero = checkIntegerInput.verify(op);

        return numero;
    }

    public void cadastraProdutos() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("1 - Pizza");
        System.out.println("2 - Bebida");
        System.out.println("3 - Sobremesa");
        System.out.println("");

        String op1 = scanner.next();

        Integer op = checkIntegerInput.verify(op1);

        switch (op){
            case 1:
                cadastraPizza();
                break;
            case 2:
                cadastraBebida();
                break;
            case 3:
                cadastraSobremesa();
                break;
            default:
                System.out.println("Opção inválida.");
        }

    }

}
