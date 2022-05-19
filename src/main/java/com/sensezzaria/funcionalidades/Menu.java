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

        List<Pizza> listaDePizzas = cardapio.getPizzas();
        List<Bebida> listaDeBebidas = cardapio.getBebidas();
        List<Sobremesa> listaDeSobremesas = cardapio.getSobremessas();

        System.out.println("Bem-vindo a Sensezzaria!");
        System.out.println("Faça seu pedido!");

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

        System.out.println("");
        System.out.println("Sobremesas:");
        System.out.println("");

        for(int i = 0; i < listaDeSobremesas.size(); i++){
            Long id = listaDeSobremesas.get(i).getId();
            String nome = listaDeSobremesas.get(i).getNome();
            Float valor = listaDeSobremesas.get(i).getValor();

            System.out.println("Id: " + id + ", nome: " + nome + ", valor: " + valor);
        }
    }
}
