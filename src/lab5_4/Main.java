package lab5_4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FacultyStudentDao studentDao = new FacultyStudentDaoImpl();
        FacultyStudent facultyStudent = new FacultyStudent("Vasya", "World", 1, Faculties.Math);

        studentDao.setStudent(facultyStudent);

        FacultyStudent studentFromFile = studentDao.getStudent();
        if(!studentFromFile.equals(facultyStudent)){
            System.out.println("OBJECTS ARE NOT EQUAL");
        }
    }
}
