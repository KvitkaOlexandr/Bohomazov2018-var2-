package lab5_3;

import java.io.*;
import java.util.Objects;

public class SubstringReplacer {

    private String stringToReplace;

    public String getStringToReplace() {
        return stringToReplace;
    }

    public void setStringToReplace(String stringToReplace) {
        this.stringToReplace = stringToReplace;
    }

    public String replaceWithLongerString(String substringToReplace){
        return stringToReplace.replace( substringToReplace, substringToReplace + "LONGER");
    }

    @Override
    public String toString() {
        return "SubstringReplacer{" +
                "stringToReplace='" + stringToReplace + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubstringReplacer that = (SubstringReplacer) o;
        return Objects.equals(stringToReplace, that.stringToReplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringToReplace);
    }
}
