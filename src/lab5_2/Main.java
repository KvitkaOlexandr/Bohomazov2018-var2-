package lab5_2;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var classTextOperator = new ClassTextOperator();
        classTextOperator.ReplacePublicWithPrivate("src/lab5_2/MainCopy.java",
                "src/lab5_2/MainCopyOutput.txt");

    }


}
