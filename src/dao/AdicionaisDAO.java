package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}


