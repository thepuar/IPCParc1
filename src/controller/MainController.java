/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.IPCEnt1;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *
 * @author thepu
 */
public class MainController implements Initializable {
    
    private IPCEnt1 app;
    private Stage primaryStage;

    @FXML
    private MenuItem imAlumnos;

    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void setApp(IPCEnt1 app){
        this.app = app;
    }
    
    public void initStage(Stage stage){
        this.primaryStage = stage;
    }

    @FXML
    private void imAlumnosPressed(ActionEvent event)throws Exception {
        this.app.goToUsuarios();
        
    }

    @FXML
    private void irPrincipalPressed(ActionEvent event) throws Exception{
        this.app.goToMain();
    }

    @FXML
    private void irCursosPressed(ActionEvent event) throws Exception{
        this.app.goToCursos();
    }

}
