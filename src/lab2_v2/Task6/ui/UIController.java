package lab2_v2.Task6.ui;
import lab2_v2.Task6.NumbersModel;

public class UIController {

    private UIView view = new UIView(this);
    private NumbersModel model;

    public UIController(NumbersModel model) {
        this.model = model;
        this.model.getPublisher().subscribe(view);
    }

    public void addButtonPressed(int number) {
        model.addNumber(number);
    }

    public void rmButtonPressed(int index) {
        if (index < 0) {
            view.showErrorMessage("Your selection is out of bounds");
        }
        model.deleteNumber(index);
    }

    public UIView getView() {
        return view;
    }
}
