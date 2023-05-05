package controlador;

import vista.Login;

/**
 *
 * @author juana
 */
public class TextMain {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
        
    }
    
}
