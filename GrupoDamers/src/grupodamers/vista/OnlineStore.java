/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupodamers.vista;

import grupodamers.controlador.Controlador;
import grupodamers.modelo.Datos;

/**
 *
 * @author DAMERs Project POO
 */
public class OnlineStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	System.out.println("Esto funciona");
    	
    	GestionOS vista = new GestionOS();
    	Datos modelo = new Datos();
    	Controlador controlador = new Controlador(modelo, vista);
    	
    	controlador.iniciarAplicacion();
    	
    }
    
}
