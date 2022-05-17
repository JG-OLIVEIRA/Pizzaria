package com.sensezzaria.entidades;

public class Pizza {
     private Long id;
     private String sabor;
     private Integer tamanho;
     private Float valor;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
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

     public Float getValor() {
          return valor;
     }

     public void setValor(Float valor) {
          this.valor = valor;
     }
}
