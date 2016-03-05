package com.andy2016.choreup;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddChore extends AppCompatActivity {


    EditText editTextChoreName;
    Button saveButton;


    private void clearUI()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chore);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d("UI", "fab add chore click");
            }
        });

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM " + ChoreEntry.TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        if(c.moveToFirst())
        {
            do{
                Log.d("db","columnCount: "+ c.getColumnCount()
                                + "\n" + c.getColumnName(1) + ","+  c.getString(c.getColumnIndex(ChoreEntry.COLUMN_NAME_CHORE_NAME))
                );
            }while(c.moveToNext());
        }

        //initalize UI
        editTextChoreName = (EditText)findViewById(R.id.editTextChoreName);

        saveButton = (Button) findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Log.d("UI","chore entry save button clicked");

                        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
                        SQLiteDatabase db = dbHelper.getReadableDatabase();

                        ContentValues values = new ContentValues();
                        values.put(ChoreEntry.COLUMN_NAME_ENTRY_ID, "1");
                        values.put(ChoreEntry.COLUMN_NAME_CHORE_NAME, editTextChoreName.getText().toString());

                        long newRowId;
                        newRowId = db.insert(ChoreEntry.TABLE_NAME, null, values );
                    }
                });

    }



}
