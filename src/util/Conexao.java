package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/bancod";
    private String usuario = "bancod";
    private String senha = "dbaHotel123";

    public Connection conectar() {
        Connection condb = null;
        try {
            // Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)
            Class.forName(driver);

            /* Iniciar o driver já carregado por meio
             do metodo getConnection(IP, porta, nome do banco, usuario, senha)*/
            DriverManager.getConnection(url, usuario, senha);
        }
        catch (SQLException erro) {
            System.out.println("Erro ao conectar ao Banco de Dados: " + erro);
            return null;
        }
    }
}