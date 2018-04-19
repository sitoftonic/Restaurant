package view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Random;

public class ReservaAhoraView extends JPanel {

    private JLabel jlNumComensales;
    private JLabel jlComensales;
    private JLabel jlNombre;
    private JLabel jlAdelante;
    private JLabel jlOk;
    private JLabel jlContraseña;
    private JLabel jlNombreConfirm;
    private JLabel jlPassConfirm;
    private JLabel jlMesa;
    private JLabel jlNumMesa;
    private JLabel jlName;
    private JTextField jtxtNombre;
    private JButton jbPedir;
    private JButton jbDeAcuerdo;
    private JButton jbAtras;



    public ReservaAhoraView(){
        setLayout(null);
        setBackground(new Color(Color.white.getRGB()));

        jlComensales = new JLabel("Número de comensales:");
        jlComensales.setFont(new Font("Javanese Text",Font.BOLD,40));
        jlComensales.setBounds(70,30,750,60);
        add(jlComensales);

        jlNumComensales = new JLabel("1");
        jlNumComensales.setFont(new Font("Arial", Font.BOLD, 35));
        jlNumComensales.setBounds(530,23,200,60);
        add(jlNumComensales);

        jlNombre = new JLabel("Introduzca nombre de la mesa:");
        jlNombre.setFont(new Font("Javanese Text",Font.BOLD,40));
        jlNombre.setBounds(70,100,750,60);
        add(jlNombre);

        jtxtNombre = new JTextField();
        jtxtNombre.setBounds(70,200,750,60);
        jtxtNombre.setFont(new Font("Javanese Text",Font.BOLD,40));
        add(jtxtNombre);

        jtxtNombre.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (jtxtNombre.getText().equals("")){
                    jbPedir.setEnabled(false);
                }
                else {
                    jbPedir.setEnabled(true);
                }

            }
        });

        jbPedir = new JButton("Pedir mesa para ahora");
        jbPedir.setBounds(70,300,750,80);
        jbPedir.setFont(new Font("Javanese Text",Font.BOLD,40));
        add(jbPedir);

        ImageIcon imageOk = new ImageIcon("photos/ok.png");
        jlOk = new JLabel("",imageOk,JLabel.CENTER);
        jlOk.setForeground(new Color(Color.green.getRGB()));
        jlOk.setBounds(300,450,350,350);
        jlOk.setVisible(false);
        add(jlOk);

        jlAdelante = new JLabel("Adelante! \nYa puede pasar al restaurante.");
        jlAdelante.setFont(new Font("Javanese Text",Font.BOLD,40));
        jlAdelante.setForeground(new Color(Color.green.getRGB()).darker());
        jlAdelante.setBounds(70,780,800,80);
        jlAdelante.setVisible(false);
        add(jlAdelante);

        jlNombreConfirm = new JLabel("Su nombre de reserva es: ");
        jlNombreConfirm.setFont(new Font("Javanese Text",Font.BOLD,30));
        jlNombreConfirm.setBounds(70,910,700,60);
        jlNombreConfirm.setVisible(false);
        add(jlNombreConfirm);

        jlName = new JLabel();
        jlName.setFont(new Font("Arial",Font.BOLD,35));
        jlName.setBounds(460,901,700,60);
        jlName.setVisible(false);
        add(jlName);

        jlPassConfirm = new JLabel("Su contraseña de reserva es: ");
        jlPassConfirm.setFont(new Font("Javanese Text",Font.BOLD,30));
        jlPassConfirm.setBounds(70,990,700,60);
        jlPassConfirm.setVisible(false);
        add(jlPassConfirm);

        jlContraseña = new JLabel(generateSessionKey(7));
        jlContraseña.setFont(new Font("Arial", Font.BOLD, 35));
        jlContraseña.setBounds(505,983,200,60);
        jlContraseña.setVisible(false);
        add(jlContraseña);

        jlMesa = new JLabel("Se le ha asignado la mesa número:");
        jlMesa.setFont(new Font("Javanese Text",Font.BOLD,30));
        jlMesa.setBounds(70,1080,700,60);
        jlMesa.setVisible(false);
        add(jlMesa);

        jlNumMesa = new JLabel(generateRandomInt(50,1));
        jlNumMesa.setFont(new Font("Arial",Font.BOLD,35));
        jlNumMesa.setBounds(600,1075,700,60);
        jlNumMesa.setVisible(false);
        add(jlNumMesa);

        jbDeAcuerdo = new JButton("De acuerdo");
        jbDeAcuerdo.setBounds(70,1180,750,80);
        jbDeAcuerdo.setFont(new Font("Javanese Text",Font.BOLD,40));
        jbDeAcuerdo.setVisible(false);
        add(jbDeAcuerdo);

        jbAtras = new JButton("Atrás");
        jbAtras.setFont(new Font("Javanese Text", Font.BOLD,30));
        jbAtras.setBounds(530,1400,300,60);
        jbAtras.setVisible(true);
        add(jbAtras);

    }

    // Función para generar cadena random
    public static String generateSessionKey(int length){
        String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        int n = alphabet.length(); //10

        String result = new String();
        Random r = new Random(); //11

        for (int i=0; i<length; i++) //12
            result = result + alphabet.charAt(r.nextInt(n)); //13

        return result;
    }

    public static String generateRandomInt(int maximum, int minimum) {
        Random rand = new Random();
        return Integer.toString((rand.nextInt((maximum - minimum) + 1) + minimum));
    }

    public JButton getJbDeAcuerdo() {
        return jbDeAcuerdo;
    }

    public void showOk() {
        jlOk.setVisible(true);
        jlAdelante.setVisible(true);
        jlNombreConfirm.setVisible(true);
        jlName.setVisible(true);
        jlPassConfirm.setVisible(true);
        jlContraseña.setVisible(true);
        jlMesa.setVisible(true);
        jbDeAcuerdo.setVisible(true);
        jlNumMesa.setVisible(true);
    }

    public void noShowOk() {
        jlOk.setVisible(false);
        jlAdelante.setVisible(false);
        jlNombreConfirm.setVisible(false);
        jlName.setVisible(false);
        jlPassConfirm.setVisible(false);
        jlContraseña.setVisible(false);
        jlMesa.setVisible(false);
        jbDeAcuerdo.setVisible(false);
        jlNumMesa.setVisible(false);
    }

    public JLabel getJlContraseña() {
        return jlContraseña;
    }

    public void setJlContraseña(JLabel jlContraseña) {
        this.jlContraseña = jlContraseña;
    }

    public JLabel getJlNombre() {
        return jlNombre;
    }

    public JTextField getJtxtNombre() {
        return jtxtNombre;
    }

    public JLabel getJlName() {
        return jlName;
    }

    public void setJlName(JLabel jlName) {

        this.jlName = jlName;
    }

    public JButton getJbPedir() {
        return jbPedir;
    }

    public JLabel getJlNumComensales() {
        return jlNumComensales;
    }

    public void setJlNumComensales(JLabel jlNumComensales) {
        this.jlNumComensales = jlNumComensales;
    }

    public JLabel getJlComensales() {
        return jlComensales;
    }

    public void setJlComensales(JLabel jlComensales) {
        this.jlComensales = jlComensales;
    }

    public JLabel getJlNumMesa() {
        return jlNumMesa;
    }

    public void setJlNumMesa(JLabel jlNumMesa) {
        this.jlNumMesa = jlNumMesa;
    }

    public JButton getJbAtras() {
        return jbAtras;
    }

    public void setJbAtras(JButton jbAtras) {
        this.jbAtras = jbAtras;
    }

    public static void main(String[] args) {
        ReservaAhoraView reservaAhoraView = new ReservaAhoraView();
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(reservaAhoraView);
        jFrame.setVisible(true);
        jFrame.setSize(950,2000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
