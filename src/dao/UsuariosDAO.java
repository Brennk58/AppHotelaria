package dao;

import util.Conexao;

import java.sql.PreparedStatement;
import java.sql.Connection;

public class UsuariosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirUsuarios(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoUsuario = condb.prepareStatement("INSERT INTO usuarios (nome, email, senha, role_id) VALUES (?, ?, md5(?), ?);");

            novoUsuario.setString(1,"Breno");
            novoUsuario.setString(2, "breno@gmail.com");
            novoUsuario.setString(3,"Breno");
            novoUsuario.setInt(4,1);

            int LinhaAfetada = novoUsuario.executeUpdate();
            return LinhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;

        }
    }
}
