package view;

import javax.swing.*;
import java.awt.*;

public class CartaView extends JPanel {

    private ImageIcon menuBackground;
    private JLabel jlMenu;

    public CartaView() {

        menuBackground = new ImageIcon("photos//menu_bg.png");

        Image image = menuBackground.getImage();
        Image newMenu = image.getScaledInstance(900, 1500,  java.awt.Image.SCALE_SMOOTH);
        menuBackground = new ImageIcon(newMenu);

        jlMenu = new JLabel("",menuBackground,JLabel.CENTER);
        jlMenu.setBounds(0,-20,900,1500);
        jlMenu.setVisible(true);
        add(jlMenu);

        setLayout(null);
        setBackground(new Color(Color.white.getRGB()));
    }

    public JLabel getNewPlato(String nombre) {
        JLabel jlPlato = new JLabel(nombre);
        return jlPlato;
    }
}
