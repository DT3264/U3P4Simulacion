/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3p4generador;

import com.formdev.flatlaf.IntelliJTheme;
import gui.FrmPrincipal;

/**
 *
 * @author Dani
 */
public class U3P4Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntelliJTheme.install(U3P4Generador.class.getResourceAsStream("DarkPurple.theme.json"));
        new FrmPrincipal().setVisible(true);
    }
    
}
