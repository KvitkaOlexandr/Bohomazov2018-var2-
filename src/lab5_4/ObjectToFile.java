package lab5_4;

import java.io.*;

public class ObjectToFile {
    public void SerializeObject(Object object, String filename) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename));
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(object);
        oos.close();
    }
}

