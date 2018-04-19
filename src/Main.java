import controller.MainViewControllers;
import view.MainView;
import view.ReservaAhoraView;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView mainView = new MainView();
                ReservaAhoraView reservaAhoraView = new ReservaAhoraView();
                MainViewControllers mainViewControllers = new MainViewControllers(mainView,reservaAhoraView);

                mainView.registerControllers(mainViewControllers);
            }
        });
    }
}
