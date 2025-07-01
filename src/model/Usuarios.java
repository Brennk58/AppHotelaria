package model;

public class Usuarios extends Pessoa {
   private int role_id;
    private String email, senha;


    public Usuarios(String nome, String email, String senha,int role_id) {
        super(nome,email);
        this.senha = senha;
        this.role_id = role_id;
    }
    public int getRole_id() {return role_id;}
    public String getSenha() {return senha;}

    public void setRole_id(int role_id) {this.role_id = role_id;}
    public void setSenha(String senha) {this.senha = senha;}

}