package com.example.erp.Controller;

import com.example.erp.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    //Instanciando objetos do FXML

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    //Criando métodos de teste, somente para realizar a verificação da chamada do método

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        System.out.println("onMenuDepartmentAction");
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("src/main/java/com/example/erp/View/about-view.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //Criando uma nova tela e aplicando a classe de verificação de erro

    public synchronized void loadView(String absoluteName){
        try{
            URL url = new File(absoluteName).toURI().toURL();
//            URL url = getClass().getResource(absoluteName);
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

            // mainNode.setOnMouseClicked(new EventHandler<MouseEvent>() {})    Adicionar um evento no click do mouse
        }
        catch (IOException e) {
            Alerts.showAlert("IO Execption", "Erro ao carregar a página", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}