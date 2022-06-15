package br.com.fiap.medidasusuario;

import br.com.fiap.db.DBManager;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class AlturaDAO {
    private Connection conexao;


    public List<Altura> getAll(String cdUsuario) {
        List<Altura> listaAltura = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        try {
            conexao = DBManager.criarConexao();
            preparedStatement = conexao.prepareStatement(
                    "SELECT * FROM t_altura WHERE cd_imc = (SELECT cd_imc FROM T_IMC WHERE cd_usuario = ?) ORDER BY t_registro DESC");

            preparedStatement.setString(1, cdUsuario);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String cdAltura = rs.getString("cd_altura");
                double vlrAltura = rs.getDouble("vlr_altura");
                Date dtRegistro = rs.getDate("dt_registro");

                Altura altura = new Altura(cdAltura, vlrAltura, dtRegistro.toLocalDate());
                listaAltura.add(altura);
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
        return listaAltura;
    }

    public void insert(Altura altura) {
        PreparedStatement preparedStatement = null;

        try {
            conexao = DBManager.criarConexao();

            String sql =
                    "INSERT INTO T_PESO (cd_altura, vlr_altura, dt_registro, cd_imc) VALUES (?, ?, ?, ?) WHERE cd_imc = ?";
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, altura.getCdAltura());
            preparedStatement.setDouble(2, altura.getVlrAltura());
            preparedStatement.setDate(3, Date.valueOf(altura.getDtRegistro()));
            preparedStatement.setString(4, altura.getCdImc());

            preparedStatement.executeUpdate();

            System.out.println("Altura cadastrada com sucesso");

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
