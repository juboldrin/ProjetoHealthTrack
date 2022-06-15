package br.com.fiap.alimento;

import java.time.LocalDate;

public class Alimento {
    private String cdAlimento;
    private String txDescricao;
    private double vlrCalorias;
    private LocalDate dataConsumo;
    private String cdUsuario;

    public Alimento(String cdAlimento, String txDescricao, double vlrCalorias,
                    LocalDate dataConsumo, String cdUsuario) {
        this.cdAlimento = cdAlimento;
        this.txDescricao = txDescricao;
        this.vlrCalorias = vlrCalorias;
        this.dataConsumo = dataConsumo;
        this.cdUsuario = cdUsuario;
    }

    public Alimento(String cdAlimento, String txDescricao, double vlrCalorias,
                    LocalDate dataConsumo) {
        this.cdAlimento = cdAlimento;
        this.txDescricao = txDescricao;
        this.vlrCalorias = vlrCalorias;
        this.dataConsumo = dataConsumo;
    }

    public String getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(String cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getCdAlimento() {
        return cdAlimento;
    }

    public void setCdAlimento(String cdAlimento) {
        this.cdAlimento = cdAlimento;
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

    public LocalDate getDataConsumo() {
        return dataConsumo;
    }

    public void setDataConsumo(LocalDate dataConsumo) {
        this.dataConsumo = dataConsumo;
    }
}
