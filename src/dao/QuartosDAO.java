package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos (nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?, ?, ?, ?, ?, ?);");

            novoQuarto.setString(1, "Suite");
            novoQuarto.setString(2, "01");
            novoQuarto.setInt(3, 1);
            novoQuarto.setInt(4, 2);
            novoQuarto.setDouble(5,150.00);
            novoQuarto.setInt(6,1);

            int LinhaAfetada = novoQuarto.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto:" + erro);
            return false;

        }
    }

}


