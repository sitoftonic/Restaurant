package view;

import javax.swing.*;
import java.awt.*;

public class LogoView extends JPanel {

    private ImageIcon logo;
    private JLabel jlLogo;



    public LogoView() {

        logo = new ImageIcon("photos//LogoRestaurante.png");

        Image image = logo.getImage();
        Image newLogo = image.getScaledInstance(900, 700,  java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(newLogo);

        jlLogo = new JLabel("",logo,JLabel.CENTER);
        jlLogo.setBounds(0,400,1091,817);
        jlLogo.setVisible(true);
        add(jlLogo);
        setBackground(new Color(Color.white.getRGB()));

    }

}
