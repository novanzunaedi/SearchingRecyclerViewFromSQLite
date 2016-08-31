package id.co.warungdeveloper.searchingsqliterecyclerview.mDatabase;

/**
 * Created by CLient-Pc on 30/08/2016.
 */
public class Constants {

    static final String ROW_ID="id";
    static final String NAME ="name";

    static final String DB_NAME="gg_DB";
    static final String TB_NAME="gg_TB";
    static final int DB_VERSION=1;


    static final String CREATE_TB="CREATE TABLE gg_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL);";


    static final String DROP_TB="DROP TABLE IF EXISTS " +TB_NAME;



}



















