package br.com.fiap.medidasusuario;

import java.time.LocalDate;

public class Peso {
    private String cdPeso;
    private double vlrPeso;
    private LocalDate dtRegistro;
    private String cdImc;

    public Peso(String cdPeso, double vlrPeso, LocalDate dtRegistro) {
        this.cdPeso = cdPeso;
        this.vlrPeso = vlrPeso;
        this.dtRegistro = dtRegistro;
    }

    public Peso(String cdPeso, double vlrPeso, LocalDate dtRegistro, String cdImc) {
        this.cdPeso = cdPeso;
        this.vlrPeso = vlrPeso;
        this.dtRegistro = dtRegistro;
        this.cdImc = cdImc;
    }

    public String getCdPeso() {
        return cdPeso;
    }

    public void setCdPeso(String cdPeso) {
        this.cdPeso = cdPeso;
    }

    public double getVlrPeso() {
        return vlrPeso;
    }

    public void setVlrPeso(double vlrPeso) {
        this.vlrPeso = vlrPeso;
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
