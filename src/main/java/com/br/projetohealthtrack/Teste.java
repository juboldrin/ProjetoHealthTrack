package com.br.projetohealthtrack;

import com.br.projetohealthtrack.alimento.Alimento;
import com.br.projetohealthtrack.alimento.AlimentoDAO;
import com.br.projetohealthtrack.atividade.Atividade;
import com.br.projetohealthtrack.atividade.AtividadeDAO;
import com.br.projetohealthtrack.medidasusuario.*;
import com.br.projetohealthtrack.pressoaarterial.Pressao;
import com.br.projetohealthtrack.pressoaarterial.PressaoDAO;

import java.time.LocalDate;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        AlimentoDAO alimentoDAO = new AlimentoDAO();
        List<Alimento> listaAlimentosBuscado = alimentoDAO.getAll();
        Alimento alimento = new Alimento("uyewr6", "Alimento rico em proteína", 10.0,
                                         LocalDate.now(), "001a");
        alimentoDAO.insert(alimento);

        AtividadeDAO atividadeDAO = new AtividadeDAO();
        List<Atividade> listaAtividadesBuscadas = atividadeDAO.getAll();
        Atividade atividade = new Atividade("98fg", "Atividade crossfiteira", 1000.0,
                                            LocalDate.now(), "001a");
        atividadeDAO.insert(atividade);

        PesoDAO pesoDAO = new PesoDAO();
        List<Peso> listaPeso = pesoDAO.getAll("001a");
        pesoDAO.insert(new Peso("001", 100.0, LocalDate.now()));

        AlturaDAO alturaDAO = new AlturaDAO();
        List<Altura> listaAltura = alturaDAO.getAll("001a");
        alturaDAO.insert(new Altura("001", 1.70, LocalDate.now()));

        PressaoDAO pressaoDAO = new PressaoDAO();
        List<Pressao> listaPressaoArterial = pressaoDAO.getAll("001a");
        pressaoDAO.insert(new Pressao("o9834", 14, 8, LocalDate.now(), "Pressão Alta"));
    }
}
