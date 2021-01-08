package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel {

    private int nbJoueurs;

    private JLabel lblTitre;

    private JComboBox<Integer> cbNbJoueurs;

    private JLabel lblCombo;

    private ArrayList<JLabel> lblNomJoueurs;

    private ArrayList<JTextField> txtFldNomJoueurs;

    private JButton btnPlay;

    private JPanel pnlCombo;

    private JPanel pnlJoueurs;

    private ArrayList<JPanel> pnlSingleJoueur;

    public MenuPanel()
    {

        nbJoueurs = 3;

        lblTitre = new JLabel("Ticket to UTBM");
        lblTitre.setFont (lblTitre.getFont ().deriveFont (64.0f));
        lblTitre.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        Integer[] elements = new Integer[]{2, 3, 4};

        lblCombo = new JLabel("Nombre de joueurs");
        lblCombo.setFont (lblTitre.getFont ().deriveFont (18.0f));
        cbNbJoueurs = new JComboBox<>(elements);
        cbNbJoueurs.setSelectedIndex(1);
        pnlCombo = new JPanel();
        pnlCombo.add(lblCombo);
        pnlCombo.add(cbNbJoueurs);
        pnlCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE,pnlCombo.getPreferredSize().height));
        pnlCombo.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Labels et Textarea Joueurs
        lblNomJoueurs = new ArrayList<>();
        txtFldNomJoueurs = new ArrayList<>();
        pnlJoueurs = new JPanel();
        pnlJoueurs.setLayout(new BoxLayout(pnlJoueurs, BoxLayout.PAGE_AXIS));
        for(int i = 0; i<nbJoueurs; i++)
        {
            String stringLbl = String.format("Joueur %d", i+1);
            JLabel lblNomJoueur = new JLabel(stringLbl);
            JTextField txtFldJoueur = new JTextField();
            txtFldJoueur.setColumns( 20 );

            lblNomJoueurs.add(lblNomJoueur);
            txtFldNomJoueurs.add(txtFldJoueur);
            JPanel pnl = new JPanel();
            pnl.setLayout(new FlowLayout());
            pnl.add(lblNomJoueur);
            pnl.add(txtFldJoueur);
            pnlJoueurs.add(pnl);
        }

        btnPlay = new JButton("Jouer");
        btnPlay.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        btnPlay.setPreferredSize(new Dimension(20, 50));

        //Layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(lblTitre);
        this.add(Box.createHorizontalStrut(10));
        this.add(pnlCombo);
        this.add(Box.createHorizontalStrut(10));
        this.add(pnlJoueurs);
        this.add(Box.createHorizontalStrut(10));
        this.add(btnPlay);
    }
}
