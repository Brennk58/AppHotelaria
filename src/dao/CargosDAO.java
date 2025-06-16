package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CargosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargos(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCargo = condb.prepareStatement("INSERT INTO roles (nome) VALUES (?);");

            novoCargo.setString(1,"Chapeleiro");
            int LinhaAfetada = novoCargo.executeUpdate();
            return LinhaAfetada > 0;
        }catch (Exception erro) {
            System.out.println("Erro ao inserir cargo:" + erro);
            return false;
        }
    }
    public boolean deletarCargos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCargos = conndb.prepareStatement
                    ("DELETE FROM cargo WHERE id = ?;");
            removeCargos.setInt(1, 1);
            int linhaAfetada = removeCargos.executeUpdate();

            conndb.close();
            return linhaAfetada > 1;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar cargos:" + erro);
            return false;
        }
    }
    public boolean updateCargos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarCargo = condb.prepareStatement("UPDATE roles SET nome = ? WHERE id = ?;");

            atualizarCargo.setString(1,"Job");

            int linhaAfetada = atualizarCargo.executeUpdate();

            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar cargo:" + erro);
            return false;

        }
    }
    public void pesquisarCargos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarCargos = condb.prepareStatement("SELECT nome FROM roles WHERE id = ?");

            buscarCargos.setInt(1, 1);
            ResultSet resultado = buscarCargos.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                System.out.println("Cargo: " + nome );
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar Cargo: " + erro);

        }


    }

}


