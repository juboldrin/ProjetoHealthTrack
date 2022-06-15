package br.com.fiap.atividade;

import java.time.LocalDate;

public class Atividade {
    private String cdAtividade;
    private String txDescricao;
    private double vlrCalorias;
    private LocalDate dataRegistro;
    private String cdUsuario;

    public Atividade(String cdAtividade, String txDescricao, double vlrCalorias,
                     LocalDate dataRegistro, String cdUsuario) {
        this.cdAtividade = cdAtividade;
        this.txDescricao = txDescricao;
        this.vlrCalorias = vlrCalorias;
        this.dataRegistro = dataRegistro;
        this.cdUsuario = cdUsuario;
    }

    public Atividade(String cdAtividade, String txDescricao, double vlrCalorias,
                     LocalDate dataRegistro) {
        this.cdAtividade = cdAtividade;
        this.txDescricao = txDescricao;
        this.vlrCalorias = vlrCalorias;
        this.dataRegistro = dataRegistro;
    }

    public String getCdAtividade() {
        return cdAtividade;
    }

    public void setCdAtividade(String cdAtividade) {
        this.cdAtividade = cdAtividade;
    }

    public String getTxDescricao() {
        return txDescricao;
    }

    public void setTxDescricao(String txDescricao) {
        this.txDescricao = txDescricao;
    }

    public double getVlrCalorias() {
        return vlrCalorias;
    }

    public void setVlrCalorias(double vlrCalorias) {
        this.vlrCalorias = vlrCalorias;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(String cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
}
