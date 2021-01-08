package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChoicePanel extends JDialog {

        private JLabel lblTitre;

        private JButton btnPlay;

        private JLabel lblChoix;

        private JPanel pnlChoix;

        private ArrayList<JCheckBox> chkCartes;

        public ChoicePanel(ArrayList<JPanel> cartesDestination)
        {

            this.setModalityType(ModalityType.APPLICATION_MODAL);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            this.setLocation(100, 100);
            this.setSize(950, 700);

            lblTitre = new JLabel("Ticket to UTBM");
            lblTitre.setFont (lblTitre.getFont ().deriveFont (64.0f));
            lblTitre.setAlignmentX(JComponent.CENTER_ALIGNMENT);



            lblChoix = new JLabel("Choix des Cartes Destinations");
            lblChoix.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            lblChoix.setFont (lblChoix.getFont ().deriveFont (28.0f));
            pnlChoix = new JPanel();
            pnlChoix.add(lblChoix);
            pnlChoix.setMaximumSize(new Dimension(Integer.MAX_VALUE,pnlChoix.getPreferredSize().height));
            pnlChoix.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            pnlChoix.setLayout(new BoxLayout(pnlChoix, BoxLayout.PAGE_AXIS));

            chkCartes = new ArrayList<>();

            for(int i=0; i<3; i++)
            {
                JPanel panelCarte = new JPanel();
                JCheckBox chkCarte = new JCheckBox();
                chkCarte.setPreferredSize(new Dimension(100, 80));
                chkCarte.setAlignmentX(JComponent.CENTER_ALIGNMENT);
                chkCartes.add(chkCarte);
                panelCarte.add(chkCarte);
                panelCarte.add(cartesDestination.get(i));
                pnlChoix.add(panelCarte);
            }

            pnlChoix.setMaximumSize(new Dimension(Integer.MAX_VALUE,pnlChoix.getPreferredSize().height));
            pnlChoix.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            //Labels et Textarea Joueurs

            btnPlay = new JButton("Valider Choix");
            btnPlay.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            btnPlay.setPreferredSize(new Dimension(20, 50));

            //Layout
            JPanel panelChoice = new JPanel();
            panelChoice.setLayout(new BoxLayout(panelChoice, BoxLayout.PAGE_AXIS));
            panelChoice.add(lblTitre);
            panelChoice.add(Box.createHorizontalStrut(10));
            panelChoice.add(pnlChoix);
            panelChoice.add(Box.createHorizontalStrut(10));
            panelChoice.add(btnPlay);

            this.getContentPane().add(panelChoice);

            this.setVisible(true);
        }
    }

