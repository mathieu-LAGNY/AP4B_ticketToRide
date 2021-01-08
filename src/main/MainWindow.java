package main;

import main.menu.MenuPanel;

import javax.swing.*;

public class MainWindow {

    JFrame frame;

    public MainWindow() {
        //Make sure we have nice window decorations. JFrame.setDefaultLookAndFeelDecorated(true);
        // Create and set up the window.
        frame = new JFrame("Ticket To UTBM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 700);
        frame.setLocationRelativeTo(null);


        JPanel menuPanel = new MenuPanel();

        frame.getContentPane().add(menuPanel);

        frame.setVisible(true);
    }

    public void setWindow(JPanel panel)
    {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
