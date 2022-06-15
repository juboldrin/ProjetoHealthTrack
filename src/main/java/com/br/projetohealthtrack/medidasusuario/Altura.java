package com.br.projetohealthtrack.medidasusuario;

import java.time.LocalDate;

public class Altura {
    private String cdAltura;
    private double vlrAltura;
    private LocalDate dtRegistro;
    private String cdImc;

    public Altura(String cdAltura, double vlrAltura, LocalDate dtRegistro) {
        this.cdAltura = cdAltura;
        this.vlrAltura = vlrAltura;
        this.dtRegistro = dtRegistro;
    }

    public Altura(String cdAltura, double vlrAltura, LocalDate dtRegistro, String cdImc) {
        this.cdAltura = cdAltura;
        this.vlrAltura = vlrAltura;
        this.dtRegistro = dtRegistro;
        this.cdImc = cdImc;
    }

    public String getCdAltura() {
        return cdAltura;
    }

    public void setCdAltura(String cdAltura) {
        this.cdAltura = cdAltura;
    }

    public double getVlrAltura() {
        return vlrAltura;
    }

    public void setVlrAltura(double vlrAltura) {
        this.vlrAltura = vlrAltura;
    }

    public LocalDate getDtRegistro() {
        return dtRegistro;
    }

    public void setDtRegistro(LocalDate dtRegistro) {
        this.dtRegistro = dtRegistro;
    }

    public String getCdImc() {
        return cdImc;
    }

    public void setCdImc(String cdImc) {
        this.cdImc = cdImc;
    }
}
