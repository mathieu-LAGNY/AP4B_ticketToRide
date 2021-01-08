package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(){
        JImagePanel carte = new JImagePanel("map.png");// Mettre emplacement ou nom de l'image si dans le même dossier que le code

        //Centrer l'image
        carte.setStretch(false);
        this.setLayout(new GridBagLayout());
        JButton button;
        GridBagConstraints c = new GridBagConstraints();

        // Les cartes Wagons à séléctionner
        JCheckBox carte1 = new JCheckBox("Carte1", false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        this.add(carte1, c);

        JCheckBox carte2 = new JCheckBox("Carte2", false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        this.add(carte2, c);

        JCheckBox carte3 = new JCheckBox("Carte3", false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        this.add(carte3, c);

        JCheckBox carte4 = new JCheckBox("Carte4", false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 0;
        this.add(carte4, c);

        JCheckBox carte5 = new JCheckBox("Carte5", false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 0;
        this.add(carte5, c);

        //Les différents pioches
        button = new JButton("Pioche Wagon");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 5;
        c.gridy = 0;
        this.add(button, c);

        button = new JButton("Pioche destination");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 6;
        c.gridy = 0;
        this.add(button, c);

        // Plateau
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 650;//make this component tall
        c.weightx = 0.0;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 1;
        this.add(carte, c);

        // Les cartes Destinations du joueur
        JLabel carteDestination1 = new JLabel("Carte Dest 1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.weighty = 1.0;   //request any extra vertical space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 0;       //aligned with button 2
        c.gridy = 2;       //third row
        this.add(carteDestination1, c);

        JLabel carteDestination2 = new JLabel("Carte Dest 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1.0;   //request any extra vertical space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridy = 2;       //third row
        this.add(carteDestination2, c);

        JLabel carteDestination3 = new JLabel("Carte Dest 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1.0;   //request any extra vertical space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 3;       //aligned with button 2
        c.gridy = 2;       //third row
        this.add(carteDestination3, c);

        // Prendre une route
        button = new JButton("Prendre Route");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 5;       //aligned with button 2
        c.gridy = 2;       //third row
        this.add(button, c);
    }
}
