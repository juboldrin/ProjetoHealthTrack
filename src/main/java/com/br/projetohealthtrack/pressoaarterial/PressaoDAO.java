package com.br.projetohealthtrack.pressoaarterial;


import com.br.projetohealthtrack.db.DBManager;

import java.sql.Date;
import java.sql.*;
import java.util.*;

public class PressaoDAO {
    private Connection conexao;

    public List<Pressao> getAll(String cdUsuario) {
        List<Pressao> listaPressao = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        try {
            conexao = DBManager.criarConexao();
            preparedStatement = conexao.prepareStatement(
                    "SELECT * FROM T_PRESSAO_ARTERIAL WHERE cd_usuario = ?");
            preparedStatement.setString(1, cdUsuario);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String cdPressaoArterial = rs.getString("cd_pressao_arterial");
                int vlrDiastolica = rs.getInt("vlr_diastolica");
                int vlrSistolica = rs.getInt("vlr_sistolica");
                Date dataRegistro = rs.getDate("dt_registro");
                String txSituacao = rs.getString("tx_situacao");
                Pressao pressao = new Pressao(cdPressaoArterial, vlrDiastolica, vlrSistolica,
                                              dataRegistro.toLocalDate(), txSituacao);
                listaPressao.add(pressao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(preparedStatement).close();
                Objects.requireNonNull(rs).close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaPressao;
    }

    public void insert(Pressao pressao) {
        PreparedStatement preparedStatement = null;

        try {
            conexao = DBManager.criarConexao();

            String sql =
                    "INSERT INTO T_PRESSAO_ARTERIAL (cd_pressao_arterial, vlr_diastolica, vlr_sistolica, dt_registro, tx_situacao) VALUES (?, ?,?, ?), ?) WHERE cd_usuario = ?";
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, pressao.getCdPressaoArterial());
            preparedStatement.setInt(2, pressao.getVlrDiastolica());
            preparedStatement.setInt(3, pressao.getVlrSistolica());
            preparedStatement.setDate(4, Date.valueOf(pressao.getDtRegistro()));
            preparedStatement.setString(5, pressao.getTxSituacao());
            preparedStatement.setString(6, pressao.getCdUsuario());

            preparedStatement.executeUpdate();

            System.out.println("Pressao cadastrada com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(preparedStatement).close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
