package view.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PainelBotoes extends HBox {

    public PainelBotoes(){
        Image iconBtnCad = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icons8-mais-48.png"
                ));
        Image iconBtnUp = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icons8-atualizar-60.png"
                ));
        Image iconBtnDel = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icons8-lixo-52.png"
                ));


        ImageView viewiconBtnCad = new ImageView(iconBtnCad);
        viewiconBtnCad.setFitWidth(20);// Modificação de largura
        viewiconBtnCad.setFitHeight(20);// Modificação de altura
        viewiconBtnCad.setOpacity(1);// Modificação de opacidade(transparencia): // 0.0(invisivel) - 1.0 (opaco)

        ImageView viewiconBtnUp = new ImageView(iconBtnUp);
        viewiconBtnUp.setFitWidth(20);
        viewiconBtnUp.setFitHeight(20);
        viewiconBtnUp.setOpacity(1);

        ImageView viewiconBtnDel = new ImageView(iconBtnDel);
        viewiconBtnDel.setFitWidth(20);
        viewiconBtnDel.setFitHeight(20);
        viewiconBtnDel.setOpacity(1);

        //criar um botão com texto e imagem(icone)
        Button btnCadastrar = new Button("Cadastrar",viewiconBtnCad);
        btnCadastrar.setStyle("-fx-background-color: #D6C388FF; -fx-text-fill: #FFFFFF; " +
                "-fx-background-radius: 50px; " +
                "-fx-cursor: hand;");

        Button btnAtualizar = new Button("Atualizar",viewiconBtnUp);
        btnAtualizar.setStyle("-fx-background-color: #D6C388FF; -fx-text-fill: #FFFFFF;" +
                " -fx-background-radius: 50px;" +
                " -fx-cursor: hand;");

        Button btnExcluir = new Button("Excluir",viewiconBtnDel);
        btnExcluir.setStyle("-fx-background-color: #D6C388FF; -fx-text-fill: #FFFFFF;" +
                " -fx-background-radius: 50px;"  +
                " -fx-cursor: hand;");

        setAlignment(Pos.CENTER);
        setSpacing(10);
        
        getChildren().addAll(btnCadastrar,btnAtualizar,btnExcluir);


    }
}
