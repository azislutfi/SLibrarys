/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import controller.Handler;
import gui.gAwal;

/**
 *
 * @author Finally
 */
public class MulaiAplikasi {
    public static void main(String[] args) {
        // TODO code application logic here

        Aplikasi model = new Aplikasi();
        gAwal view = new gAwal();
        Handler c = new Handler();
        view.setLocationRelativeTo(null);

        c.setModel(model);
        c.setView(view);
        c.setListener();
        view.setVisible(true);
    }
}
