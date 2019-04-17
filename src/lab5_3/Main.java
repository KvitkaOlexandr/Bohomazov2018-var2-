package lab5_3;


import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        StringDao inputDao = new StringDaoImpl("src/lab5_3/MainCopy.java");
        StringDao outputDao = new StringDaoImpl("src/lab5_3/MainCopyOutput.txt");

        SubstringReplacer substringReplacer = new SubstringReplacer();
        substringReplacer.setStringToReplace(inputDao.getString());
        String result = substringReplacer.replaceWithLongerString("public");
        outputDao.setString(result);
    }
}
