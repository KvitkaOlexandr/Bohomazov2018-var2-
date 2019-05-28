package lab5_2;

import java.io.*;

public class ClassTextOperator {
    public String ReplacePublicWithPrivate(String classText){
        return classText.replaceAll("public", "private");
    }
    public void ReplacePublicWithPrivate(String inputFilename, String outputFilename) throws IOException {
        File inputFile = new File(inputFilename);
        File outputFile = new File(outputFilename);

        BufferedReader in = new BufferedReader(new FileReader(inputFile) );
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while ( (s = in.readLine()) != null ) {
            stringBuilder.append(s);
            stringBuilder.append("\r\n");
        }

        var output = ReplacePublicWithPrivate(stringBuilder.toString());
        out.print(output);

        in.close();
        out.close();
    }
}
