package lab2_v2.Task6.ui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lab2_v2.Task1.StringsModel;
import lab2_v2.Task6.NumbersModel;

import java.util.concurrent.Flow;

public class UIView extends VBox implements Flow.Subscriber<NumbersModel> {

    private Label sumLabel = new Label("Even sum will be here");
    private TextField inputStringTextField = new TextField();
    private ListView<Integer> listView = new ListView<>();
    private Button addButton = new Button("Add");
    private Button rmButton = new Button("Remove");
    private HBox vBox = new HBox(addButton, rmButton);

    private Flow.Subscription subscription;

    public UIView(UIController controller) {
        addButton.setOnAction(e -> controller.addButtonPressed(Integer.parseInt(inputStringTextField.getText())));
        rmButton.setOnAction(e -> controller.rmButtonPressed(listView.getSelectionModel().getSelectedIndex()));
        this.getChildren().addAll(sumLabel, inputStringTextField, listView, vBox);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(NumbersModel item) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                listView.setItems(FXCollections.observableArrayList(item.getBoxedArray()));
                sumLabel.setText(String.valueOf(item.evenSum()));
            }
        });
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Finished reading events");
    }

    public void showErrorMessage(String err) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("An error occured");
        alert.setContentText(err);
        alert.showAndWait();
    }

}
