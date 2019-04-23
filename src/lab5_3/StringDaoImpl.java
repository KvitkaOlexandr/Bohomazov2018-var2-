package lab5_3;

import java.io.*;
import java.util.Objects;

public class StringDaoImpl implements StringDao {
    private String storageFilename;

    public StringDaoImpl(String storageFilename){
        this.storageFilename = storageFilename;
    }

    @Override
    public String getString() throws IOException {
        File inputFile = new File(storageFilename);

        BufferedReader in = new BufferedReader(new FileReader(inputFile) );

        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while ( (s = in.readLine()) != null ) {
            stringBuilder.append(s);
            stringBuilder.append("\r\n");
        }

        in.close();

        return stringBuilder.toString();
    }

    @Override
    public void setString(String string) throws IOException {
        File outputFile = new File(storageFilename);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

        out.print(string);

        out.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringDaoImpl stringDao = (StringDaoImpl) o;
        return Objects.equals(storageFilename, stringDao.storageFilename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageFilename);
    }

    @Override
    public String toString() {
        return "StringDaoImpl{" +
                "storageFilename='" + storageFilename + '\'' +
                '}';
    }
}
