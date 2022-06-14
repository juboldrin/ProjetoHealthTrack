package br.com.fiap.medidasusuario;

import br.com.fiap.db.DBManager;

import java.sql.Date;
import java.sql.*;
import java.util.*;

public class PesoDAO {
    private Connection conexao;


    public List<Peso> getAll(String cdUsuario) {
        List<Peso> listaPeso = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        try {
            conexao = DBManager.criarConexao();
            preparedStatement = conexao.prepareStatement(
                    "SELECT * FROM t_peso WHERE cd_imc = (SELECT cd_imc FROM T_IMC WHERE cd_usuario = ?) ORDER BY t_registro DESC");

            preparedStatement.setString(1, cdUsuario);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String cdPeso = rs.getString("cd_peso");
                double vlrPeso = rs.getDouble("vlr_peso");
                Date dtRegistro = rs.getDate("dt_registro");

                Peso peso = new Peso(cdPeso, vlrPeso, dtRegistro.toLocalDate());
                listaPeso.add(peso);
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
        return listaPeso;
    }

    public void insert(Peso peso) {
        PreparedStatement preparedStatement = null;

        try {
            conexao = DBManager.criarConexao();

            String sql =
                    "INSERT INTO T_PESO (cd_peso, vlr_peso, dt_registro, cd_imc) VALUES (?, ?, ?, ?) WHERE cd_imc = ?";
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, peso.getCdPeso());
            preparedStatement.setDouble(2, peso.getVlrPeso());
            preparedStatement.setDate(3, Date.valueOf(peso.getDtRegistro()));
            preparedStatement.setString(4, peso.getCdImc());

            preparedStatement.executeUpdate();

            System.out.println("Peso cadastrado com sucesso");

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
