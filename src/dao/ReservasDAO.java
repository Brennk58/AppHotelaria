package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirReservas(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoReservas = condb.prepareStatement("INSERT INTO reserva () VALUES (?, ?, ?, ?);");
            novoReservas.setString(1,"Breno");
            novoReservas.setString(2,"");
            novoReservas.setString(3,"Breno");
            novoReservas.setString(4,"Breno");
            int LinhaAfetada = novoReservas.executeUpdate();
            return LinhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir reserva:" + erro);
            return false;

        }
    }
}


