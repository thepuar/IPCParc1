/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Alumno;

/**
 * FXML Controller class
 *
 * @author thepu
 */
public class FXMLAlumnoController implements Initializable {

    private Alumno alumno;
    
    @FXML
    private Button btAccept;
    @FXML
    private Button btCancel;
    @FXML
    private TextField tfDNI;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void initStage(Alumno alumno){
        this.tfDNI.setText("");
        this.tfName.setText("");
        this.tfAge.setText("");
        this.tfDate.setText("");
    }
    
}
