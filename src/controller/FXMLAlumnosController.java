/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.IPCEnt1;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Alumno;

/**
 * FXML Controller class
 *
 * @author thepu
 */
public class FXMLAlumnosController implements Initializable {

    public IPCEnt1 app;
    public Stage primaryStage;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDel;
    @FXML
    private TableView<Alumno> tvAlumnos;
    @FXML
    private TableColumn<Alumno, String> dniColumn;
    @FXML
    private TableColumn<Alumno, String> nameColumn;
    @FXML
    private TableColumn<Alumno, Integer> ageColumn;
    @FXML
    private TableColumn<Alumno, String> addressColumn;
    @FXML
    private TableColumn<Alumno, LocalDate> altaColumn;
    @FXML
    private TableColumn<Alumno, Image> pictureColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dniColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDni()));
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNombre()));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));
        addressColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDireccion()));
        altaColumn.setCellValueFactory(new PropertyValueFactory<>("fechadealta"));
        altaColumn.setCellFactory((TableColumn< Alumno, LocalDate> column) -> {
            return new TableCell<Alumno, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    }
                }
            };

        });

        pictureColumn.setCellValueFactory(new PropertyValueFactory<>("foto"));
        pictureColumn.setCellFactory(columna -> {
            return new TableCell<Alumno, Image>() {
                @Override
                protected void updateItem(Image item, boolean empty) {
                    setText(null);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                    ImageView imageView = new ImageView(item);
                    imageView.setFitHeight(40);
                    imageView.setFitWidth(40);
                    setGraphic(imageView);
                }
            };
        });
        BooleanBinding noAlumnoSelected = Bindings.isEmpty(tvAlumnos.getSelectionModel().getSelectedItems());
        this.btnDel.disableProperty().bind(noAlumnoSelected);
    }

    public void setApp(IPCEnt1 app) {
        this.app = app;
    }

    public void initStage(Stage stage, ObservableList<Alumno> olAlumnos) {
        this.primaryStage = stage;
        this.tvAlumnos.setItems(olAlumnos);
    }

    @FXML
    private void addAlumnoPressed(ActionEvent event) {
        try {
            this.app.gotoUsuario();
        } catch (Exception e) {
        }
    }

    @FXML
    private void delAlumnoPressed(ActionEvent event) {
    }

}
