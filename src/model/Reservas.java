package model;

import java.util.Date;

public class Reservas {
    int idReserva;
    int pedido_id;
    int quarto_id;
    int adicional_id;
    Date fim, inicio;

    public Reservas(int pedido_id, int quarto_id, int adicional_id, Date fim, Date inicio) {
        this.pedido_id = pedido_id;
        this.quarto_id = quarto_id;
        this.adicional_id = adicional_id;
        this.fim = fim;
        this.inicio = inicio;
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public int getPedido_id() {
        return pedido_id;
    }
    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }
    public int getQuarto_id() {
        return quarto_id;
    }
    public void setQuarto_id(int quarto_id) {
        this.quarto_id = quarto_id;
    }
    public int getAdicional_id() {
        return adicional_id;
    }
    public void setAdicional_id(int adicional_id) {
        this.adicional_id = adicional_id;
    }
    public Date getFim() {
        return fim;
    }
    public void setFim(Date fim) {
        this.fim = fim;
    }
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
}
