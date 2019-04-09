package lab5_3;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var classTextOperator = new SubstringReplacer();
        classTextOperator.ReplaceWithLongerString("src/lab5_3/MainCopy.java",
                "src/lab5_3/MainCopyOutput.txt", "public");

    }


}
