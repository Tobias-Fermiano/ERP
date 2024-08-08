package com.example.erp.Controller;

import com.example.erp.MainApplication;
import com.example.erp.Model.Produto;
import com.example.erp.Services.AboutService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProdutoController implements Initializable {


    @FXML
    private VBox vbox;

    @FXML
    private AboutService service;

    public void setService(AboutService service) {
        this.service = service;
    }

    private ObservableList<Produto> produtos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public synchronized void loadView(String absoluteName){
        try{
            URL url = new File(absoluteName).toURI().toURL();
//          URL url = getClass().getResource(absoluteName);       Maneira que eu estava utilizando, alterada para a que está acima

            if(url == null){
                throw new IllegalStateException("FXML não encontrado " +  absoluteName);
            }

            FXMLLoader fxmlLoader = new FXMLLoader(url);
            VBox newBox = fxmlLoader.load();

            Scene newScene = MainApplication.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) newScene.getRoot()).getContent();

            //Limpa o conteúdo da tela adicionando o novo
            Node mainNode = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainNode);
            mainVBox.getChildren().addAll(newBox.getChildren());
        }
        catch (IOException e) {
            Alerts.showAlert("IO Execption", "Erro ao carregar a página", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
