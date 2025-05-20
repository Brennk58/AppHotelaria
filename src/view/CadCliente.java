
package view; //Package view (classes que, quando executaas, interagem com o usuário)

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: Container que contém os layouts
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage; //Classe Stage: É a própria janela (incluso da barra de opções: minimizar, maximizar, fechar)
import view.components.PainelBotoes;
import view.components.Sidebar;

public class CadCliente extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Sidebar menu = new Sidebar();

        // add imagem(icone)
        Image imglogo = new Image(getClass().getResourceAsStream
                ("/view/resources/img/logoHotel.png"
        )); //Não tem como almentar a logo!

        Image iconUser = new Image(getClass().getResourceAsStream
                ("/img/logoUser.png"
                ));

        //para mostrar os bostoes laterais
        BorderPane mainpane = new BorderPane();
        mainpane.setLeft(menu);
        PainelBotoes mainButton = new PainelBotoes();

        ImageView viewiconUser = new ImageView(iconUser);
        viewiconUser.setFitWidth(40);
        viewiconUser.setFitHeight(40);
        viewiconUser.setOpacity(1);

        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 25px; -fx-font-weight: bold");
        //-fx-background-color: #00BFFF; (qualquer cor em hexadecimal )
        //criação de um Subtitulo
        Label lblsubtitulo = new Label("Subtitulo");
        lblsubtitulo.setAlignment(Pos.CENTER);// cod Para centralizar o Subtitulo
        lblsubtitulo.setStyle("-fx-font-size: 15px; -fx-font-weight: bold");//cod para mudar a fonte e o tamanho

        HBox tituloBox = new HBox(viewiconUser,lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10);

        //Muda a cor da caixa (box) -> tituloBox.setStyle("-fx-background-color: #00FFFF");

        tituloBox.setPadding(new Insets(20, 20, 20,20));
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome");
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(200);

        Label lblCPF = new Label("CPF");
        TextField txtCPF = criarMascaraCampo("###.###.###-##");
        txtCPF.setMaxWidth(200);

        Label lblEmail = new Label("Email");
        TextField txtEmail = new TextField();
        txtEmail.setMaxWidth(200);
        //lbl = pergunta
        //texto = campo
        Label lblTelefone = new Label("Telefone");
        TextField txtTelefone = criarMascaraCampo("(##) #####-####");
        txtTelefone.setMaxWidth(200);

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com","@outlook.com","@hotmail.com","@icloud.com");
        boxEmail.setPromptText("Selecione");



        GridPane formGrid = new GridPane();
        formGrid.add(lblNome,0,0);
        formGrid.add(txtNome,1,0);

        formGrid.add(lblCPF,0,1);
        formGrid.add(txtCPF,1,1);

        formGrid.add(lblEmail,0,2);
        formGrid.add(boxEmail,2, 2);
        formGrid.add(txtEmail,1,2);


        formGrid.add(lblTelefone,0,3);
        formGrid.add(txtTelefone,1,3);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);


        //lblsubtitulo
        VBox layout = new VBox(10,tituloBox, formGrid, mainButton);
        layout.setAlignment(Pos.CENTER);
        mainpane.setCenter(layout);

        Scene scene = new Scene(mainpane, 750, 400);
        stage.setTitle("Hotel Ibis");
        //colocar um icone na janela(stage)->icone da empresa/marca
        stage.getIcons().add(imglogo);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    //Metodo para criar um compo de texto com mascara
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

    public static void main(String[] args) {
        launch(args); //Inicializa o JavaFX
    }
}
