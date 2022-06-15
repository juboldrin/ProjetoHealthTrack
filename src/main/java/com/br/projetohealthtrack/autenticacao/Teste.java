package com.br.projetohealthtrack.autenticacao;

public class Teste {

    public static void main(String[] args) {
        try {
            System.out.println(Cripto.criptografia("987654321"));
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

}
