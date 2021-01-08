package main.menu;

import main.Jeu;

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
                String[] nomJoueurs = new String[menuPanel.getNbJoueurs()];
                String[] couleurs = new String[]{"red", "blue", "green", "yellow", "pink"};
                for(int i = 0; i < menuPanel.getTxtFldNomJoueurs().size(); i++)
                {
                    nomJoueurs[i] = menuPanel.getTxtFldNomJoueurs().get(i).getText();
                }
                try {
                    Jeu.initPlateau(nomJoueurs, couleurs);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
        }
    }
}
