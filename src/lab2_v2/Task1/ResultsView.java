package lab2_v2.Task1;

public class ResultsView {
    public void printStrings(StringsModel model) {
        System.out.println("Strings list: ");
        for (String s : model.getStrings()) {
            System.out.println(s);
        }
    }

    public void printLongestString(String s) {
        System.out.println("Longest string: ");
        System.out.println(s);
    }

}
