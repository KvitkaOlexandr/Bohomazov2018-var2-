package lab5_4;

import java.io.IOException;

public interface FacultyStudentDao {
    public FacultyStudent getStudent() throws IOException, ClassNotFoundException;
    public void setStudent(FacultyStudent student) throws IOException;
}
