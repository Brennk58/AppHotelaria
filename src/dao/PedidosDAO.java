package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoPedido = condb.prepareStatement("INSERT INTO pedidos (data_pedido, pagamento, usuario_id, cliente_id) VALUES (?, ?, ?, ?);");

            novoPedido.setString(1, "05/06/2025");
            novoPedido.setString(2, "credito");
            novoPedido.setString(3, "1");
            novoPedido.setString(4, "1");
            int LinhaAfetada = novoPedido.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir pedido:" + erro);
            return false;

        }
    }
    public boolean deletarPedidos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removePedidos = conndb.prepareStatement
                    ("DELETE FROM pedidos WHERE id = ?;");
            removePedidos.setInt(1, 1);
            int linhaAfetada = removePedidos.executeUpdate();

            conndb.close();
            return linhaAfetada > 1;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar pedido:" + erro);
            return false;
        }
    }

    public boolean updatePedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarPedidos = condb.prepareStatement("UPDATE pedidos SET data_pedido = ?, pagamento = ?, usuario_id = ?, cliente_id = ? WHERE id = ?;");

            atualizarPedidos.setString(1, "01/09/2025");
            atualizarPedidos.setString(2, "pix");
            atualizarPedidos.setString(3, "1");
            atualizarPedidos.setString(4, "1");

            int linhaAfetada = atualizarPedidos.executeUpdate();

            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar pedido:" + erro);
            return false;

        }
    }
    public void pesquisarPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarPedidos = condb.prepareStatement("SELECT pagamento FROM pedidos WHERE id = ?");

            buscarPedidos.setInt(1, 1);
            ResultSet resultado = buscarPedidos.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("Pagamento:");
                System.out.println("Nome: " + nome);
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar pedidos: " + erro);

        }

    }
}

