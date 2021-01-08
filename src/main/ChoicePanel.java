package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChoicePanel extends JPanel {

        private JLabel lblTitre;

        private JButton btnPlay;

        private JLabel lblChoix;

        private JPanel pnlChoix;

        public ChoicePanel()
        {

            lblTitre = new JLabel("Ticket to UTBM");
            lblTitre.setFont (lblTitre.getFont ().deriveFont (64.0f));
            lblTitre.setAlignmentX(JComponent.CENTER_ALIGNMENT);

            lblChoix = new JLabel("Choix des Cartes Destinations");
            pnlChoix = new JPanel();
            pnlChoix.add(lblChoix);
            pnlChoix.setMaximumSize(new Dimension(Integer.MAX_VALUE,pnlChoix.getPreferredSize().height));
            pnlChoix.setAlignmentX(JComponent.CENTER_ALIGNMENT);

            pnlChoix = new JPanel();
            pnlChoix.setLayout(new FlowLayout());
            JCheckBox carte1 = new JCheckBox("Carte1", false);
            JCheckBox carte2 = new JCheckBox("Carte2", false);
            JCheckBox carte3 = new JCheckBox("Carte3", false);
            carte1.setPreferredSize(new Dimension(100, 80));
            carte2.setPreferredSize(new Dimension(100, 80));
            carte3.setPreferredSize(new Dimension(100, 80));

            pnlChoix.add(carte1);
            pnlChoix.add(carte2);
            pnlChoix.add(carte3);
            pnlChoix.setMaximumSize(new Dimension(Integer.MAX_VALUE,pnlChoix.getPreferredSize().height));
            pnlChoix.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            //Labels et Textarea Joueurs

            btnPlay = new JButton("Valider Choix");
            btnPlay.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            btnPlay.setPreferredSize(new Dimension(20, 50));

            //Layout
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            this.add(lblTitre);
            this.add(Box.createHorizontalStrut(10));
            this.add(pnlChoix);
            this.add(Box.createHorizontalStrut(10));
            this.add(btnPlay);
        }
    }

