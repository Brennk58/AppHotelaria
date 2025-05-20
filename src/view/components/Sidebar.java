package view.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Sidebar extends VBox {
    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionnarios = new Button("Funcionarios");
    public Button btnQuartos = new Button( "Quartos");
    public Button btnReserva = new Button( "Reservas");
    public Button btnRelatorio = new Button( "Relatorios");


    public Sidebar() {
        Image iconCliente = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-cliente.png"));
        Image iconFuncionario = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-funcionario.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-quarto.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-reserva.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-relatorio.png"));

        //Carregamento das fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/RedRose-Light.ttf"), 14);
        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/RedRose-SemiBold.ttf"), 15);


        ImageView viewbntC = new ImageView(iconCliente);
        viewbntC.setFitWidth(20);
        viewbntC.setFitHeight(20);
        viewbntC.setOpacity(1);

        ImageView viewbntF = new ImageView(iconFuncionario);
        viewbntF.setFitWidth(20);
        viewbntF.setFitHeight(20);
        viewbntF.setOpacity(1);

        ImageView viewbntQ = new ImageView(iconQuarto);
        viewbntQ.setFitWidth(20);
        viewbntQ.setFitHeight(20);
        viewbntQ.setOpacity(1);

        ImageView viewbntRV = new ImageView(iconReserva);
        viewbntRV.setFitWidth(20);
        viewbntRV.setFitHeight(20);
        viewbntRV.setOpacity(1);

        ImageView viewbntRL = new ImageView(iconCliente);
        viewbntRL.setFitWidth(20);
        viewbntRL.setFitHeight(20);
        viewbntRL.setOpacity(1);


        btnCliente.setGraphic(viewbntC);
        btnFuncionnarios.setGraphic(viewbntF);
        btnQuartos.setGraphic(viewbntQ);
        btnReserva.setGraphic(viewbntRV);
        btnRelatorio.setGraphic(viewbntRL);

        Label lblMenu = new Label("GRAND HOTEL");
        //Cor da fonte
        lblMenu.setStyle("-fx-text-fill: #a87e08;");
        lblMenu.setFont(Font.font(fonteNegrito.getFamily(),25));

        // Estilizaçao dos botões (Fundo e Borda transparentes) #DCDCDC
        String styleButton = "-fx-background-color: transparent ;"+
                             "-fx-border-color: transparent;"+
                             "-fx-graphic-text-gap: 10px;"+
                             "-fx-cursor: hand;";

        btnCliente.setStyle(styleButton);
        btnFuncionnarios.setStyle(styleButton);
        btnQuartos.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);


        //Objetivo: ao passar o mouse, troca o fundo do botão para a cor desejada
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionnarios.setOnMouseEntered(evento ->
                btnFuncionnarios.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnFuncionnarios.setOnMouseExited(evento -> btnFuncionnarios.setStyle(styleButton));

        btnQuartos.setOnMouseEntered(evento ->
                btnQuartos.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnQuartos.setOnMouseExited(evento -> btnQuartos.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));



        setMargin(lblMenu, new Insets(0,        0,      20,       0  ));
                    //Margem:         Superior,    Direita,    Inferior,    Esquerda.
        // Cor do fundo, botoes
        setStyle("-fx-background-color: #FFE4B5 ; -fx-padding: 40px;");
        setSpacing(10);  //Metodo setSpacing para espasaqmento entre os componentes
        getChildren().addAll(lblMenu, btnCliente, btnFuncionnarios,
                btnQuartos, btnReserva, btnRelatorio);

    }
}
