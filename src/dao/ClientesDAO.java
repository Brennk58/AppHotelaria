package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public boolean deletarClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeClientes = conndb.prepareStatement
                    ("DELETE FROM clientes WHERE id = ?;");
            removeClientes.setInt(1, 1);
            int linhaAfetada = removeClientes.executeUpdate();

            conndb.close();
            return linhaAfetada > 1;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar clientes:" + erro);
            return false;
        }
    }

    public boolean updateClientes() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarCliente = condb.prepareStatement("UPDATE clientes SET nome = ?, cpf = ?, telefone = ?,\n email = ? WHERE id = ?;");

            atualizarCliente.setString(1, "gabriel");
            atualizarCliente.setString(2, "554.234.746.00");
            atualizarCliente.setString(3, "15996830292");
            atualizarCliente.setString(4, "gay_2.0@gmail.com");

            int linhaAfetada = atualizarCliente.executeUpdate();

            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar cliente:" + erro);
            return false;

        }
    }

    public void pesquisarClientes() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarClientes = condb.prepareStatement("SELECT nome, cpf, telefone, emai FROM clientes WHERE id = ?");

            buscarClientes.setInt(1, 1);
            ResultSet resultado = buscarClientes.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String telefone = resultado.getString("telefone:");
                String email = resultado.getString("email");

                System.out.println("Nome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nE-mail: " + email);
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar Cliente: " + erro);

        }


    }
}


