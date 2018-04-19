package view;



import com.toedter.calendar.JCalendar;
import javafx.scene.control.ToggleButton;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Enumeration;
import java.util.Random;

public class ReservarLaterView extends JPanel {

    // Añadir JCalendar.jar al classpath del proyecto
    private JLabel jlSelecciona;
    private JLabel jlNombre;
    private JLabel jlOk;
    private JLabel jlNumComensales;
    private JLabel jlComida;
    private JLabel jlCena;
    private JLabel jlHoraReserva;
    private JLabel jlFecha;
    private JLabel jlName;
    private JLabel jlMesa;
    private JLabel jlLabelNombre;
    private JLabel jlLabelFecha;
    private JLabel jlLabelHora;
    private JLabel jlLabelClave;
    private JLabel jlLabelMesa;
    private JLabel jlClave;
    private JLabel jlDone;

    private JTextField jtxtNombre;
    private JCalendar calendario;
    private JButton jbReservar;
    private JButton jbAtras;
    private JButton jbOk;
    private JToggleButton jb12;
    private JToggleButton jb14;
    private JToggleButton jb20;
    private JToggleButton jb22;

    private ButtonGroup bg;

    private String[] partesFecha;
    private String fechaIngles;
    private String fechaOk;


    public ReservarLaterView() {

        setLayout(null);
        setBackground(new Color(Color.white.getRGB()));

        jlSelecciona = new JLabel("Selecciona la fecha de reserva:");
        jlSelecciona.setFont(new Font("Javanese Text",Font.BOLD,40));
        jlSelecciona.setBounds(65,70,800,60);
        add(jlSelecciona);

        calendario = new JCalendar();
        calendario.setBounds(65,170,380, 460);
        add(calendario);

        JLabel jlComensales = new JLabel("Número de comensales:");
        jlComensales.setFont(new Font("Javanese Text",Font.BOLD,40));
        jlComensales.setBounds(65,10,750,60);
        add(jlComensales);

        jlNumComensales = new JLabel("");
        jlNumComensales.setFont(new Font("Arial", Font.BOLD, 35));
        jlNumComensales.setBounds(532,2,200,60);
        add(jlNumComensales);

        jlNombre = new JLabel("Introduzca nombre de la mesa:");
        jlNombre.setFont(new Font("Javanese Text",Font.BOLD,40));
        jlNombre.setBounds(65,670,750,60);
        add(jlNombre);

        jtxtNombre = new JTextField();
        jtxtNombre.setBounds(65,750,750,60);
        jtxtNombre.setFont(new Font("Javanese Text",Font.BOLD,40));
        add(jtxtNombre);

        jbReservar = new JButton("Reservar");
        jbReservar.setFont(new Font("Javanese Text",Font.BOLD,40));
        jbReservar.setBounds(65,850,750,100);
        add(jbReservar);

        ImageIcon imageOk = new ImageIcon("photos/ok.png");
        jlOk = new JLabel("",imageOk,JLabel.CENTER);
        jlOk.setForeground(new Color(Color.green.getRGB()));
        jlOk.setBounds(15,900,350,350);
        jlOk.setVisible(false);
        add(jlOk);

        jbAtras = new JButton("Atrás");
        jbAtras.setFont(new Font("Javanese Text", Font.BOLD,30));
        jbAtras.setBounds(510,1400,300,60);
        jbAtras.setVisible(true);
        add(jbAtras);

        jlComida = new JLabel("Comida:");
        jlComida.setFont(new Font("Javanese Text",Font.BOLD,30));
        jlComida.setBounds(495,170,200,60);
        add(jlComida);

        jlCena = new JLabel("Cena:");
        jlCena.setFont(new Font("Javanese Text",Font.BOLD,30));
        jlCena.setBounds(495,400,200,60);
        add(jlCena);

        bg = new ButtonGroup();

        jb12 = new JToggleButton("12.00h - 14.00h");
        jb12.setFont(new Font("Arial", Font.PLAIN, 20));
        jb12.setBounds(495,240,300,60);
        jb12.setVisible(true);
        add(jb12);

        jb14 = new JToggleButton("14.00h - 16.00h");
        jb14.setFont(new Font("Arial", Font.PLAIN, 20));
        jb14.setBounds(495,320,300,60);
        jb14.setVisible(true);
        add(jb14);

        jb20 = new JToggleButton("20.00h - 22.00h");
        jb20.setFont(new Font("Arial", Font.PLAIN, 20));
        jb20.setBounds(495,470,300,60);
        jb20.setVisible(true);
        add(jb20);

        jb22 = new JToggleButton("22.00h - 00.00h");
        jb22.setFont(new Font("Arial", Font.PLAIN, 20));
        jb22.setBounds(495,550,300,60);
        jb22.setVisible(true);
        add(jb22);

        bg.add(jb12);
        bg.add(jb14);
        bg.add(jb20);
        bg.add(jb22);


        fechaIngles = calendario.getDate().toString();
        jlFecha = new JLabel("Fecha elegida");
        jlFecha.setText(fechaIngles);
        calendario.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                fechaIngles = calendario.getDate().toString();
                partesFecha = fechaIngles.split(" ");
                switch(partesFecha[0]) {
                    case "Mon":
                        fechaOk = "Lunes, ";
                        break;
                    case "Tue":
                        fechaOk = "Martes, ";
                        break;
                    case "Wed":
                        fechaOk = "Miércoles, ";
                        break;
                    case "Thu":
                        fechaOk = "Jueves, ";
                        break;
                    case "Fri":
                        fechaOk = "Viernes, ";
                        break;
                    case "Sat":
                        fechaOk = "Sábado, ";
                        break;
                    case "Sun":
                        fechaOk = "Domingo, ";
                        break;
                }
                fechaOk = fechaOk + partesFecha[2] + " de ";
                switch(partesFecha[1]) {
                    case "Jan":
                        fechaOk = fechaOk + "Enero de ";
                        break;
                    case "Feb":
                        fechaOk = fechaOk + "Febrero de ";
                        break;
                    case "Mar":
                        fechaOk = fechaOk + "Marzo de ";
                        break;
                    case "Apr":
                        fechaOk = fechaOk + "Abril de ";
                        break;
                    case "May":
                        fechaOk = fechaOk + "Mayo de ";
                        break;
                    case "Jun":
                        fechaOk = fechaOk + "Junio de ";
                        break;
                    case "Jul":
                        fechaOk = fechaOk + "Julio de ";
                        break;
                    case "Aug":
                        fechaOk = fechaOk + "Agosto de ";
                        break;
                    case "Sep":
                        fechaOk = fechaOk + "Septiembre de ";
                        break;
                    case "Oct":
                        fechaOk = fechaOk + "Octubre de ";
                        break;
                    case "Nov":
                        fechaOk = fechaOk + "Noviembre de ";
                        break;
                    case "Dec":
                        fechaOk = fechaOk + "Diciembre de ";
                        break;
                }
                fechaOk = fechaOk + partesFecha[5];
                jlFecha.setText(fechaOk);
            }
        });
        jlFecha.setFont(new Font("Arial", Font.BOLD,25));
        jlFecha.setBounds(515,1015,600,60);
        jlFecha.setVisible(false);
        add(jlFecha);

        jlName = new JLabel("");
        jlName.setFont(new Font("Arial",Font.BOLD,25));
        jlName.setBounds(515,965,600,60);
        jlName.setVisible(false);
        add(jlName);

        jlHoraReserva = new JLabel("--");
        jlHoraReserva.setFont(new Font("Arial",Font.BOLD,25));
        jlHoraReserva.setBounds(515,1065,600,60);
        jlHoraReserva.setVisible(false);
        add(jlHoraReserva);

        jlLabelFecha = new JLabel("Fecha:");
        jlLabelFecha.setFont(new Font("Javanese Text",Font.BOLD,35));
        jlLabelFecha.setBounds(325,1020,200,60);
        jlLabelFecha.setVisible(true);
        add(jlLabelFecha);

        jlLabelNombre = new JLabel("Nombre:");
        jlLabelNombre.setFont(new Font("Javanese Text",Font.BOLD,35));
        jlLabelNombre.setBounds(325,970,300,60);
        jlLabelNombre.setVisible(true);
        add(jlLabelNombre);

        jlLabelHora = new JLabel("Hora:");
        jlLabelHora.setFont(new Font("Javanese Text",Font.BOLD,35));
        jlLabelHora.setBounds(325,1070,200,60);
        jlLabelHora.setVisible(true);
        add(jlLabelHora);

        jlLabelClave = new JLabel("Clave:");
        jlLabelClave.setFont(new Font("Javanese Text",Font.BOLD,35));
        jlLabelClave.setBounds(325,1120,200,60);
        jlLabelClave.setVisible(true);
        add(jlLabelClave);

        jlLabelMesa = new JLabel("Mesa:");
        jlLabelMesa.setFont(new Font("Javanese Text",Font.BOLD,35));
        jlLabelMesa.setBounds(325,1170,200,60);
        jlLabelMesa.setVisible(true);
        add(jlLabelMesa);

        jlMesa = new JLabel();
        jlMesa.setFont(new Font("Arial",Font.BOLD,25));
        jlMesa.setBounds(515,1165,200,60);
        jlMesa.setVisible(true);
        add(jlMesa);

        jlClave = new JLabel();
        jlClave.setFont(new Font("Arial",Font.BOLD,25));
        jlClave.setBounds(515,1115,200,60);
        jlClave.setVisible(true);
        add(jlClave);

        jbOk = new JButton("De acuerdo");
        jbOk.setFont(new Font("Javanese Text", Font.BOLD,40));
        jbOk.setBounds(65,1280,750,80);
        jbOk.setVisible(true);
        add(jbOk);

        jlDone = new JLabel("Se ha realizado la reserva con éxito!");
        jlDone.setFont(new Font("Javanese Text",Font.BOLD,40));
        jlDone.setForeground(new Color(Color.green.getRGB()).darker());
        jlDone.setBounds(65,1210,800,80);
        jlDone.setVisible(false);
        add(jlDone);

    }

    public JLabel getJlMesa() {
        return jlMesa;
    }

    public JLabel getJlLabelMesa() {
        return jlLabelMesa;
    }

    public JLabel getJlDone() {
        return jlDone;
    }

    public JLabel getJlClave() {
        return jlClave;
    }

    public JLabel getJlLabelClave() {
        return jlLabelClave;
    }

    public JButton getJbOk() {
        return jbOk;
    }

    public void setJbOk(JButton jbOk) {
        this.jbOk = jbOk;
    }

    public JLabel getJlLabelNombre() {
        return jlLabelNombre;
    }

    public void setJlLabelNombre(JLabel jlLabelNombre) {
        this.jlLabelNombre = jlLabelNombre;
    }

    public JLabel getJlLabelFecha() {
        return jlLabelFecha;
    }

    public void setJlLabelFecha(JLabel jlLabelFecha) {
        this.jlLabelFecha = jlLabelFecha;
    }

    public JLabel getJlLabelHora() {
        return jlLabelHora;
    }

    public void setJlLabelHora(JLabel jlLabelHora) {
        this.jlLabelHora = jlLabelHora;
    }

    public JLabel getJlNumComensales() {
        return jlNumComensales;
    }

    public void setJlNumComensales(JLabel jlNumComensales) {
        this.jlNumComensales = jlNumComensales;
    }

    public JButton getJbAtras() {
        return jbAtras;
    }

    public void setJbAtras(JButton jbAtras) {
        this.jbAtras = jbAtras;
    }

    public JTextField getJtxtNombre() {
        return jtxtNombre;
    }

    public void setJtxtNombre(JTextField jtxtNombre) {
        this.jtxtNombre = jtxtNombre;
    }

    public JToggleButton getJb12() {
        return jb12;
    }

    public void setJb12(JToggleButton jb12) {
        this.jb12 = jb12;
    }

    public JToggleButton getJb14() {
        return jb14;
    }

    public void setJb14(JToggleButton jb14) {
        this.jb14 = jb14;
    }

    public JToggleButton getJb20() {
        return jb20;
    }

    public void setJb20(JToggleButton jb20) {
        this.jb20 = jb20;
    }

    public JToggleButton getJb22() {
        return jb22;
    }

    public void setJb22(JToggleButton jb22) {
        this.jb22 = jb22;
    }

    public JLabel getJlHoraReserva() {
        return jlHoraReserva;
    }

    public void setJlHoraReserva(JLabel jlHoraReserva) {
        this.jlHoraReserva = jlHoraReserva;
    }

    public JButton getJbReservar() {
        return jbReservar;
    }

    public void setJbReservar(JButton jbReservar) {
        this.jbReservar = jbReservar;
    }

    public ButtonGroup getBg() {
        return bg;
    }

    public void setBg(ButtonGroup bg) {
        this.bg = bg;
    }

    public JCalendar getCalendario() {
        return calendario;
    }

    public void setCalendario(JCalendar calendario) {
        this.calendario = calendario;
    }

    public JLabel getJlFecha() {
        return jlFecha;
    }

    public void setJlFecha(JLabel jlFecha) {
        this.jlFecha = jlFecha;
    }

    public JLabel getJlOk() {
        return jlOk;
    }

    public void setJlOk(JLabel jlOk) {
        this.jlOk = jlOk;
    }

    public JLabel getJlName() {
        return jlName;
    }

    public void setJlName(JLabel jlName) {
        this.jlName = jlName;
    }

    // Función que retorna true si hay un togglebutton de las horas seleccionado
    public boolean oneIsSelected() {
        if (getJb12().isSelected()) {
            return true;
        }
        else {
            if (getJb14().isSelected()) {
                return true;
            }
            else {
                if (getJb20().isSelected()) {
                    return true;
                }
                else {
                    if (getJb22().isSelected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Función que retorna el togglebutton que está presionado
    public JToggleButton getToggled() {
        if (getJb12().isSelected()) {
            return getJb12();
        }
        if (getJb14().isSelected()) {
            return getJb14();
        }
        if (getJb20().isSelected()) {
            return getJb20();
        }
        if (getJb22().isSelected()) {
            return getJb22();
        }
        JToggleButton jtgg = new JToggleButton("--");
        return jtgg;
    }

    // Función que deselecciona todos los botones del buttongroup
    public void unselectToggled() {
        bg.clearSelection();
    }

    public static void main(String[] args) {
        ReservarLaterView reservarLaterView = new ReservarLaterView();
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(reservarLaterView);
        jFrame.setVisible(true);
        jFrame.setSize(950,2000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
