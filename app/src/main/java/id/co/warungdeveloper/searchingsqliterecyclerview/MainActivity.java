package id.co.warungdeveloper.searchingsqliterecyclerview;

import android.app.Dialog;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import id.co.warungdeveloper.searchingsqliterecyclerview.mDataObject.Planet;
import id.co.warungdeveloper.searchingsqliterecyclerview.mDatabase.DBAdapter;
import id.co.warungdeveloper.searchingsqliterecyclerview.mRecyler.MyAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    SearchView sv;
    EditText etName;
    Button bSave, bRetrieveBtn;
    ArrayList<Planet> planets= new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        sv= (SearchView) findViewById(R.id.sv);
        adapter=new MyAdapter(this, planets);

        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                displayDialog();
            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                getPlanets(query);
                return false;
            }
        });
    }

    private void displayDialog(){
        Dialog d = new Dialog(MainActivity.this);
        d.setTitle("SQLite Database");
        d.setContentView(R.layout.dialog_layout);

        etName = (EditText) d.findViewById(R.id.etName);
        bSave = (Button) d.findViewById(R.id.bSave);
        bRetrieveBtn = (Button) d.findViewById(R.id.bRetrive);

        bSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                save(etName.getText().toString().trim());
            }
        });

        bRetrieveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getPlanets(null);
            }
        });

        d.show();
    }

    private void save(String name){
        DBAdapter db = new DBAdapter(this);
        db.OpenDB();
//        db.add(name);
        System.out.println("NAME AWAL " + name);
        if(db.add(name)){
            etName.setText("");
        }
        else{
            Toast.makeText(MainActivity.this, "Unable to save!!", Toast.LENGTH_SHORT).show();
        }
        db.closeDB();
        getPlanets(null);
    }


    private void getPlanets(String searchTerm){
        planets.clear();

        DBAdapter db = new DBAdapter(this);
        db.OpenDB();
        Planet p = null;
        Cursor c = db.retrieve(searchTerm);

        while(c.moveToNext()){
            int id= c.getInt(0);
            String name = c.getString(1);

            p=new Planet();
            p.setId(id);
            p.setName(name);

            System.out.println("P " + p.toString());
            planets.add(p);
        }
        db.closeDB();
        rv.setAdapter(adapter);
    }
}






















