package lab5_1;

import java.io.*;
import java.util.ArrayList;

public class NumerFileHandler {

    public ArrayList<Integer> readFromText(String filename) throws IOException {
        var inputFile = new File(filename);
        var bufferedReader = new BufferedReader(new FileReader(inputFile));
        var streamTokenizer = new StreamTokenizer(bufferedReader);

        var resList = new ArrayList<Integer>();
        for (int i = 0; streamTokenizer.nextToken() != StreamTokenizer.TT_EOF; i++) {
            resList.add((int) streamTokenizer.nval);
        }

        bufferedReader.close();
        return resList;
    }

    public ArrayList<Integer> readFromBinary(String filename) throws IOException {
        var endOfFile = false;
        var resList = new ArrayList<Integer>();

        var fileInputStream = new FileInputStream(filename);
        var inputFile = new DataInputStream(fileInputStream);

        while (!endOfFile) {
            try {
                int number = inputFile.readInt();
                resList.add(number);
            } catch (EOFException e) {
                endOfFile = true;
            }
        }

        inputFile.close();
        return resList;
    }

    public void binaryFileToConsole(String filename) throws IOException {
        File inputFile = new File(filename);

        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(inputFile));

        int c;
        while ((c = in.read()) != -1)
            System.out.println(c);
        in.close();
    }

    public void writeToText(String filename, ArrayList<Integer> list) throws IOException {
        var outputFile = new File(filename);
        var printWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

        for (int number :
                list) {
            printWriter.println(number);
        }

        printWriter.close();
    }

    public void writeToBinary(String filename, ArrayList<Integer> list) throws IOException {
        var fileOutputStream = new FileOutputStream(filename);
        var outputFile = new DataOutputStream(fileOutputStream);

        for (int number :
                list) {
            outputFile.writeInt(number);
        }

        outputFile.close();
    }
}
