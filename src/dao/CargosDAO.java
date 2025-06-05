package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CargosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargos(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCargo = condb.prepareStatement("INSERT INTO roles (nome) VALUES (?);");

            novoCargo.setString(1,"Chapeleiro");
            int LinhaAfetada = novoCargo.executeUpdate();
            return LinhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir cargo:" + erro);
            return false;

        }
    }
}


