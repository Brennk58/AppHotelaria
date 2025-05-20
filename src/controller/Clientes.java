package controller;

public class Clientes extends Pessoa {

//Declaração de uma variável própria da classe Cliente
private int  idCliente;
private String email, telefone;

    public Clientes(String nome, String cpf, String email, String telefone) {
        super(nome, cpf);
            this.email = email;
            this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public String getTelefone() {
            return telefone;
    }
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
