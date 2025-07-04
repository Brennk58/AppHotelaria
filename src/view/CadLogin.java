package view;

import controller.UsuariosController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

        Label ldlTexto = new Label("Seja Bem-Vindo!");
        TextField txtComprimento = new TextField();

        GridPane FormGrid = new GridPane();
        FormGrid.add(txtComprimento,0,1);

        // Campos de entrada
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Digite seu Email");
        txtEmail.setMaxWidth(200);

        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua Senha");
        campoSenha.setMaxWidth(250);

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
                campoSenha.setText(txtSenha.getText());
                campoSenha.setVisible(true);
                campoSenha.setManaged(true);
                txtSenha.setVisible(false);
                txtSenha.setManaged(false);
                toggleBtn.setGraphic(viewEyeOpen);
                senhaVisivel = false;
            } else {
                txtSenha.setText(campoSenha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                campoSenha.setVisible(false);
                campoSenha.setManaged(false);
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

        loginButton.setOnAction( evento ->{

            String usuario = txtEmail.getText();
            String senha = campoSenha.isVisible() ? campoSenha.getText() : txtSenha.getText();

            UsuariosController usuariosController = new UsuariosController();
            boolean loginSucesso = usuariosController.verificarCredenciais(usuario,senha);
            if (loginSucesso){
                CadCliente cadCliente = new CadCliente();
                try {
                    cadCliente.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                janela.close();

                System.out.println("Login efetuada com sucesso!");
            }else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Login invalido!");
            }
        });

        // Layouts
        HBox senhaBox = new HBox(10,campoSenha, txtSenha, toggleBtn);
        senhaBox.setAlignment(Pos.CENTER);

        VBox formBox = new VBox(15, viewUserIcon,ldlTexto, txtEmail, senhaBox, loginButton);
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
