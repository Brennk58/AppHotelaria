package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirClientes() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCliente = condb.prepareStatement("INSERT INTO clientes (nome, cpf, telefone, email) VALUES (?, ?, ?, ?);");

            novoCliente.setString(1, "Breno");
            novoCliente.setString(2, "554.846.746.59");
            novoCliente.setString(3, "15996583051");
            novoCliente.setString(4, "Brenk@gmail.com");
            int LinhaAfetada = novoCliente.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente:" + erro);
            return false;

        }
    }
}


