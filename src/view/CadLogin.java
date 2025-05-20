package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class CadLogin extends Application {
    private boolean senhavisivel = false;
    @Override
    public void start(Stage janela) {



        // Left side with image
        ImageView photohotel = new ImageView(
                new Image("/view/resources/img/imagem.jpg"));
        Image iconUser = new Image(getClass().getResourceAsStream
                ("/view/resources/img/iconUser.png"
                ));
        Image iconDatela = new Image(getClass().getResourceAsStream(
                "/view/resources/img/logoUser.png"
        ));
        Image eyeOpen = new Image(getClass().getResourceAsStream(
                "/view/resources/img/olhoAberto.png"
        ));
        Image eyeClosed = new Image(getClass().getResourceAsStream(
                "/view/resources/img/olho.png"
        ));
        //Visualização da imagen
        ImageView ViewEyeOpen = new  ImageView(eyeOpen);
        ViewEyeOpen.setFitWidth(20);
        ViewEyeOpen.setFitHeight(20);

        ImageView ViewEyeClose =  new ImageView(eyeClosed);
        ViewEyeClose.setFitWidth(20);
        ViewEyeClose.setFitHeight(20);

        ImageView viewconUser = new ImageView(iconUser);
        viewconUser.setFitWidth(100);
        viewconUser.setFitHeight(100);
        viewconUser.setOpacity(1);

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(photohotel);

        TextField txtEmail = new TextField();

        PasswordField senha = new PasswordField();
        senha.setPromptText("Digite sua Senha");

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("digite sua senha");
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);

        Button toggleBtn =  new  Button();
        toggleBtn.setGraphic(ViewEyeOpen);
        toggleBtn.setGraphic(ViewEyeClose);
        toggleBtn.setStyle("-fx-background-color: transparent;");

        toggleBtn.setOnAction(evento -> {
            // se a senha esta visivel, ou seja,senhaVisivel = true
            if (senhavisivel){
                // seta o texto de txtSenha (visivel) para senha (passwordField)
                senha.setText(txtSenha.getText());
                // Exibe novamente senha (passwordField) e o inclui no layout
                senha.setVisible(true);
                senha.setManaged(true);
                // Oculta txtSenha (TextField) e o retira do layout para nao ocupar espaço
                txtSenha.setVisible(false);
                txtSenha.setManaged(false);
                /*Trocar o icone  do butão para o olho aberto, indicando que a senha
                * nao esta  */
                toggleBtn.setGraphic(ViewEyeOpen);
                //
                senhavisivel = false;
            }
            else {
                txtSenha.setText(senha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                senha.setVisible(false);
                senha.setManaged(false);
                toggleBtn.setGraphic(ViewEyeClose);
                senhavisivel = true;
            }


        });

        Button loginButton = new Button("Login");
        loginButton.setStyle(
                "-fx-background-color: #0000CD;" +
                "-fx-text-fill: #FFFFFF; " +
                "-fx-background-radius: 50px; " +
                "-fx-cursor: hand;");
        loginButton.setPrefHeight(10);
        loginButton.setPrefWidth(140);


        HBox BOX = new HBox(viewconUser,toggleBtn);
        BOX.setSpacing(10);
        BOX.setPadding(new Insets(20,20,20,65));
        BOX.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,BOX,senha,loginButton);
        layout.setAlignment(Pos.CENTER);


        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 950, 600);
        janela.setTitle("Grand Hotel");
        janela.getIcons().add(iconDatela);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


