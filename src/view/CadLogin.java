package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadLogin extends Application {
    private boolean senhaVisivel = false;

    @Override
    public void start(Stage janela) {
        // Carregar imagens
        ImageView photohotel = new ImageView(new Image("/view/resources/img/imagem.jpg"));
        photohotel.setFitWidth(450);
        photohotel.setFitHeight(500);
        photohotel.setPreserveRatio(true);

        Image iconUser = new Image(getClass().getResourceAsStream("/view/resources/img/iconUser.png"));
        Image iconDatela = new Image(getClass().getResourceAsStream("/view/resources/img/logoUser.png"));
        Image eyeOpen = new Image(getClass().getResourceAsStream("/view/resources/img/olhoAberto.png"));
        Image eyeClosed = new Image(getClass().getResourceAsStream("/view/resources/img/olho.png"));

        ImageView viewUserIcon = new ImageView(iconUser);
        viewUserIcon.setFitWidth(100);
        viewUserIcon.setFitHeight(100);

        ImageView viewEyeOpen = new ImageView(eyeOpen);
        viewEyeOpen.setFitWidth(20);
        viewEyeOpen.setFitHeight(20);

        ImageView viewEyeClosed = new ImageView(eyeClosed);
        viewEyeClosed.setFitWidth(20);
        viewEyeClosed.setFitHeight(20);

        // Campos de entrada
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Digite seu Email");
        txtEmail.setMaxWidth(200);

        PasswordField senha = new PasswordField();
        senha.setPromptText("Digite sua Senha");
        senha.setMaxWidth(250);

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua Senha");
        txtSenha.setMaxWidth(250);
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);

        // Botão de mostrar/ocultar senha
        Button toggleBtn = new Button();
        toggleBtn.setGraphic(viewEyeOpen);
        toggleBtn.setStyle("-fx-background-color: transparent;");

        toggleBtn.setOnAction(evento -> {
            if (senhaVisivel) {
                senha.setText(txtSenha.getText());
                senha.setVisible(true);
                senha.setManaged(true);
                txtSenha.setVisible(false);
                txtSenha.setManaged(false);
                toggleBtn.setGraphic(viewEyeOpen);
                senhaVisivel = false;
            } else {
                txtSenha.setText(senha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                senha.setVisible(false);
                senha.setManaged(false);
                toggleBtn.setGraphic(viewEyeClosed);
                senhaVisivel = true;
            }
        });

        // Botão de login
        Button loginButton = new Button("Login");
        loginButton.setStyle(
                "-fx-background-color: #0000CD;" +
                        "-fx-text-fill: #FFFFFF; " +
                        "-fx-background-radius: 50px; " +
                        "-fx-cursor: hand;");
        loginButton.setPrefWidth(200);

        // Layouts
        HBox senhaBox = new HBox(10, senha, txtSenha, toggleBtn);
        senhaBox.setAlignment(Pos.CENTER);

        VBox formBox = new VBox(15, viewUserIcon, txtEmail, senhaBox, loginButton);
        formBox.setAlignment(Pos.CENTER);
        formBox.setPadding(new Insets(30));

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(photohotel);
        mainPane.setCenter(formBox);

        // Cena e palco
        Scene scene = new Scene(mainPane, 800, 500);
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
