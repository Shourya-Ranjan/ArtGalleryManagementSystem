package util;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBConnectionTest {

    @BeforeEach
    void setUp() {
        DBConnection.getConnection();
    }


    @Test
    void testGetConnection() {
        // Test if the getConnection method returns a non-null connection
        Connection connection = DBConnection.getConnection();
        assertNotNull(connection);

        // Test if the getConnection method returns the same connection instance on subsequent calls
        Connection secondConnection = DBConnection.getConnection();
        assertEquals(connection, secondConnection);
    }
}
