package com.sensezzaria.funcionalidades;

import java.util.List;
import java.util.Scanner;

import com.sensezzaria.entidades.Bebida;
import com.sensezzaria.entidades.Pizza;
import com.sensezzaria.entidades.Sobremesa;

public class Menu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();

        Float total = 0F;

        List<Pizza> listaDePizzas = cardapio.getPizzas();
        List<Bebida> listaDeBebidas = cardapio.getBebidas();
        List<Sobremesa> listaDeSobremesas = cardapio.getSobremessas();

        while(true){
            System.out.println("Bem-vindo a Sensezzaria!");
            System.out.println("Faça seu pedido!");

            System.out.println("");
            System.out.println("Deseja pedir uma pizza?");
            System.out.println("");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.println("Resposta: ");

            Integer op1 = scanner.nextInt();

            if(op1 == 1){
                System.out.println("");
                System.out.println("Pizzas:");
                System.out.println("");

                for(int i = 0; i < listaDePizzas.size(); i++){
                    Long id = listaDePizzas.get(i).getId();
                    String sabor = listaDePizzas.get(i).getSabor();
                    Integer tamanho = listaDePizzas.get(i).getTamanho();
                    Float valor = listaDePizzas.get(i).getValor();

                    System.out.println("Id: " + id + ", sabor: " + sabor + ", tamanho: " + tamanho + ", valor: " + valor);
                }

                while(true){
                    System.out.println("");
                    System.out.println("Agora digite o id da pizza que deseja: ");

                    Integer pizzaId = scanner.nextInt();

                    total = total + listaDePizzas.get(pizzaId).getValor();

                    System.out.println("");
                    System.out.println("Quer mais uma?");
                    System.out.println("");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.println("Resposta: ");

                    Integer op12 = scanner.nextInt();

                    if(op12 == 2){
                        break;
                    }
                }
            }

            System.out.println("");
            System.out.println("Deseja pedir uma bebida?");
            System.out.println("");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.println("Resposta: ");

            Integer op2 = scanner.nextInt();

            if(op2 == 1){
                System.out.println("");
                System.out.println("Bebidas:");
                System.out.println("");

                for(int i = 0; i < listaDeBebidas.size(); i++){
                    Long id = listaDeBebidas.get(i).getId();
                    String nome = listaDeBebidas.get(i).getNome();
                    Float medida = listaDeBebidas.get(i).getMedida();
                    Float valor = listaDeBebidas.get(i).getValor();

                    System.out.println("Id: " + id + ", nome: " + nome + ", medida: " + medida + ", valor: " + valor);
                }

                while(true){
                    System.out.println("");
                    System.out.println("Agora digite o id da bebida que deseja: ");

                    Integer bebidaId = scanner.nextInt();

                    total = total + listaDePizzas.get(bebidaId).getValor();

                    System.out.println("");
                    System.out.println("Quer mais uma?");
                    System.out.println("");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.println("Resposta: ");

                    Integer op22 = scanner.nextInt();

                    if(op22 == 2){
                        break;
                    }
                }
            }

            System.out.println("");
            System.out.println("Deseja pedir uma sobremesa?");
            System.out.println("");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.println("Resposta: ");

            Integer op3 = scanner.nextInt();

            if(op3 == 1){
                System.out.println("");
                System.out.println("Sobremesas:");
                System.out.println("");

                for(int i = 0; i < listaDeSobremesas.size(); i++){
                    Long id = listaDeSobremesas.get(i).getId();
                    String nome = listaDeSobremesas.get(i).getNome();
                    Float valor = listaDeSobremesas.get(i).getValor();

                    System.out.println("Id: " + id + ", nome: " + nome + ", valor: " + valor);
                }

                while(true){
                    System.out.println("");
                    System.out.println("Agora digite o id da sobremesa que deseja: ");

                    Integer sobremesaId = scanner.nextInt();

                    total = total + listaDePizzas.get(sobremesaId).getValor();

                    System.out.println("");
                    System.out.println("Quer mais uma?");
                    System.out.println("");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.println("Resposta: ");

                    Integer op32 = scanner.nextInt();

                    if(op32 == 2){
                        break;
                    }
                }
            }

            System.out.println("");
            System.out.println("Quer finalizar seu pedido?");
            System.out.println("");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.println("Resposta: ");

            Integer op4 = scanner.nextInt();

            if(op4 == 1){
                break;
            }
        }

        System.out.println("");
        System.out.println("Total do pedido: " + total);
    }
}
