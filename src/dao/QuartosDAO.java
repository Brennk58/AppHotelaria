package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos (nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?, ?, ?, ?, ?, ?);");

            novoQuarto.setString(1, "Suite");
            novoQuarto.setString(2, "01");
            novoQuarto.setInt(3, 1);
            novoQuarto.setInt(4, 2);
            novoQuarto.setDouble(5,150.00);
            novoQuarto.setInt(6,1);

            int LinhaAfetada = novoQuarto.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto:" + erro);
            return false;

        }
    }
    public boolean deletarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuartos = conndb.prepareStatement
                    ("DELETE FROM quartos WHERE id = ?;");
            removeQuartos.setInt(1, 1);
            int linhaAfetada = removeQuartos.executeUpdate();

            conndb.close();
            return linhaAfetada > 1;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar quartos:" + erro);
            return false;
        }
    }
    public boolean updateQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarQuartos = condb.prepareStatement("UPDATE quartos SET nome = ?, numero = ?, qtd_cama_casal = ?, qtd_cama_solteiro = ?, preco = ?, disponivel = ? WHERE id = ?;");

            atualizarQuartos.setString(1, "Suite master");
            atualizarQuartos.setString(2, "02");
            atualizarQuartos.setInt(3, 1);
            atualizarQuartos.setInt(4, 2);
            atualizarQuartos.setDouble(5,580.00);
            atualizarQuartos.setInt(6,1);

            int linhaAfetada = atualizarQuartos.executeUpdate();

            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar quarto:" + erro);
            return false;

        }
    }
    public void pesquisarQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarQuartos = condb.prepareStatement("SELECT nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel" + " FROM quartos WHERE id = ?");

            buscarQuartos.setInt(1, 1);
            ResultSet resultado = buscarQuartos.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                int quantidadeCasal = resultado.getInt("camaCasal");
                int quantidadeSolteiro = resultado.getInt("camaSolteiro");
                double preco = resultado.getDouble("preço");
            String disponivel = resultado.getString("disponivel");

        System.out.println("Nome: " + nome + "\nNumero: " + numero + "\nCama Casal: " + quantidadeCasal + "\nCama Solteiro: " + quantidadeSolteiro + "\nPreço:" + preco + "\nDisponivel: " +  disponivel);
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto: " + erro);

        }

    }

}


