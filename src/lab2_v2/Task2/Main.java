package lab2_v2.Task2;

import lab2_v2.Task2.console.ConsoleController;
import lab2_v2.Task2.console.ConsoleView;
import lab2_v2.Task2.ui.Driver;


public class Main {

    public static void main(String[] args) {
        NumbersModel model = new NumbersModel();
        Thread cuiThread = new Thread() {
            @Override
            public void run() {
                ConsoleView consoleView = new ConsoleView();
                ConsoleController consoleController = new ConsoleController(model, consoleView);
                model.getPublisher().subscribe(consoleView);
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