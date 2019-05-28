package lab5_3;

import java.io.IOException;

public interface StringDao {
    public String getString() throws IOException;
    public void setString(String string) throws IOException;
}
