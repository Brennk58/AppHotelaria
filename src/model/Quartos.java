package model;

public class Quartos {
    int idQuarto;
    String nome, numero;
    double  qtd_cama_casal, qtd_cama_solteiro, preco;
    boolean disponivel;

    public Quartos(int idQuarto, String nome, String numero, double qtd_cama_casal, double qtd_cama_solteiro, boolean disponivel) {
        this.idQuarto = idQuarto;
        this.nome = nome;
        this.numero = numero;
        this.qtd_cama_casal = qtd_cama_casal;
        this.qtd_cama_solteiro = qtd_cama_solteiro;
        this.disponivel = disponivel;
    }
    public int getIdQuarto() {
        return idQuarto;
    }

    public String getNome() {
        return nome;
    }
    public String getNumero() {
        return numero;
    }
    public double getQtd_cama_casal() {
        return qtd_cama_casal;
    }
    public double getQtd_cama_solteiro() {
        return qtd_cama_solteiro;
    }
    public double getPreco() {
        return preco;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setQtd_cama_casal(double qtd_cama_casal) {
        this.qtd_cama_casal = qtd_cama_casal;
    }
    public void setQtd_cama_solteiro(double qtd_cama_solteiro) {
        this.qtd_cama_solteiro = qtd_cama_solteiro;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
