package weshare.persistence;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Update;

public interface LibraryDataRemover_interface extends BaseQuery {
    @Update("DELETE FROM borrowed_books " +
            "WHERE id = ?{1}")
    void delete(int id);
}
