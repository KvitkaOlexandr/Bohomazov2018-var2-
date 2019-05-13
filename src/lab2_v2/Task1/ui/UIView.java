package lab2_v2.Task1.ui;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lab2_v2.Task1.Observer;
import lab2_v2.Task1.StringsModel;

public class UIView extends VBox implements Observer {

    private Label longestStringLabel = new Label("Longest string will be here");
    private TextField inputStringTextField = new TextField();
    private ListView<String> listView = new ListView<>();
    private Button addButton = new Button("Add");
    private Button rmButton = new Button("Remove");
    private HBox vBox = new HBox(addButton, rmButton);

    public UIView(UIController controller) {
        addButton.setOnAction(e -> controller.addButtonPressed(inputStringTextField.getText()));
        rmButton.setOnAction(e -> controller.rmButtonPressed(listView.getSelectionModel().getSelectedIndex()));
        this.getChildren().addAll(longestStringLabel, inputStringTextField, listView, vBox);
    }

    @Override
    public void update(StringsModel model) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                listView.getItems().setAll(model.getStrings());
                longestStringLabel.setText("Strings changed! New strings array: " + model.longestString());
            }
        });
    }

    public void showErrorMessage(String err) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("An error occured");
        alert.setContentText(err);
        alert.showAndWait();
    }

}
