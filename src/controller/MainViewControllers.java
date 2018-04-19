package controller;

import view.MainView;
import view.ReservaAhoraView;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainViewControllers implements ActionListener {

    private MainView mainView;
    private ReservaAhoraView reservaAhoraView;

    public MainViewControllers(MainView mainView, ReservaAhoraView reservaAhoraView) {
        this.reservaAhoraView = reservaAhoraView;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Pedir ahora":
                mainView.getCartaView().setVisible(false);
                mainView.getLogoView().setVisible(false);
                mainView.getReservarLaterView().setVisible(false);
                mainView.getReservaAhoraView().setVisible(true);
                mainView.getReservaAhoraView().getJtxtNombre().setEnabled(true);
                mainView.getReservaAhoraView().getJbPedir().setEnabled(false);
                mainView.getReservaAhoraView().getJlNombre().setEnabled(true);
                mainView.getReservaAhoraView().getJtxtNombre().setText("");
                mainView.getReservaAhoraView().noShowOk();
                mainView.getReservaAhoraView().getJlContraseña().setText(mainView.getReservaAhoraView().generateSessionKey(7));
                mainView.getJlCmbBoxPersonas().setEnabled(false);
                mainView.getReservaAhoraView().getJlNumComensales().setText(mainView.getJlCmbBoxPersonas().getSelectedItem().toString());
                mainView.getReservaAhoraView().getJbAtras().setEnabled(true);
                break;

            case "Reservar luego":
                mainView.getCartaView().setVisible(false);
                mainView.getLogoView().setVisible(false);
                mainView.getReservaAhoraView().setVisible(false);
                mainView.getReservarLaterView().setVisible(true);
                mainView.getJlCmbBoxPersonas().setEnabled(false);
                mainView.getReservarLaterView().getJlNumComensales().setText(mainView.getJlCmbBoxPersonas().getSelectedItem().toString());
                mainView.getReservarLaterView().unselectToggled();
                mainView.getReservarLaterView().getJlFecha().setVisible(false);
                mainView.getReservarLaterView().getJlHoraReserva().setVisible(false);
                mainView.getReservarLaterView().getJlName().setVisible(false);
                mainView.getReservarLaterView().getJtxtNombre().setText("");
                mainView.getReservarLaterView().getJlOk().setVisible(false);
                mainView.getReservarLaterView().getJlLabelFecha().setVisible(false);
                mainView.getReservarLaterView().getJlLabelHora().setVisible(false);
                mainView.getReservarLaterView().getJlLabelNombre().setVisible(false);
                mainView.getReservarLaterView().getJbOk().setVisible(false);
                mainView.getReservarLaterView().getJlLabelClave().setVisible(false);
                mainView.getReservarLaterView().getJlLabelMesa().setVisible(false);

                mainView.getReservarLaterView().getCalendario().setEnabled(true);
                mainView.getReservarLaterView().getJb12().setEnabled(true);
                mainView.getReservarLaterView().getJb14().setEnabled(true);
                mainView.getReservarLaterView().getJb20().setEnabled(true);
                mainView.getReservarLaterView().getJb22().setEnabled(true);
                mainView.getReservarLaterView().getJbReservar().setEnabled(false);
                mainView.getReservarLaterView().getCalendario().setDate(new Date());
                // Revisar que se hayan seleccionado todos los datos antes de habilitar el botón de reservar

                mainView.getReservarLaterView().getJtxtNombre().getDocument().addDocumentListener(new DocumentListener() {
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
                        if (mainView.getReservarLaterView().getJtxtNombre().getText().equals("")){
                            mainView.getReservarLaterView().getJbReservar().setEnabled(false);
                        }
                        else {
                            if (mainView.getReservarLaterView().oneIsSelected()) {
                                mainView.getReservarLaterView().getJbReservar().setEnabled(true);
                            }
                        }

                    }
                });

                break;

            case "De acuerdo":
                mainView.getReservaAhoraView().setVisible(false);
                mainView.getReservarLaterView().setVisible(false);
                // Habilitar los botones principales
                mainView.getJbReservaNow().setEnabled(true);
                mainView.getJbCarta().setEnabled(true);
                mainView.getJbReservaLater().setEnabled(true);
                mainView.getJbEditar().setEnabled(true);
                mainView.getJlCmbBoxPersonas().setEnabled(true);
                mainView.getReservaAhoraView().getJlNumComensales().setEnabled(true);
                mainView.getReservaAhoraView().getJlComensales().setEnabled(true);

                break;

            case "Reservar ahora":
                mainView.getReservaAhoraView().showOk();
                mainView.getReservaAhoraView().getJtxtNombre().setEnabled(false);
                // Pasar el texto del textfield al jlabel del nombre de reserva
                mainView.getReservaAhoraView().getJlName().setText(mainView.getReservaAhoraView().getJtxtNombre().getText());

                mainView.getReservaAhoraView().getJbPedir().setEnabled(false);
                mainView.getReservaAhoraView().getJlNombre().setEnabled(false);
                // Deshabilitar los botones del menu principal hasta que el cliente le de al botón 'De acuerdo'
                mainView.getJbReservaNow().setEnabled(false);
                mainView.getJbCarta().setEnabled(false);
                mainView.getJbReservaLater().setEnabled(false);
                mainView.getJbEditar().setEnabled(false);
                mainView.getJlCmbBoxPersonas().setEnabled(false);
                mainView.getReservaAhoraView().getJlNumComensales().setEnabled(false);
                mainView.getReservaAhoraView().getJlComensales().setEnabled(false);

                mainView.getReservaAhoraView().getJlNumMesa().setText(mainView.getReservaAhoraView().generateRandomInt(50,1));
                mainView.getReservaAhoraView().getJbAtras().setEnabled(false);

                break;

            case "Comensales":
                if (Integer.parseInt(mainView.getJlCmbBoxPersonas().getSelectedItem().toString()) > 0) {
                    mainView.getJbReservaNow().setEnabled(true);
                    mainView.getJbReservaLater().setEnabled(true);
                }
                else {
                    mainView.getJbReservaNow().setEnabled(false);
                    mainView.getJbReservaLater().setEnabled(false);
                }

                break;

            case "AtrasAhora":
                mainView.getReservaAhoraView().setVisible(false);
                mainView.getJlCmbBoxPersonas().setEnabled(true);
                mainView.getLogoView().setVisible(true);

                break;

            case "AtrasLater":
                mainView.getReservarLaterView().setVisible(false);
                mainView.getJlCmbBoxPersonas().setEnabled(true);
                mainView.getLogoView().setVisible(true);

                break;

            case "Reserva luego Ahora":
                mainView.getReservarLaterView().getJlHoraReserva().setText(mainView.getReservarLaterView().getToggled().getText());
                mainView.getReservarLaterView().getJlHoraReserva().setVisible(true);
                mainView.getReservarLaterView().getJlFecha().setVisible(true);
                mainView.getReservarLaterView().getJlName().setText(mainView.getReservarLaterView().getJtxtNombre().getText());
                mainView.getReservarLaterView().getJlName().setVisible(true);
                mainView.getReservarLaterView().getJlOk().setVisible(true);
                mainView.getReservarLaterView().getCalendario().setEnabled(false);
                mainView.getReservarLaterView().getJb12().setEnabled(false);
                mainView.getReservarLaterView().getJb14().setEnabled(false);
                mainView.getReservarLaterView().getJb20().setEnabled(false);
                mainView.getReservarLaterView().getJb22().setEnabled(false);
                mainView.getReservarLaterView().getJbReservar().setEnabled(false);
                mainView.getReservarLaterView().getJlLabelFecha().setVisible(true);
                mainView.getReservarLaterView().getJlLabelHora().setVisible(true);
                mainView.getReservarLaterView().getJlLabelNombre().setVisible(true);
                mainView.getReservarLaterView().getJlLabelClave().setVisible(false);
                mainView.getJbReservaNow().setEnabled(false);
                mainView.getJbReservaLater().setEnabled(false);
                mainView.getJbEditar().setEnabled(false);
                mainView.getJbCarta().setEnabled(false);
                mainView.getReservarLaterView().getJbOk().setVisible(true);
                mainView.getReservarLaterView().getJbAtras().setEnabled(false);
                mainView.getReservarLaterView().getJtxtNombre().setEnabled(false);
                mainView.getReservarLaterView().getJlClave().setText(mainView.getReservaAhoraView().generateSessionKey(7));
                mainView.getReservarLaterView().getJlClave().setVisible(true);
                mainView.getReservarLaterView().getJlLabelClave().setVisible(true);
                mainView.getReservarLaterView().getJlDone().setVisible(true);
                mainView.getReservarLaterView().getJlLabelMesa().setVisible(true);
                mainView.getReservarLaterView().getJlMesa().setText(mainView.getReservaAhoraView().generateRandomInt(50,1));
                mainView.getReservarLaterView().getJlMesa().setVisible(true);

                break;

            case "De acuerdo Later":
                mainView.getJbReservaNow().setEnabled(true);
                mainView.getJbReservaLater().setEnabled(true);
                mainView.getJbEditar().setEnabled(true);
                mainView.getJbCarta().setEnabled(true);
                mainView.getJlCmbBoxPersonas().setEnabled(true);
                mainView.getReservarLaterView().getJbAtras().setEnabled(true);
                mainView.getReservarLaterView().setVisible(false);
                mainView.getReservarLaterView().getJtxtNombre().setEnabled(true);
                mainView.getReservarLaterView().getJlClave().setVisible(false);
                mainView.getReservarLaterView().getJlLabelClave().setVisible(false);
                mainView.getReservarLaterView().getJlDone().setVisible(false);
                mainView.getReservarLaterView().getJlLabelMesa().setVisible(false);
                mainView.getReservarLaterView().getJlMesa().setVisible(false);
                mainView.getLogoView().setVisible(true);

                break;

            case "Mostrar Carta":
                mainView.getLogoView().setVisible(false);
                mainView.getReservarLaterView().setVisible(false);
                mainView.getReservaAhoraView().setVisible(false);
                mainView.getCartaView().setVisible(true);

                break;
        }
    }
}
