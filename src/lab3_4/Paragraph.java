package lab3_4;

import java.util.Objects;

public class Paragraph {
    private MyString string;

    public Paragraph(){
        string = new MyString();
    }

    public Paragraph(MyString string){
        this.string = string;
    }

    public MyString getString() {
        return string;
    }

    public void setString(MyString string) {
        this.string = string;
    }

    public void add(String string){
        this.string.setString(this.string.getString() + string);
    }

    @Override
    public String toString() {
        return "    " + string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph = (Paragraph) o;
        return Objects.equals(string, paragraph.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
