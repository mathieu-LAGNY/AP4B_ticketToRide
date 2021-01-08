package main;

import javax.swing.*;
import java.awt.*;

public class RoutePanel extends JPanel{

    private JLabel lblTitre;

    private JButton btnPlay;

    private JLabel lblRoute;

    private JPanel pnlRoute;

    private JPanel pnlImage;

    private JPanel pnlRouteChoix;

    public RoutePanel()
    {

        lblTitre = new JLabel("Ticket to UTBM");
        lblTitre.setFont (lblTitre.getFont ().deriveFont (64.0f));
        lblTitre.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        pnlImage = new JPanel();
        JImagePanel carte = new JImagePanel("map.png");// Mettre emplacement ou nom de l'image si dans le même dossier que le code
        //Centrer l'image
        carte.setStretch(true);
        carte.setPreferredSize(new Dimension(1054, 624));
        pnlImage.add(carte);
        pnlImage.setPreferredSize(new Dimension(1054, 624));
        lblRoute = new JLabel("Choix des Cartes Destinations");
        pnlRoute = new JPanel();
        pnlRoute.add(lblRoute);
        pnlRoute.setMaximumSize(new Dimension(Integer.MAX_VALUE,pnlRoute.getPreferredSize().height));
        pnlRoute.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        pnlRouteChoix = new JPanel();
        JTextField txtFldRoute = new JTextField();
        txtFldRoute.setColumns( 20 );
        pnlRouteChoix.add(txtFldRoute);
        pnlRouteChoix.setMaximumSize(new Dimension(Integer.MAX_VALUE,pnlRouteChoix.getPreferredSize().height));
        pnlRouteChoix.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        //Labels et Textarea Joueurs

        btnPlay = new JButton("Valider Route");
        btnPlay.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        btnPlay.setPreferredSize(new Dimension(20, 50));

        //Layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(lblTitre);
        this.add(Box.createHorizontalStrut(1100));
        this.add(pnlImage);
        this.add(Box.createHorizontalStrut(10));
        this.add(pnlRoute);
        this.add(Box.createHorizontalStrut(10));
        this.add(pnlRouteChoix);
        this.add(Box.createHorizontalStrut(10));
        this.add(btnPlay);
    }
}
