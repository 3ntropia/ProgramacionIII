package app;

import vista.Ventana;

public class Inicio {
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Ventana.mostrar("3956");
            }
        });
    }
}
