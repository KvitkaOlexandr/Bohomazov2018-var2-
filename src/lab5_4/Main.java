package lab5_4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var objectToFile = new ObjectToFile();
        FacultyStudent facultyStudent = new FacultyStudent("Vasya", "World", 1, Faculties.Math);

        objectToFile.SerializeObject(facultyStudent, "src/lab5_4/OSerializedStudent.txt");
    }


}
