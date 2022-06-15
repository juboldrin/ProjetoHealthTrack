package com.br.projetohealthtrack.usuario;

import com.br.projetohealthtrack.medidasusuario.Peso;

import java.util.List;

/**
 * Classe de domínio da Entidade usuário
 */
public class Usuario {

    private String nomeCompleto;
    private String dataNascimento;
    private String genero;
    private double altura;
    private List<Peso> pesos;
    private String email;
    private String senha;

    /**
     * @param nomeCompleto   Nome completo da pessoa
     * @param dataNascimento Data de nascimento da pessoa
     * @param genero         Gênero (masculino ou Feminino)
     * @param altura         Altura da pessoa em metros
     * @param email          Endereço de e-mail
     * @param senha          Senha de acesso da pessoa
     */
    public Usuario(String nomeCompleto, String dataNascimento, String genero, double altura,
                   String email, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.altura = altura;
        this.email = email;
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", genero='" + genero + '\'' +
                ", altura=" + altura +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
