package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}

