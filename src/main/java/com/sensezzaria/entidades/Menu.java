package com.sensezzaria.entidades;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Bem vindo ao menu principal!");
        System.out.println("");
        System.out.println("Aqui temos pizzas, bebidas e sobremesas.");
        System.out.println("");
        System.out.println("Pizzas:");
        System.out.println("");
        System.out.println("Id      Sabor                   Valor");
        System.out.println("");
        System.out.println("                            Grande  Broto");
        System.out.println("");
        System.out.println("1      Mussarela            67,00        ");
        System.out.println("2      Mussarela                    36,00");
        System.out.println("3      Margherita           70,00        ");
        System.out.println("4      Margherita                   37,00");
        System.out.println("5      Caprese              76,00        ");
        System.out.println("6      Caprese                      40,00");
        System.out.println("7      Três Queijos         77,00        ");
        System.out.println("8      Três Queijos                 47,00");
        System.out.println("9      Quatro Queijos       83,00        ");
        System.out.println("10     Quatro Queijos               50,00");
        System.out.println("");
        System.out.println("Bebidas:");
        System.out.println("");
        System.out.println("Id      Nome               Valor        Medida");
        System.out.println("");
        System.out.println("1       Coca-cola          3,50         250ml");
        System.out.println("2       Coca-cola          7,00         1L");
        System.out.println("3       Guaraná            2,50         250ml");
        System.out.println("4       Guaraná            6,50         1L");
        System.out.println("5       Skol-Beats         4,50         350ml");
        System.out.println("");
        System.out.println("Sobremesa:");
        System.out.println("");
        System.out.println("Id      Nome               Valor");
        System.out.println("");
        System.out.println("1       Bolo               3,50");
        System.out.println("2       Pudim              2,50");
    }
}
