package lab4_1;

import java.util.Objects;

public class FacultyStudent extends Student {

    private Faculties faculty;
    @Override
    public String getName() {
        return name;

    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }


    @Override
    public int getNumCourses() {
        return 0;
    }

    @Override
    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    @Override
    public int getEntryMark() {
        return 0;
    }

    @Override
    public String toString() {
        return "FacultyStudent{" +
                "faculty='" + faculty + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numCourses=" + numCourses +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FacultyStudent that = (FacultyStudent) o;
        return Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty);
    }

    public FacultyStudent(String name, String address, int numCourses, Faculties faculty){
        super(name, address, numCourses);
        this.faculty = faculty;
    }
}
