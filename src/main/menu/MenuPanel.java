package main.menu;

import main.menu.MenuListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel {

    private final Color[] arrayColor = {Color.red, Color.blue, Color.green, Color.yellow, Color.pink};

    private int nbJoueurs;

    private JLabel lblTitre;

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    public JLabel getLblTitre() {
        return lblTitre;
    }

    public JComboBox<Integer> getCbNbJoueurs() {
        return cbNbJoueurs;
    }

    public JLabel getLblCombo() {
        return lblCombo;
    }

    public ArrayList<JLabel> getLblNomJoueurs() {
        return lblNomJoueurs;
    }

    public ArrayList<JTextField> getTxtFldNomJoueurs() {
        return txtFldNomJoueurs;
    }

    public JButton getBtnPlay() {
        return btnPlay;
    }

    public JPanel getPnlCombo() {
        return pnlCombo;
    }

    public JPanel getPnlJoueurs() {
        return pnlJoueurs;
    }

    public ArrayList<JPanel> getPnlSingleJoueur() {
        return pnlSingleJoueur;
    }

    public MenuListener getMenuListener() {
        return menuListener;
    }

    private JComboBox<Integer> cbNbJoueurs;

    private JLabel lblCombo;

    private ArrayList<JLabel> lblNomJoueurs;

    private ArrayList<JTextField> txtFldNomJoueurs;

    private JButton btnPlay;

    private JPanel pnlCombo;

    private JPanel pnlJoueurs;

    private ArrayList<JPanel> pnlSingleJoueur;

    private MenuListener menuListener;

    public MenuPanel()
    {
        this.menuListener = new MenuListener(this);

        nbJoueurs = 3;

        lblTitre = new JLabel("Ticket to UTBM");
        lblTitre.setFont (lblTitre.getFont ().deriveFont (64.0f));
        lblTitre.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        Integer[] elements = new Integer[]{3, 4, 5};

        lblCombo = new JLabel("Nombre de joueurs");
        lblCombo.setFont (lblTitre.getFont ().deriveFont (18.0f));
        cbNbJoueurs = new JComboBox<>(elements);
        cbNbJoueurs.setSelectedIndex(0);
        cbNbJoueurs.setActionCommand("combo");
        cbNbJoueurs.addActionListener(menuListener);
        pnlCombo = new JPanel();
        pnlCombo.add(lblCombo);
        pnlCombo.add(cbNbJoueurs);
        pnlCombo.setMaximumSize(new Dimension(Integer.MAX_VALUE,pnlCombo.getPreferredSize().height));
        pnlCombo.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Labels et Textarea Joueurs

        pnlJoueurs = new JPanel();
        pnlJoueurs.setLayout(new BoxLayout(pnlJoueurs, BoxLayout.PAGE_AXIS));
        updateNbJoueurs();


        btnPlay = new JButton("Jouer");
        btnPlay.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        btnPlay.setPreferredSize(new Dimension(20, 50));
        btnPlay.setActionCommand("jouer");
        btnPlay.addActionListener(menuListener);

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

    public void updateNbJoueurs()
    {
        pnlJoueurs.removeAll();
        lblNomJoueurs = new ArrayList<>();
        txtFldNomJoueurs = new ArrayList<>();
        for(int i = 0; i<nbJoueurs; i++)
        {
            String stringLbl = String.format("Joueur %d", i+1);
            JLabel lblNomJoueur = new JLabel(stringLbl);
            JTextField txtFldJoueur = new JTextField();
            txtFldJoueur.setColumns( 20 );
            CarreColoree carre = new CarreColoree(arrayColor[i]);

            lblNomJoueurs.add(lblNomJoueur);
            txtFldNomJoueurs.add(txtFldJoueur);


            JPanel pnl = new JPanel();
            pnl.setLayout(new FlowLayout());
            pnl.add(lblNomJoueur);
            pnl.add(txtFldJoueur);
            pnl.add(carre);
            pnlJoueurs.add(pnl);
        }
        updateUI();
    }

    public class CarreColoree extends JPanel{
        public CarreColoree(Color color){
            this.setBackground(color);
        }
    }
}
