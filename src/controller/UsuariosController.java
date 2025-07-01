package controller;

import dao.UsuariosDAO;
import model.Usuarios;

public class UsuariosController {

    /*Construtor para inicializar objeto UsuarioController()Ao inicializá-lo,o construtor de UsuarioDao() será executado,
     o que significa que a camada de Controle estará verificandose os parametros
    necessarios foram informandos para que sejam enviados ás requesições (package DAO)*/
    private final UsuariosDAO usuariosDAO;

    public UsuariosController(){
        this.usuariosDAO = new UsuariosDAO();
    }
    public boolean verificarCredenciais(String email, String senha){
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()){
            return false;}
        Usuarios usuario = new Usuarios("",email,senha, 0);
        return usuariosDAO.autenticarUsuario(usuario);
    }
}
