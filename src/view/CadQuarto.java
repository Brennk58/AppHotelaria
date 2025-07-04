package view;

import controller.QuartosController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelBotoes;
import view.components.Sidebar;

import javax.swing.*;
import java.awt.*;

public class CadQuarto extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage janela) throws Exception {
        PainelBotoes buttons = new PainelBotoes();
        Sidebar menu = new Sidebar();


        Image iconCama = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icons8-cama-64.png"
                ));


        ImageView viewIconCama = new ImageView(iconCama);
        viewIconCama.setFitWidth(40);
        viewIconCama.setFitHeight(40);
        viewIconCama.setOpacity(1);

        Label lblTitulo = new Label("Cadastro dos Quartos");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 30px; -fx-font-weight: bold");

        Label lblsubtitulo = new Label("Adicione as Info rmações do Quarto");
        lblsubtitulo.setAlignment(Pos.CENTER);
        lblsubtitulo.setStyle("-fx-font-size: 12px; -fx-font-weight: bold");

        BorderPane mainPainel = new BorderPane();
        mainPainel.setLeft(menu);

        Label lblNome = new Label("Nome:");
        TextField txtNome = new TextField();

        Label lblNumero = new Label("Numero:");
        TextField txtNumero= criarMascaraCampo("(##) #####-####");

        Label lblPreco = new Label("Preço:");
        TextField txtPreco = criarMascaraCampo("R$###,##");

        Label lblSol = new Label("Cama de Solterio");
        Spinner <Integer> spinnerQuantidadeSolteiro = new Spinner(0,3,0);
        spinnerQuantidadeSolteiro.setStyle("-fx-background-color: #D6C388FF;" +
                " -fx-border-width: 2px; -fx-border-radius: 5px;");
        spinnerQuantidadeSolteiro.setMaxWidth(100);

        Label lblCasal = new Label("Cama de Casal");
        Spinner <Integer>spinnerQuantidadeCasal = new Spinner(0,2,0);
        spinnerQuantidadeCasal.setStyle("-fx-background-color: #D6C388FF;" +
                " -fx-border-width: 2px; -fx-border-radius: 5px;");
        spinnerQuantidadeCasal.setMaxWidth(100);

        ComboBox<String> BoxQuatos = new ComboBox<>();
        BoxQuatos.setPromptText("Tipo de Quarto");
        BoxQuatos.setStyle("-fx-background-color: #D6C388FF ");
        BoxQuatos.getItems().addAll("Solteiro","Casal",
                "Suite","Suite Master","Luxuoso");

        ComboBox<String> BoxDisponivel = new ComboBox<>();
        BoxDisponivel.setPromptText("Disponivel");
        BoxDisponivel.setStyle("-fx-background-color: #D6C388FF ");
        BoxDisponivel.getItems().addAll("Disponivel","Indisponivel");


        GridPane FormGrid = new GridPane();
        FormGrid.add(txtNome,1,0); FormGrid.add(lblNome,0,0); FormGrid.add(BoxQuatos,2,0);

        FormGrid.add(txtNumero, 1, 1); FormGrid.add(lblNumero,0 ,1);

        FormGrid.add(txtPreco, 1,2); FormGrid.add(lblPreco,0,2);

        FormGrid.add(spinnerQuantidadeSolteiro,1,3); FormGrid.add(lblSol,0,3);

        FormGrid.add(spinnerQuantidadeCasal,1,4); FormGrid.add(lblCasal,0,4);

        FormGrid.add(BoxDisponivel,1,5);

        FormGrid.add(buttons,1,6);


        FormGrid.setPadding(new Insets(20, 20, 20, 20));
        FormGrid.setHgap(10);
        FormGrid.setVgap(10);
        FormGrid.setAlignment(Pos.CENTER);

        HBox tituloBox = new HBox(viewIconCama,lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);
        tituloBox.setPadding(new Insets(20, 20, 20,20));
        tituloBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,tituloBox,lblsubtitulo,FormGrid);
        layout.setAlignment(Pos.CENTER);
        mainPainel.setCenter(layout);

        Scene scene = new Scene(mainPainel, 900, 450);
        janela.setTitle("Grand Hotel");
        janela.getIcons().add(iconCama);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();

        buttons.btnCadastrar.setOnAction(evento -> {
            String nome = txtNome.getText();
            String numero = txtNumero.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int qntsolt = spinnerQuantidadeSolteiro.getValue();
            int qntcasal = spinnerQuantidadeCasal.getValue();

            String disponivel = (String) BoxDisponivel.getSelectionModel().getSelectedItem();

            boolean isDisponivel;
            if (disponivel.equals("Disponivel")){
                isDisponivel = true;
            }else {
                isDisponivel = false;
            }
            QuartosController quartosController = new QuartosController();
            boolean sucessoQuartos = quartosController.verificarInforQuartos(nome,numero,qntcasal,qntsolt,preco,isDisponivel);
            if (sucessoQuartos){
                System.out.println("Cadastro efetuado com sucesso!");
            }else {
                System.out.println("Não foi possivel cadastrar o quartos");
            }

        });
        

    }
    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }

}
