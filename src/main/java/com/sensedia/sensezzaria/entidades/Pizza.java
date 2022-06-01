package com.sensedia.sensezzaria.entidades;

public class Pizza extends Alimento{
     private String sabor;
     private Integer tamanho;

     public Pizza(){}

     public  Pizza(Long id, String sabor, Integer tamanho, Float valor){
          this.setId(id);
          this.sabor = sabor;
          this.tamanho = tamanho;
          this.setValor(valor);
     }

     public String getSabor() {
          return sabor;
     }

     public void setSabor(String sabor) {
          this.sabor = sabor;
     }

     public Integer getTamanho() {
          return tamanho;
     }

     public void setTamanho(Integer tamanho) {
          this.tamanho = tamanho;
     }

     @Override
     public String toString() {
          return "[Pizza: " + "Id: " + getId() + ", sabor: " + getSabor() + ", tamanho: " + getTamanho() + ", valor: R$" + getValor() + "]";
     }
}
