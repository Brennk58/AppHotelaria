package view;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelBotoes;
import view.components.Sidebar;

public class CadUsuario extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage janela) throws Exception {
        PainelBotoes buttons = new PainelBotoes();
        Sidebar menu = new Sidebar();

        BorderPane mainPainel = new BorderPane();
        mainPainel.setLeft(menu);

        Image iconUser = new Image(getClass().getResourceAsStream
                ("/img/logoUser.png"
                ));
        Image iconUsuario = new Image(getClass().getResourceAsStream
                ("/view/resources/img/cracha.png"
                ));


        ImageView viewiconUser = new ImageView(iconUser);
        viewiconUser.setFitWidth(40);
        viewiconUser.setFitHeight(40);
        viewiconUser.setOpacity(1);

        Label lblTitulo = new Label("Cadastro do Fucionario");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 25px; -fx-font-weight: bold");

        Label lblNome = new Label("Nome do Funcionario ");
        TextField txtNome = new TextField();

        Label lblEmail = new Label("E-mail do Funcionario ");
        TextField txtEmail = new TextField();

        Label lblSenha = new Label("Senha");
        TextField txtSenha = new TextField();

        Label lblSetor = new Label("Informe seu setor ");
        ComboBox<String> BoxSetor = new ComboBox<>();
        BoxSetor.setPromptText("Selecionar");
        BoxSetor.getItems().addAll("TI","ADM","Atendente","Limpeza","Gerente");

        GridPane FormGrid = new GridPane();
        FormGrid.add(txtNome,1,0);
        FormGrid.add(lblNome,0,0);

        FormGrid.add(txtEmail, 1, 1);
        FormGrid.add(lblEmail,0 ,1);

        FormGrid.add(txtSenha, 1,2);
        FormGrid.add(lblSenha,0,2);

        FormGrid.add(BoxSetor,1 ,3);
        FormGrid.add(lblSetor,0, 3);

        HBox tituloBox = new HBox(viewiconUser,lblTitulo);
        tituloBox.setSpacing(10);
        tituloBox.setPadding(new Insets(20, 20, 20,20));
        tituloBox.setAlignment(Pos.CENTER);


        FormGrid.setPadding(new Insets(20, 20, 20, 20));
        FormGrid.setHgap(10);
        FormGrid.setVgap(10);
        FormGrid.setAlignment(Pos.CENTER);

        FormGrid.add(buttons, 1, 4);

        VBox layout = new VBox(10,tituloBox, FormGrid);
        layout.setAlignment(Pos.CENTER);
        mainPainel.setCenter(layout);

        Scene scene = new Scene(mainPainel, 740, 400);
        janela.setTitle("Grand Hotel");
        janela.getIcons().add(iconUsuario);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }
}

