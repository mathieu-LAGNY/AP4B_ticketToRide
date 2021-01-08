package main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Jeu {

    static Plateau plateau;
    static MainWindow mainWindow;

    public static void main(String[] args) throws Exception {
        mainWindow = new MainWindow(1);
    }

    public static void initPlateau(String[] nomJoueurs, String[] couleurs) throws Exception {
        plateau = new Plateau(nomJoueurs, couleurs);
        displayGamePanel();
    }

    public static void displayGamePanel() throws Exception {
        mainWindow.frame.getContentPane().setVisible(false);
        mainWindow.frame.dispose();
        mainWindow = new MainWindow(2);
        mainWindow.frame.setVisible(true);
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
