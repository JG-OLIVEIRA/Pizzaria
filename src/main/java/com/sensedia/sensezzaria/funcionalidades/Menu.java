package com.sensedia.sensezzaria.funcionalidades;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.sensedia.sensezzaria.entidades.*;
import com.sensedia.sensezzaria.enums.OpcoesAlimento;
import com.sensedia.sensezzaria.excecoes.IdInvalido;
import com.sensedia.sensezzaria.excecoes.InputInvalido;
import com.sensedia.sensezzaria.excecoes.OpcaoInvalida;
import com.sensedia.sensezzaria.services.*;
import com.sensedia.sensezzaria.utils.CheckIntegerInput;


public class Menu {
    Cardapio cardapio = new Cardapio();
    AlimentoPedidoService alimentoPedidoService = new AlimentoPedidoService();
    PizzaService pizzaService = new PizzaService();
    BebidaService bebidaService = new BebidaService();
    SobremesaService sobremesaService = new SobremesaService();
    PedidoService pedidoService = new PedidoService();
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

        System.out.println("Digite a medida: ");

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

    public void deletaPizzaById() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        cardapio.getPizzas().forEach(pizza -> System.out.println(pizza.toString()));

        System.out.println("");
        System.out.println("Digite o id da pizza: ");
        System.out.println("");

        Integer id = scanner.nextInt();

        pizzaService.deletePizzaById(id);

        System.out.println("Pizza com id = " + id + " deletada.");
    }

    public void deletaBebidaById() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        cardapio.getBebidas().forEach(bebida -> System.out.println(bebida.toString()));

        System.out.println("");
        System.out.println("Digite o id da bebida: ");
        System.out.println("");

        Integer id = scanner.nextInt();

        bebidaService.deleteBebidaById(id);

        System.out.println("Bebida com id = " + id + " deletada.");
    }

    public void deletaSobremesaById() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        cardapio.getSobremesas().forEach(sobremesa -> System.out.println(sobremesa.toString()));

        System.out.println("");
        System.out.println("Digite o id da sobremesa: ");
        System.out.println("");

        Integer id = scanner.nextInt();

        sobremesaService.deleteSobremesaById(id);

        System.out.println("Sobremesa com id = " + id + " deletada.");
    }

    public void requisitaPedidos(Pedido pedido) throws InputInvalido, SQLException {

        Scanner scanner = new Scanner(System.in);

        int i = 1;
        System.out.println("");
        System.out.println("Opções: ");
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
                    alimentoPedidoService.addItensAoPedido(pedido, pizza.get());
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
                    alimentoPedidoService.addItensAoPedido(pedido, bebida.get());
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
                    alimentoPedidoService.addItensAoPedido(pedido, sobremesa.get());
                    break;
            }

        } catch (InputInvalido | IdInvalido | OpcaoInvalida | SQLException ex){
            System.out.println(ex.getMessage());
            requisitaPedidos(pedido);
        }

        mostraItensDoPedidos(alimentoPedidoService.getItensDoPedido(pedido));

        System.out.println("");
        System.out.println("Opções: ");
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

        alimentoPedidoService
                .getItensDoPedido(pedido)
                .forEach(alimento -> System.out.println(alimento.toString()));

        Scanner scanner = new Scanner(System.in);


        System.out.println("");
        System.out.println("Opções: ");
        System.out.println("");
        System.out.println("1 - Remover item do pedido.");
        System.out.println("2 - Adicionar mais um item.");
        System.out.println("3 - Fechar conta.");

        Integer op1 = scanner.nextInt();

        switch (op1){
            case 1:
                List<Alimento> alimentos = alimentoPedidoService
                        .getItensDoPedido(pedido);

                System.out.println("Número do id produto: ");

                Integer id = scanner.nextInt();

                Alimento alimento = alimentos
                                    .stream()
                                    .filter(produto -> produto.getId() == Long.valueOf(id))
                                    .findFirst()
                                    .get();

                AlimentoPedido alimentoPedido = alimentoPedidoService.getAlimentoPedido(pedido, alimento);

                alimentoPedidoService.deleteAlimentoPedido(alimentoPedido);
                mostraItensDoPedidos(alimentoPedidoService.getItensDoPedido(pedido));
                editaPedido(pedido);
            case 2:
                requisitaPedidos(pedido);
            case 3:
                fechaConta(pedido);
            default:
                System.out.println("Digite uma opção válida");
                editaPedido(pedido);
        }
    }

    public void fechaConta(Pedido pedido) throws SQLException {
        pedido.setTotal(alimentoPedidoService.getItensDoPedido(pedido).stream().mapToDouble(Alimento::getValor).sum());
        pedidoService.updatePedido(pedido);
        Double valorTotal = pedido.getTotal();
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
        System.out.println("Opções: ");
        System.out.println("");
        System.out.println("1 - Encerra sistema");
        System.out.println("2 - Fazer um novo pedido");
        System.out.println("3 - Cadatrar produtos");
        System.out.println("4 - Editar produtos");
        System.out.println("5 - Excluir produtos");
        System.out.println("");

        String op = scanner.next();

        Integer numero = checkIntegerInput.verify(op);

        return numero;
    }

    public void deletaProduto() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("Opções: ");
        System.out.println("");
        System.out.println("1 - Pizza");
        System.out.println("2 - Bebida");
        System.out.println("3 - Sobremesa");
        System.out.println("");

        String op1 = scanner.next();

        Integer op = checkIntegerInput.verify(op1);

        switch (op){
            case 1:
                deletaPizzaById();
                break;
            case 2:
                deletaBebidaById();
                break;
            case 3:
                deletaSobremesaById();
                break;
            default:
                System.out.println("Opção inválida.");
        }

    }

    public void cadastraProdutos() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("Opções: ");
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
