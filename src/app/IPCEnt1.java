/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import accesoaBD.AccesoaBD;
import controller.FXMLAlumnoController;
import controller.FXMLAlumnosController;
import controller.FXMLCursosController;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.Parent;
import javafx.stage.Modality;
import modelo.Alumno;
import modelo.Curso;
import modelo.Matricula;

/**
 *
 * @author thepu
 */
public class IPCEnt1 extends Application {

    public Stage stage;
    public VBox vbroot;
    private MainController controladormenu;
    private final AccesoaBD acceso = new AccesoaBD();

    private final ObservableList<Alumno> olAlumnos = FXCollections.observableList(acceso.getAlumnos());
    private final ObservableList<Curso> olCursos = FXCollections.observableList(acceso.getCursos());
    private ObservableList<Matricula> olMatricula;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMain.fxml"));
        vbroot = (VBox) loader.load();
        Scene scene = new Scene(vbroot);
        stage.setTitle("Pantalla principal");
        stage.setScene(scene);
        controladormenu = loader.<MainController>getController();
        controladormenu.setApp(this);
        controladormenu.initStage(stage);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void goToMain() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMain.fxml"));
        this.vbroot.getChildren().remove(1);
        VBox panel = (VBox) loader.load();
        this.vbroot.getChildren().add(panel.getChildren().get(1));
        stage.setTitle("Pantalla principal");

    }

    public void gotoUsuario() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLAlumno.fxml"));
        FXMLAlumnoController controlador = loader.getController();
        Parent root = (Parent)loader.load();
        Stage estageActual = new Stage();
        Scene scene = new Scene(root);
        estageActual.setScene(scene);
        estageActual.initModality(Modality.APPLICATION_MODAL);
        estageActual.showAndWait();

    }

    public void goToUsuarios() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLAlumnos.fxml"));
        this.vbroot.getChildren().remove(1);
        this.vbroot.getChildren().add((BorderPane) loader.load());
        FXMLAlumnosController alumnosController = loader.getController();
        alumnosController.setApp(this);
        alumnosController.initStage(stage, this.olAlumnos);
        stage.setTitle("Alumnos");
    }

    public void goToCursos() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLCursos.fxml"));
        this.vbroot.getChildren().remove(1);
        this.vbroot.getChildren().add((BorderPane) loader.load());
        FXMLCursosController cursosController = loader.getController();
        cursosController.setApp(this);
        cursosController.initStage(stage, this.olCursos);
        stage.setTitle("Cursos");
    }

}
