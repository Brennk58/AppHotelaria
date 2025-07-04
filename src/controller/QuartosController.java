package controller;

import dao.QuartosDAO;
import model.Quartos;

public class QuartosController {
    private final QuartosDAO quartosDAO;

    public QuartosController() {
        this.quartosDAO = new QuartosDAO();
    }

    public boolean verificarInforQuartos(String nome, String numero, int qtd_cama_casal, int qtd_cama_solteiro, double preco, boolean disponivel) {

        Quartos quarto = new Quartos(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel);
        quartosDAO.inserirQuartos(quarto);
        
        return false;

    }


}


