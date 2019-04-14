package lab2_v2.Task1;

public class Main {

    public static void main(String[] args) {
        StringsModel model = new StringsModel(new String[] {"123", "abc", "a", "b", "ab"});

        ResultsView view = new ResultsView();
        Controller ctl = new Controller(model);

        view.printStrings(model);
        view.printLongestString(ctl.longestString());

    }

}
