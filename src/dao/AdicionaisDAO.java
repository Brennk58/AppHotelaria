package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoAdicionais = condb.prepareStatement("INSERT INTO adicionais (nome, preco) VALUES (?, ?);");

            novoAdicionais.setString(1,"bebê reborn ");
            novoAdicionais.setDouble(2,949.99);
            int LinhaAfetada = novoAdicionais.executeUpdate();
            return LinhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir adicionaios:" + erro);
            return false;

        }
    }
    public boolean deletarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeAdicionais = conndb.prepareStatement
                    ("DELETE FROM adicionais WHERE id = ?;");
            removeAdicionais.setInt(1, 1);
            int linhaAfetada = removeAdicionais.executeUpdate();

            conndb.close();
            return linhaAfetada > 1;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar adicionais:" + erro);
            return false;
        }
    }
    public boolean updateAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarAdicionais = condb.prepareStatement("UPDATE adicionais SET nome = ?, preco = ? WHERE id = ?;");

            atualizarAdicionais.setString(1,"corsa");
            atualizarAdicionais.setDouble(2,13000.00);

            int linhaAfetada = atualizarAdicionais.executeUpdate();

            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar adicionais:" + erro);
            return false;

        }
    }
    public void pesquisarAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarAdicionais = condb.prepareStatement("SELECT nome, preco" + " FROM adicionais WHERE id = ?");

            buscarAdicionais.setInt(1, 1);
            ResultSet resultado = buscarAdicionais.executeQuery();


            while (resultado.next()) {
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");
                System.out.println("Nome: " + nome + "\nPreço: " + preco);
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar Adicionais : " + erro);

        }

    }

}


