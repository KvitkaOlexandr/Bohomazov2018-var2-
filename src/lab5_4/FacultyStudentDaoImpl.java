package lab5_4;

import java.io.*;
import java.util.Objects;

public class FacultyStudentDaoImpl implements FacultyStudentDao {
    private String studFilename = "src/lab5_4/OSerializedStudent.txt";

    @Override
    public FacultyStudent getStudent() throws IOException, ClassNotFoundException {
        BufferedInputStream bos = new BufferedInputStream(new FileInputStream(studFilename));
        ObjectInputStream oos = new ObjectInputStream(bos);
        FacultyStudent student = (FacultyStudent) oos.readObject();
        oos.close();
        return student;
    }

    @Override
    public void setStudent(FacultyStudent student) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(studFilename));
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(student);
        oos.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyStudentDaoImpl that = (FacultyStudentDaoImpl) o;
        return Objects.equals(studFilename, that.studFilename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studFilename);
    }

    @Override
    public String toString() {
        return "FacultyStudentDaoImpl{" +
                "studFilename='" + studFilename + '\'' +
                '}';
    }
}
