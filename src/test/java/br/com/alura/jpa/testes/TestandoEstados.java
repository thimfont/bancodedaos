package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
    public static void main(String[] args) {
        //Transient
        Conta conta = new Conta();
        conta.setTitular("Isaque");
        conta.setAgencia(1212);
        conta.setNumero(1234);
    }
}
