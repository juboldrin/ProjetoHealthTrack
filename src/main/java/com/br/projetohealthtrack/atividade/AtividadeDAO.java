package br.com.fiap.atividade;

import br.com.fiap.db.DBManager;

import java.sql.Date;
import java.sql.*;
import java.util.*;

public class AtividadeDAO {

    private Connection conexao;

    public List<Atividade> getAll() {
        List<Atividade> listaAtividade = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        try {
            conexao = DBManager.criarConexao();
            preparedStatement = conexao.prepareStatement("SELECT * FROM t_atividade");

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String cdAtividade = rs.getString("cd_atividade");
                String txDescricao = rs.getString("tx_descricao");
                double vlrCalorias = rs.getDouble("vlr_calorias");
                Date dataRegistro = rs.getDate("dt_registro");
                Atividade atividade = new Atividade(cdAtividade, txDescricao, vlrCalorias,
                                                    dataRegistro.toLocalDate());
                listaAtividade.add(atividade);
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
        return listaAtividade;
    }

    public void insert(Atividade atividade) {
        PreparedStatement preparedStatement = null;

        try {
            conexao = DBManager.criarConexao();

            String sql =
                    "INSERT INTO T_ATIVIDADE (cd_atividade, tx_descricao, vlr_calorias, dt_registro) VALUES (?, ?, ?, ?, ?)) WHERE cd_usuario = ?";
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, atividade.getCdAtividade());
            preparedStatement.setString(2, atividade.getTxDescricao());
            preparedStatement.setDouble(3, atividade.getVlrCalorias());
            preparedStatement.setDate(4, Date.valueOf(atividade.getDataRegistro()));
            preparedStatement.setString(5, atividade.getCdUsuario());

            preparedStatement.executeUpdate();

            System.out.println("Atividade cadastrada com sucesso");

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
