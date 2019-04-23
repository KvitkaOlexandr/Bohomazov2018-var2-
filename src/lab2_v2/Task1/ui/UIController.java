package lab2_v2.Task1.ui;
import lab2_v2.Task1.StringsModel;

public class UIController {

    private UIView view = new UIView(this);
    private StringsModel model;

    public UIController(StringsModel model) {
        this.model = model;
        this.model.addObserver(view);
    }

    public void addButtonPressed(String str) {
        if (str.length() == 0) {
            view.showErrorMessage("String cannot be empty");
        }
        model.addString(str);
    }

    public void rmButtonPressed(int index) {
        if (index == -1) {
            view.showErrorMessage("Your selection is out of bounds");
        }
        model.deleteString(index);
    }

    public UIView getView() {
        return view;
    }
}
