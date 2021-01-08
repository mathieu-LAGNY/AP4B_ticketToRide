package main.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuListener implements java.awt.event.ActionListener {

    private MenuPanel menuPanel;

    public MenuListener(MenuPanel menuPanel)
    {
        this.menuPanel = menuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand())
        {
            case "combo":
                menuPanel.setNbJoueurs((Integer) menuPanel.getCbNbJoueurs().getSelectedItem());
                menuPanel.updateNbJoueurs();
                break;
            case "jouer":
                for(JTextField txtFldNomJoueur : menuPanel.getTxtFldNomJoueurs())
                {
                    System.out.println(txtFldNomJoueur.getText());
                }
        }
    }
}
