package br.com.fiap.alimento;

import br.com.fiap.db.DBManager;

import java.sql.Date;
import java.sql.*;
import java.util.*;

public class AlimentoDAO {
    private Connection conexao;

    public List<Alimento> getAll() {
        List<Alimento> listaAlimento = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        try {
            conexao = DBManager.criarConexao();
            preparedStatement = conexao.prepareStatement("SELECT * FROM t_alimento");

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String cdAlimento = rs.getString("cd_alimento");
                String txDescricao = rs.getString("tx_descricao");
                double vlrCalorias = rs.getDouble("vlr_calorias");
                Date dataConsumo = rs.getDate("dt_consumo");
                Alimento alimento = new Alimento(cdAlimento, txDescricao, vlrCalorias,
                                                 dataConsumo.toLocalDate());
                listaAlimento.add(alimento);
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
        return listaAlimento;
    }

    public void insert(Alimento alimento) {
        PreparedStatement preparedStatement = null;

        try {
            conexao = DBManager.criarConexao();

            String sql =
                    "INSERT INTO T_ALIMENTO (cd_alimento, tx_descricao, vlr_calorias, dt_consumo) VALUES (?, ?, ?, ?, ?)) WHERE cd_usuario = ?";
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, alimento.getCdAlimento());
            preparedStatement.setString(2, alimento.getTxDescricao());
            preparedStatement.setDouble(3, alimento.getVlrCalorias());
            preparedStatement.setDate(4, Date.valueOf(alimento.getDataConsumo()));
            preparedStatement.setString(5, alimento.getCdUsuario());

            preparedStatement.executeUpdate();

            System.out.println("Alimento cadastrado com sucesso");

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
