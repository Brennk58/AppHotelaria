package dao;

import com.mysql.cj.protocol.Resultset;
import model.Usuarios;
import util.Conexao;

import java.sql.ResultSet;
import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class UsuariosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirUsuarios() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoUsuario = condb.prepareStatement("INSERT INTO usuarios (nome, email, senha, role_id) VALUES (?, ?, md5(?), ?);");

            novoUsuario.setString(1, "Breno");
            novoUsuario.setString(2, "breno@gmail.com");
            novoUsuario.setString(3, "1234");
            novoUsuario.setInt(4, 1);


            int linhaAfetada = novoUsuario.executeUpdate();

            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;

        }
    }

    public boolean deletarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeUsuario = conndb.prepareStatement
                    ("DELETE FROM usuarios WHERE id = ?;");
            removeUsuario.setInt(1, 1);
            int linhaAfetada = removeUsuario.executeUpdate();

            conndb.close();
            return linhaAfetada > 1;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;
        }
    }

    public boolean updateUsuarios() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarUsuario = condb.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = md5(?), role_id = ? WHERE id = ?;");

            atualizarUsuario.setString(1, "pedro");
            atualizarUsuario.setString(2, "pedro@gmail.com");
            atualizarUsuario.setString(3, "pedrodoido");
            atualizarUsuario.setInt(4, 1);
            atualizarUsuario.setInt(5, 7);

            int linhaAfetada = atualizarUsuario.executeUpdate();

            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar usuario:" + erro);
            return false;

        }
    }
    public boolean autenticarUsuario(Usuarios usuario) {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement stmt = condb.prepareStatement("SELECT nome " + " FROM usuarios WHERE email = ? AND senha = md5(?);");

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            ResultSet resultado = stmt.executeQuery();

            boolean acessoAutorizado = resultado.next();
                String nome = resultado.getString("nome");
                System.out.println("Olá, Seja Bem-vindo," + nome);
            condb.close();
            return acessoAutorizado;

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
            return false ;

        }

    }
}

