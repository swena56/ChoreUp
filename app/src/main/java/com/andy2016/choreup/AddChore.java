package com.andy2016.choreup;

import android.content.ContentValues;
import android.content.Intent;
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
import android.widget.Toast;

public class AddChore extends AppCompatActivity {


    EditText editTextChoreName;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chore);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initalize UI
        editTextChoreName = (EditText)findViewById(R.id.editTextChoreName);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d("UI", "fab add chore click");
                Log.d("UI","chore entry save button clicked");

                DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                ContentValues values = new ContentValues();
                //values.put(ChoreEntry.COLUMN_NAME_ENTRY_ID, "1");
                values.put(ChoreEntry.COLUMN_NAME_CHORE_NAME, editTextChoreName.getText().toString());

                //TODO check if data is valid

                long newRowId;
                newRowId = db.insert(ChoreEntry.TABLE_NAME, null, values );
                db.close();


                Toast.makeText(getApplicationContext(),"Saved "+values.toString(),Toast.LENGTH_LONG).show();

                //go back to MainActivity
                Intent intent = new Intent(AddChore.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
