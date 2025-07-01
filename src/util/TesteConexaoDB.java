package util;
import controller.UsuariosController;


import java.sql.Connection;


public class TesteConexaoDB {
    public static void main(String[] args){
        Conexao conexao = new Conexao();
        UsuariosController usuariosController = new UsuariosController();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                /*UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuariosDAO.inserirUsuarios();
                System.out.println("Usario inserido com sucesso!");*/

                usuariosController.verificarCredenciais("breno@gmail.com","1234");
                condb.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão:" + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }

}
