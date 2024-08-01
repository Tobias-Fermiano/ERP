package com.example.erp.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

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
       AboutController aboutController = new AboutController();
       aboutController.loadView("src/main/java/com/example/erp/View/about-view.fxml");
    }

    @FXML
    public void onMenuItemProdutoAction() {
        ProdutoController ProdutoController = new ProdutoController();
        ProdutoController.loadView("src/main/java/com/example/erp/View/produto-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}