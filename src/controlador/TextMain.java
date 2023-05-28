package controlador;

import vista.Inicio;

/**
 *
 * @author juana
 */
public class TextMain {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    
}
