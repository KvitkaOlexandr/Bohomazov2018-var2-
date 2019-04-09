package lab5_3;

import java.io.*;

public class SubstringReplacer {
    public String ReplaceWithLongerString(String line, String substringToReplace){
        return line.replace( substringToReplace, substringToReplace + "LONGER");
    }

    public void ReplaceWithLongerString(String inputFilename, String outputFilename, String substringToReplace)
            throws IOException {
        File inputFile = new File(inputFilename);
        File outputFile = new File(outputFilename);

        BufferedReader in = new BufferedReader(new FileReader(inputFile) );
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while ( (s = in.readLine()) != null ) {
            stringBuilder.append(ReplaceWithLongerString(s, substringToReplace));
            stringBuilder.append("\r\n");
        }

        out.print(stringBuilder.toString());

        in.close();
        out.close();
    }
}
