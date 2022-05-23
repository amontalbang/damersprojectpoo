/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupodamers.vista;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import grupodamers.controlador.Controlador;
import grupodamers.modelo.Datos;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author DAMERs Project POO
 */
public class OnlineStore extends Application {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	OnlineStore.quitarLogs();
    	launch(args);
    }
    
    private static void quitarLogs() {
    	LogManager.getLogManager().reset();
    	Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
    	globalLogger.setLevel(java.util.logging.Level.OFF);
    }

	@Override
	public void start(Stage stage) throws Exception {
		GestionOS vista = new GestionOS(stage, "Online Store");
		Datos modelo = new Datos();
		Controlador controlador = new Controlador(modelo, vista);
		vista.setControlador(controlador);
		controlador.gestionMenu();
	}
    
}
