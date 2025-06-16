package util;
import dao.*;

import java.sql.Connection;


public class TesteConexaoDB {
    public static void main(String[] args){
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                /*UsuariosDAO usuarioDAO = new UsuariosDAO();
                usuarioDAO.pesquisarUsuario();
                System.out.println("Usuario Pesquisado com sucesso!");*/

                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.pesquisarAdicionais();
                System.out.println("Adicionais inserido com sucesso!");

                /*ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.inserirClientes();
                System.out.println("Cliente inserido com sucesso!");*/

                /*QuartosDAO quartosDAO = new QuartosDAO();
                quartosDAO.inserirQuartos();
                System.out.println("Quarto inserido com sucesso!");*/

                /*CargosDAO cargosDAO = new CargosDAO();
                cargosDAO.inserirCargos();
                System.out.println("Cargo inserido com sucesso!");*/

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
