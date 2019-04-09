package lab5_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        var main = new Main();
        main.textInTextOut("src/lab5_1/in.txt", "src/lab5_1/out.txt");
        main.textInBinaryOut("src/lab5_1/in.txt", "src/lab5_1/out.dat");
        main.binaryInBinaryOut("src/lab5_1/out.dat", "src/lab5_1/newOut.dat");
        main.binaryInTextOut("src/lab5_1/out.dat", "src/lab5_1/newOut.txt");
        main.oneBinaryFile("src/lab5_1/oneBinary.dat");
    }

    void textInTextOut(String inputFilename, String outputFilename) throws IOException {
        var fileHandler = new NumerFileHandler();
        var fileOperator = new NumberListOperator();

        var list = fileHandler.readFromText(inputFilename);
        list = fileOperator.AddFirstOddNumber(list);
        fileHandler.writeToText(outputFilename, list);
    }

    void binaryInBinaryOut(String inputFilename, String outputFilename) throws IOException {
        var fileHandler = new NumerFileHandler();
        var fileOperator = new NumberListOperator();

        var list = fileHandler.readFromBinary(inputFilename);
        list = fileOperator.AddFirstOddNumber(list);
        fileHandler.writeToBinary(outputFilename, list);

        fileHandler.binaryFileToConsole(inputFilename);
    }

    void oneBinaryFile(String filename) throws IOException {
        var fileHandler = new NumerFileHandler();
        var fileOperator = new NumberListOperator();

        var list = fileHandler.readFromBinary(filename);
        list = fileOperator.AddFirstOddNumber(list);
        fileHandler.writeToBinary(filename, list);
    }

    void textInBinaryOut(String inputFilename, String outputFilename) throws IOException {
        var fileHandler = new NumerFileHandler();
        var fileOperator = new NumberListOperator();

        var list = fileHandler.readFromText(inputFilename);
        list = fileOperator.AddFirstOddNumber(list);
        fileHandler.writeToBinary(outputFilename, list);
    }

    void binaryInTextOut(String inputFilename, String outputFilename) throws IOException {
        var fileHandler = new NumerFileHandler();
        var fileOperator = new NumberListOperator();

        var list = fileHandler.readFromText(inputFilename);
        list = fileOperator.AddFirstOddNumber(list);
        fileHandler.writeToBinary(outputFilename, list);
    }

}
