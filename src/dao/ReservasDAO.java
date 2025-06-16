package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservasDAO {
    private Conexao conexao = new Conexao();

    public boolean deletarReservas() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeReserva = conndb.prepareStatement
                    ("DELETE FROM reservas id = ?;");
            removeReserva.setInt(1, 1);
            int linhaAfetada = removeReserva.executeUpdate();

            conndb.close();
            return linhaAfetada > 1;

        } catch (Exception erro) {
            System.out.println("Erro ao deleta reserva:" + erro);
            return false;
        }
    }


}


