package weshare.persistence.collectionbased;


import net.lemnik.eodsql.QueryTool;
import weshare.persistence.CreateTables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String connectionUrl = "jdbc:sqlite:library.sqlite";
//    private static String dbUrl = null;
    public DbConnection(){
//        this.dbUrl = dbUrl;
    }
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
//            System.out.println("db connected");
            createTables(conn);
            return conn;
        } catch (SQLException e) {
            System.err.println( e.getMessage());
        }
        return null;
    }

    private static void createTables(Connection connection)
    throws SQLException
    {
        final CreateTables createTables = QueryTool.getQuery(
                connection,
                CreateTables.class);
        createTables.createPersonTable();
        createTables.createGenreTable();
        createTables.createBookTable();
        createTables.createAuthorsTable();
        createTables.createBookAuthorTable();
        createTables.createBorrowedBooksTable();
    }
}