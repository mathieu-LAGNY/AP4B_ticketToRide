package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Destination extends Carte {
    private UV UVA;
    private UV UVB;
    private int valeur;

    public Destination(UV UVA, UV UVB, int valeur) {
        this.UVA = UVA;
        this.UVB = UVB;
        this.valeur = valeur;
    }

    /**
     * @return la valeur en points de la carte
     */
    public int getValeur() {
        return valeur;
    }

    public boolean valide(Joueur joueur) {
        return joueur.UVpeuventEtreReliees(UVA,UVB,joueur.getRoutes());
    }

    //Représentationn graphique d'une carte destination
    public JPanel toPanel()
    {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JPanel panelDestination = new JPanel();
        JPanel panelUV = new JPanel();

        JLabel lblUva = new JLabel(UVA.toString());
        JLabel lblUvb = new JLabel(UVB.toString());
        JLabel lblVal = new JLabel(String.valueOf(valeur));

        panelDestination.setLayout(new BoxLayout(panelDestination, BoxLayout.PAGE_AXIS));

        panelUV.add(lblUva);
        panelUV.add(lblUvb);
        panelUV.setBorder(blackline);

        panelDestination.add(panelUV);
        panelDestination.add(lblVal);

        panelDestination.setBorder(blackline);

        panelDestination.setMaximumSize(new Dimension(100, 240));
        return panelDestination;
    }

    @Override
    public String toString() {
        return UVA + "-" +
                UVB +
                " " + valeur;
    }
}
