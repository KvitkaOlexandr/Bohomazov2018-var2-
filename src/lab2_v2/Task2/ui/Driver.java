package lab2_v2.Task2.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lab2_v2.Task2.NumbersModel;

public class Driver extends Application {

    private static NumbersModel model;
    private UIView view;

    public void run(String[] args) {
        Application.launch(Driver.class, args);
    }

    @Override
    public void start(Stage stage) {
        view = new UIController(model).getView();
        Scene scene = new Scene(view, 400, 300);
        stage.setTitle("Longest string");
        stage.setScene(scene);
        stage.show();
    }

    public static void setModel(NumbersModel model) {
        Driver.model = model;
    }

    public UIView getView() {
        return view;
    }
}
