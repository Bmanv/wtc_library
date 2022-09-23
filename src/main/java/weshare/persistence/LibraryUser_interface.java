package weshare.persistence;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import weshare.persistence.wtc_library_db.PersonDO;

import java.util.List;

public interface LibraryUser_interface extends BaseQuery {
    //display list of users
    @Select("SELECT * FROM library_users")
    List<PersonDO> getUsers();

    //save the user
    @Update("INSERT INTO library_users " +
            "(firstname, lastname, email," +
            " password)" +
            " VALUES(?{1},?{2},?{3},?{4})")
    void savePerson(String firstname, String lastname,
                    String email, String password);
}
