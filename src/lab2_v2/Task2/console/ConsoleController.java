package lab2_v2.Task2.console;

import lab2_v2.Task2.NumbersModel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleController {

    private NumbersModel model;
    private ConsoleView view;

    public ConsoleController(NumbersModel model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public boolean execute(String command) {
        List<String> cmdList = Arrays.asList(command.split("\\s"));
        if (cmdList.contains("add")) {
            int indexOfCmd = cmdList.indexOf("add");
            if (cmdList.size() != 2 || indexOfCmd != 0) {
                view.printErrorMessage();
                return true;
            }
            String str = cmdList.get(indexOfCmd + 1);
            model.addNumber(Integer.parseInt(str));
            return true;
        }
        if (cmdList.contains("rm")) {
            int indexOfCmd = cmdList.indexOf("rm");
            if (cmdList.size() != 2 || indexOfCmd != 0) {
                view.printErrorMessage();
                return true;
            }
            int index = Integer.parseInt(cmdList.get(indexOfCmd + 1));
            model.deleteNumber(index);
            return true;
        }
        if (cmdList.contains("ls")) {
            int indexOfCmd = cmdList.indexOf("ls");
            if (indexOfCmd != 0) {
                view.printErrorMessage();
                return true;
            }
            view.printNumbers(model);
            return true;
        }
        if (cmdList.contains("q")) {
            return false;
        }
        return true;
    }

    public void run() {
        try (Scanner sc = new Scanner(System.in)) {
            String command;
            do {
                command = sc.nextLine();
            } while (execute(command));
        }
    }

}
