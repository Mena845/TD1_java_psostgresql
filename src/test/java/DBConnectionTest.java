import Class.DBConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DBConnectionTest {

    @Test
    public void testConnectionNotNull() {
        DBConnection db = new DBConnection();
        Connection conn = db.getDBConnection();
        assertNotNull(conn, "La connexion ne devrait pas être nulle");
    }
}
