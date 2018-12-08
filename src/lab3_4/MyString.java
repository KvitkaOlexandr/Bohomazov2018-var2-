package lab3_4;

import java.util.Objects;

public class MyString {
    private String string;

    public MyString(){
        string = "Hello World";
    }

    public MyString(String string){
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return Objects.equals(string, myString.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
