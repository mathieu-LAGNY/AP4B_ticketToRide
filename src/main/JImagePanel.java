package main;
import javax.swing.*;
import java.awt.*;

public class JImagePanel extends JPanel {

    private Image image = null;
    private Boolean stretch = true;

    /**
     * Constructeur
     *
     * @param image image à afficher
     */
    public JImagePanel(Image image) {
        this.image = image;
    }

    /**
     * Constructeur
     *
     * @param file nom du fichier
     */
    public JImagePanel(String file) {
        this.image = getToolkit().getImage(file);
    }

    /**
     * Position de l'image sur le panel
     *
     * @param stretch true: etirer l'image / false: centrer l'image
     */
    public void setStretch(Boolean stretch) {
        this.stretch = stretch;
    }

    /**
     * Surcharger le dessin du composant
     *
     * @param g canvas
     */
    protected void paintComponent(Graphics g) {
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;

        if (this.stretch) {
            width = this.getWidth();
            height = this.getHeight();
        } else {
            width = this.image.getWidth(this);
            height = this.image.getHeight(this);
            x = ((this.getWidth() - width) / 2);
            y = ((this.getHeight() - height) / 2);
        }
        g.drawImage(this.image, x, y, width, height, this);
    }
}
