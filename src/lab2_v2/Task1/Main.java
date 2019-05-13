package lab2_v2.Task1;

import lab2_v2.Task1.console.ConsoleController;
import lab2_v2.Task1.console.ConsoleView;
import lab2_v2.Task1.ui.Driver;
import lab2_v2.Task1.ui.UIView;

public class Main {

    public static void main(String[] args) {
        StringsModel model = new StringsModel(10);
        Thread cuiThread = new Thread() {
            @Override
            public void run() {
                ConsoleView consoleView = new ConsoleView();
                ConsoleController consoleController = new ConsoleController(model, consoleView);
                model.addObserver(consoleView);
                consoleController.run();
            }
        };

        Thread uiThread = new Thread() {
            @Override
            public void run() {
                Driver.setModel(model);
                Driver driver = new Driver();
                driver.run(args);
            }
        };

        cuiThread.start();
        uiThread.start();
    }

}
