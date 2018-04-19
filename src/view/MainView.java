package view;

import controller.MainViewControllers;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class MainView extends JFrame {

    private JPanel jpMain;

    private JButton jbReservaNow;
    private JButton jbReservaLater;
    private JButton jbEditar;
    private JButton jbCarta;

    private JLabel jlPersonas;
    private JLabel jlNumMesas;
    private JLabel jlMesas;
    private JLabel jlNumTiempo;
    private JLabel jlTiempo;
    private JLabel jlLogo;

    private String[] personas = { "0", "1", "2", "3", "4", "5", "6",
                                    "7", "8", "9", "10", "11", "12",
                                    "13", "14", "15", "16", "17", "18",
                                    "19", "20", "21", "22", "23", "24" };
    private JComboBox jlCmbBoxPersonas;

    private ReservaAhoraView reservaAhoraView;
    private ReservarLaterView reservarLaterView;
    private CartaView cartaView;
    private LogoView logoView;

    private URL url;



    public MainView() {

        jpMain = new JPanel(null); // Pongo NULL como layout para poder poner libremente elementos
                                        // con el método setBounds de la clase Component
        jpMain.setBackground(new Color(Color.white.getRGB()));

        /*
        ImageIcon imageOk = new ImageIcon("photos/fondoReserva.png");
        jlLogo = new JLabel("",imageOk,JLabel.CENTER);
        jlLogo.setForeground(new Color(Color.green.getRGB()));
        jlLogo.setBounds(0,950,1000,550);
        jlLogo.setVisible(true);
        jpMain.add(jlLogo);
        */

        jlPersonas = new JLabel("Número de comensales:");
        jlPersonas.setFont(new Font("Javanese Text",Font.BOLD,50));
        jlPersonas.setBounds(300,100,600,60);
        jpMain.add(jlPersonas);

        jlCmbBoxPersonas = new JComboBox(personas);
        jlCmbBoxPersonas.setFont(new Font("Javanese Text",Font.BOLD,40));
        jlCmbBoxPersonas.setBounds(1300,80,80,70);
        jpMain.add(jlCmbBoxPersonas);

        jlMesas = new JLabel("Número de mesas disponibles:");
        jlMesas.setFont(new Font("Javanese Text",Font.BOLD,50));
        jlMesas.setBounds(300,250,900,60);
        jpMain.add(jlMesas);

        jlNumMesas = new JLabel("--");
        jlNumMesas.setFont(new Font("Javanese Text",Font.BOLD,50));
        jlNumMesas.setBounds(1300,250,200,50);
        jpMain.add(jlNumMesas);


        jlTiempo = new JLabel("Tiempo de espera:");
        jlTiempo.setFont(new Font("Javanese Text",Font.BOLD,50));
        jlTiempo.setBounds(300,400,600,60);
        jpMain.add(jlTiempo);

        jlNumTiempo = new JLabel("--");
        jlNumTiempo.setFont(new Font("Javanese Text",Font.BOLD,50));
        jlNumTiempo.setBounds(1300,400,200,50);
        jpMain.add(jlNumTiempo);

        jbReservaNow = new JButton("Pedir mesa");
        jbReservaNow.setFont(new Font("Javanese Text",Font.BOLD,60));
        jbReservaNow.setBounds(300,600,1000,150);
        jbReservaNow.setEnabled(false);
        jpMain.add(jbReservaNow);

        jbReservaLater = new JButton("Reservar");
        jbReservaLater.setFont(new Font("Javanese Text",Font.BOLD,60));
        jbReservaLater.setBounds(300,800,1000,150);
        jbReservaLater.setEnabled(false);
        jpMain.add(jbReservaLater);

        jbEditar = new JButton("Editar reserva");
        jbEditar.setFont(new Font("Javanese Text",Font.BOLD,60));
        jbEditar.setBounds(300,1000,1000,150);
        jpMain.add(jbEditar);

        jbCarta = new JButton("Ver nuestra carta");
        jbCarta.setFont(new Font("Javanese Text",Font.BOLD,60));
        jbCarta.setBounds(300,1200,1000,150);
        jpMain.add(jbCarta);

        // JPanel que se muestra al principio y que tiene el logo
        logoView = new LogoView();
        logoView.setBounds(1630,300,950,2000);
        logoView.setVisible(true);
        jpMain.add(logoView);

        // JPanel que se muestra si se clica el botón de Pedir Mesa para ahora
        reservaAhoraView = new ReservaAhoraView();
        reservaAhoraView.setBounds(1630,0,950,2000);
        reservaAhoraView.setVisible(false);
        jpMain.add(reservaAhoraView);

        // JPanel que se muestra si se clica el botón de Reservar para más tarde
        reservarLaterView = new ReservarLaterView();
        reservarLaterView.setBounds(1630,0,950,2000);
        reservarLaterView.setVisible(false);
        jpMain.add(reservarLaterView);

        // JPanel que muestra el menú
        cartaView = new CartaView();
        cartaView.setBounds(1630,0,950,2000);
        cartaView.setVisible(false);
        jpMain.add(cartaView);


        // JLabel que se pone visible solo si hay 0 mesas disponibles ahora
        JLabel jlNoDisp = new JLabel("Ahora mismo no hay mesas disponibles con esa cantidad de comensales.");
        jlNoDisp.setFont(new Font("Javanese Text",Font.PLAIN,20));
        jlNoDisp.setForeground(new Color(Color.red.getRGB()));
        jlNoDisp.setBounds(450,540,700,70);
        jlNoDisp.setVisible(false);
        jpMain.add(jlNoDisp);

        // Separador
        JSeparator jSeparator = new JSeparator(JSeparator.VERTICAL);
        jSeparator.setBounds(1600,0,20,2500);
        jSeparator.setForeground(new Color(Color.black.getRGB()));
        jpMain.add(jSeparator);






        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(3000,1600);
        setContentPane(jpMain);
        setTitle("CentralisedRestaurant - Reserva");
        setVisible(true);

    }

    public ReservaAhoraView getReservaAhoraView() {
        return reservaAhoraView;
    }

    public ReservarLaterView getReservarLaterView() {
        return reservarLaterView;
    }

    public CartaView getCartaView() {
        return cartaView;
    }

    public void setCartaView(CartaView cartaView) {
        this.cartaView = cartaView;
    }

    public LogoView getLogoView() {
        return logoView;
    }

    public void setLogoView(LogoView logoView) {
        this.logoView = logoView;
    }

    public void setReservaAhoraView(ReservaAhoraView reservaAhoraView) {
        this.reservaAhoraView = reservaAhoraView;
    }

    public JComboBox getJlCmbBoxPersonas() {
        return jlCmbBoxPersonas;
    }

    public void setJlCmbBoxPersonas(JComboBox jlCmbBoxPersonas) {
        this.jlCmbBoxPersonas = jlCmbBoxPersonas;
    }

    public JButton getJbReservaNow() {

        return jbReservaNow;
    }

    public void setJbReservaNow(JButton jbReservaNow) {
        this.jbReservaNow = jbReservaNow;
    }

    public JButton getJbReservaLater() {
        return jbReservaLater;
    }

    public void setJbReservaLater(JButton jbReservaLater) {
        this.jbReservaLater = jbReservaLater;
    }

    public JButton getJbEditar() {
        return jbEditar;
    }

    public void setJbEditar(JButton jbEditar) {
        this.jbEditar = jbEditar;
    }

    public JButton getJbCarta() {
        return jbCarta;
    }

    public void setJbCarta(JButton jbCarta) {
        this.jbCarta = jbCarta;
    }

    public void registerControllers(MainViewControllers mainViewControllers){
        jbReservaNow.addActionListener(mainViewControllers);
        jbReservaNow.setActionCommand("Pedir ahora");

        jbReservaLater.addActionListener(mainViewControllers);
        jbReservaLater.setActionCommand("Reservar luego");

        getReservaAhoraView().getJbDeAcuerdo().addActionListener(mainViewControllers);
        getReservaAhoraView().getJbDeAcuerdo().setActionCommand("De acuerdo");

        getReservaAhoraView().getJbPedir().addActionListener(mainViewControllers);
        getReservaAhoraView().getJbPedir().setActionCommand("Reservar ahora");

        jlCmbBoxPersonas.addActionListener(mainViewControllers);
        jlCmbBoxPersonas.setActionCommand("Comensales");

        getReservaAhoraView().getJbAtras().addActionListener(mainViewControllers);
        getReservaAhoraView().getJbAtras().setActionCommand("AtrasAhora");

        getReservarLaterView().getJbAtras().addActionListener(mainViewControllers);
        getReservarLaterView().getJbAtras().setActionCommand("AtrasLater");

        getReservarLaterView().getJbReservar().addActionListener(mainViewControllers);
        getReservarLaterView().getJbReservar().setActionCommand("Reserva luego Ahora");

        getReservarLaterView().getJbOk().addActionListener(mainViewControllers);
        getReservarLaterView().getJbOk().setActionCommand("De acuerdo Later");

        jbCarta.addActionListener(mainViewControllers);
        jbCarta.setActionCommand("Mostrar Carta");

    }
}
