package id.co.warungdeveloper.searchingsqliterecyclerview.mDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CLient-Pc on 30/08/2016.
 */
public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c){
        this.c = c;
        helper= new DBHelper(c);
    }

    public void OpenDB(){
        try{
            db = helper.getWritableDatabase();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeDB(){
        try{
            helper.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean add(String name){
        try{
            ContentValues cv=new ContentValues();
            cv.put(Constants.NAME, name);
            System.out.println("NAME " + name);
            db.insert(Constants.TB_NAME, Constants.ROW_ID, cv);

            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public Cursor retrieve(String searchTerm){
        String[] columns = {Constants.ROW_ID, Constants.NAME};
        Cursor c = null;
        if(searchTerm != null && searchTerm.length()>0){
            String sql= "SELECT * FROM "+Constants.TB_NAME+" WHERE "+Constants.NAME+" LIKE '%"+searchTerm+"%'";

            System.out.println("STRING SQL " + sql.toString());

            c=db.rawQuery(sql,null);
            return c;
        }

        c=db.query(Constants.TB_NAME, columns, null, null, null, null, null);

        System.out.println("CQuery " + c);
        return c;
    }


    public Cursor getGroupData2() {
        String[] columns = {Constants.ROW_ID, Constants.NAME};
        Cursor c = null;
        c = db.query(Constants.TB_NAME, columns, null, null, null, null,null);
        return c;
    }

}


















