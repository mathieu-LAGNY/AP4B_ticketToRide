package main;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    public MainWindow() {
        //Make sure we have nice window decorations. JFrame.setDefaultLookAndFeelDecorated(true);
        // Create and set up the window.
        JFrame frame = new JFrame("Ticket To UTBM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 700);
        frame.setLocationRelativeTo(null);


        JPanel menuPanel = new MenuPanel();

        frame.getContentPane().add(menuPanel);

        frame.setVisible(true);
    }
}
