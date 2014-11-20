
import controle.Controle;
import interfaceGrafica.Interfa_quick;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WiIsmar
 */
public class Main {
    public static void main(String[] args) {
        Controle c = new Controle();

        new Interfa_quick(c).setVisible(true);
    }
}
