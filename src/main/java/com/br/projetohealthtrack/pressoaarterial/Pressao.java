package com.br.projetohealthtrack.pressoaarterial;

import java.time.LocalDate;

public class Pressao {
    private String cdPressaoArterial;
    private int vlrDiastolica;
    private int vlrSistolica;
    private LocalDate dtRegistro;
    private String txSituacao;
    private String cdUsuario;

    public Pressao(String cdPressaoArterial, int vlrDiastolica, int vlrSistolica,
                   LocalDate dtRegistro, String txSituacao) {
        this.cdPressaoArterial = cdPressaoArterial;
        this.vlrDiastolica = vlrDiastolica;
        this.vlrSistolica = vlrSistolica;
        this.dtRegistro = dtRegistro;
        this.txSituacao = txSituacao;
    }

    public Pressao(String cdPressaoArterial, int vlrDiastolica, int vlrSistolica,
                   LocalDate dtRegistro, String txSituacao, String cdUsuario) {
        this.cdPressaoArterial = cdPressaoArterial;
        this.vlrDiastolica = vlrDiastolica;
        this.vlrSistolica = vlrSistolica;
        this.dtRegistro = dtRegistro;
        this.txSituacao = txSituacao;
        this.cdUsuario = cdUsuario;
    }

    public String getCdPressaoArterial() {
        return cdPressaoArterial;
    }

    public void setCdPressaoArterial(String cdPressaoArterial) {
        this.cdPressaoArterial = cdPressaoArterial;
    }

    public int getVlrDiastolica() {
        return vlrDiastolica;
    }

    public void setVlrDiastolica(int vlrDiastolica) {
        this.vlrDiastolica = vlrDiastolica;
    }

    public int getVlrSistolica() {
        return vlrSistolica;
    }

    public void setVlrSistolica(int vlrSistolica) {
        this.vlrSistolica = vlrSistolica;
    }

    public LocalDate getDtRegistro() {
        return dtRegistro;
    }

    public void setDtRegistro(LocalDate dtRegistro) {
        this.dtRegistro = dtRegistro;
    }

    public String getTxSituacao() {
        return txSituacao;
    }

    public void setTxSituacao(String txSituacao) {
        this.txSituacao = txSituacao;
    }

    public String getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(String cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
}
