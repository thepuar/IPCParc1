/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.IPCEnt1;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Curso;
import modelo.Dias;

/**
 * FXML Controller class
 *
 * @author thepu
 */
public class FXMLCursosController implements Initializable {

    public IPCEnt1 app;
    public Stage primaryStage;
    @FXML
    private Button btAdd;
    @FXML
    private Button btDel;
    @FXML
    private TableView<Curso> tvCursos;
    @FXML
    private TableColumn<Curso, String> tttleColumn;
    @FXML
    private TableColumn<Curso, String> profesorColumn;
    @FXML
    private TableColumn<Curso, Integer> maxColumn;
    @FXML
    private TableColumn<Curso, LocalDate> dateIniColumn;
    @FXML
    private TableColumn<Curso, LocalDate> dateEndColumn;
    @FXML
    private TableColumn<Curso, LocalTime> hourColumn;
    @FXML
    private TableColumn<Curso, ArrayList<Dias>> daysWeekColumn;
    @FXML
    private TableColumn<Curso, String> roomColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tttleColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitulodelcurso()));
        profesorColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getProfesorAsignado()));
        maxColumn.setCellValueFactory(new PropertyValueFactory<>("numeroMaximodeAlumnos"));
        dateIniColumn.setCellValueFactory(new PropertyValueFactory<>("fechainicio"));
        dateIniColumn.setCellFactory((TableColumn<Curso, LocalDate> column) -> {
            return new TableCell<Curso, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.format(DateTimeFormatter.ofPattern("dd/MM/yyy")));
                    }
                }
            };
        });

        dateEndColumn.setCellValueFactory(new PropertyValueFactory<>("fechafin"));
        dateEndColumn.setCellFactory((TableColumn<Curso, LocalDate> column) -> {
            return new TableCell<Curso, LocalDate>() {
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
        hourColumn.setCellValueFactory(new PropertyValueFactory<>("hora"));
        hourColumn.setCellFactory((TableColumn<Curso, LocalTime> column) -> {
            return new TableCell< Curso, LocalTime>() {
                @Override
                protected void updateItem(LocalTime item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.format(DateTimeFormatter.ofPattern("hh:mm")));
                    }
                }
            };
        });
        daysWeekColumn.setCellValueFactory(new PropertyValueFactory<>("diasimparte"));
        daysWeekColumn.setCellFactory((TableColumn<Curso, ArrayList<Dias>> column) -> {
            return new TableCell<Curso, ArrayList<Dias>>() {
                @Override
                protected void updateItem(ArrayList<Dias> item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        String cadena = "";
                        for (Dias dia : item) {
                            cadena += dia + " ";
                        }
                        setText(cadena);
                    }
                }
            };
        });
        roomColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAula()));
        BooleanBinding noCursoSelected = Bindings.isEmpty(tvCursos.getSelectionModel().getSelectedItems());
        this.btDel.disableProperty().bind(noCursoSelected);
    }

    public void setApp(IPCEnt1 app) {
        this.app = app;
    }

    public void initStage(Stage stage, ObservableList<Curso> olCursos) {
        this.primaryStage = stage;
        this.tvCursos.setItems(olCursos);
    }

}
