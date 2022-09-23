package weshare.persistence.collectionbased;

import net.lemnik.eodsql.QueryTool;
import weshare.persistence.DataRemoverDAO;
import weshare.persistence.LibraryDataRemover_interface;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataRemoverImpl implements DataRemoverDAO {
    public DataRemoverImpl() {
        new DbConnection();
    }

    @Override
    public void returnBorrowedBooks(int id) {
        Connection connection = DbConnection.getConnection();
        LibraryDataRemover_interface dataRemover_interface =
                QueryTool.getQuery(connection,
                LibraryDataRemover_interface.class);
        dataRemover_interface.delete(id);
    }
}
