/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionListener;

/**
 *
 * @author Rahmi Maulidina N
 */
public interface InterfaceView {
    public void addListener(ActionListener e);
    public void viewErrorMsg(String errorMsg);
    public void setVisible(boolean b);
    public void setPetu(int x);
    public int getPetu();
}
