package main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Jeu {

    static Plateau plateau;
    static MainWindow mainWindow;

    public static void main(String[] args) throws Exception {
        mainWindow = new MainWindow();
    }

    public static void initPlateau(String[] nomJoueurs, String[] couleurs) throws Exception {
        plateau = new Plateau(nomJoueurs, couleurs);
    }


    public static void closeWindow(){
        mainWindow.frame.setVisible(false);
        mainWindow.frame.dispose();
    }

    public static void runPlateau() throws Exception
    {
        plateau.run();
    }
}
