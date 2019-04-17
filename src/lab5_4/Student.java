package lab5_4;

import java.io.Serializable;
import java.util.Objects;

public abstract class Student implements Abiturient, Serializable {
    protected String name;
    protected String address;
    protected int numCourses;
    public abstract String getName();
    public abstract String getAddress();
    public abstract void setAddress(String address);
    public abstract int getNumCourses();
    public abstract void setNumCourses(int numCourses);

    public Student(String name, String address, int numCourses){
        this.name = name;
        this.address = address;
        this.numCourses = numCourses;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numCourses == student.numCourses &&
                Objects.equals(name, student.name) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, numCourses);
    }
}
