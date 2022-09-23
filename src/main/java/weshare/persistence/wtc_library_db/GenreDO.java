package weshare.persistence.wtc_library_db;

import net.lemnik.eodsql.ResultColumn;

public class GenreDO {
    private String code, description;

    public String getCode() {
        return code;
    }

    @ResultColumn(value = "code")
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    @ResultColumn(value = "description")
    public void setDescription(String description) {
        this.description = description;
    }
}
