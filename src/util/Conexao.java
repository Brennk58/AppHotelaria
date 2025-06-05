package util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    private String driver ;
    private String url ;
    private String usuario ;
    private String senha ;

    public Conexao() {
        carrgarConfiguraçoes();

    }
    private void carrgarConfiguraçoes(){
        Properties props = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream
                ("config.properties")) {
            props.load(inputPropsConfig);
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            usuario = props.getProperty("usuario");
            senha = props.getProperty("senha");

        }
        catch (IOException erro){
            System.out.println("Erro ao carregar configurações: "+ erro.getMessage());
        }
    }

    public Connection conectar() {
        Connection condb = null;
        try {
            // Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)
            Class.forName(driver);

            /* Iniciar o driver já carregado por meio
             do metodo getConnection(IP, porta, nome do banco, usuario, senha)*/
            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;
        }
        catch (SQLException erro) {
            System.out.println("Erro ao conectar ao Banco de Dados: " + erro);
            return null;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}