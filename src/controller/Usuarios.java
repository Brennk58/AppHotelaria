package controller;

public class Usuarios extends Pessoa {
   private int idUsuario;
    private String email, senha;


    public Usuarios(String nome, String cpf, String email, String senha) {
        super(nome, cpf);
        this.email = email;
        this.senha = senha;
    }
     public int getIdUsuario() {
        return idUsuario;
     }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}