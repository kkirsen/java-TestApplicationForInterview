package com.intellilogics.studentsdb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.intellilogics.studentsdb.R;
import com.intellilogics.studentsdb.db.DBHelper;
import com.intellilogics.studentsdb.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Locale;

public class AddStudentActivity extends AppCompatActivity {

    EditText edName, edBirthday, edGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        edName = findViewById(R.id.edName);
        edBirthday = findViewById(R.id.edBirthday);
        edGender = findViewById(R.id.edGender);
    }

    public void showAll(View view) {
        startActivity(new Intent(AddStudentActivity.this, StudentListActivity.class));
    }

    public void save(View view) {
        String name = edName.getText().toString().trim();
        String birthday = edBirthday.getText().toString().trim();
        String gender = edGender.getText().toString().trim();

        DBHelper dbHelper = new DBHelper(AddStudentActivity.this);

        Student s = new Student(name, birthday, gender);


        long result = dbHelper.addStudent(s);
        if (result > 0) {
            Toast.makeText(this, "Saved " + result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed " + result, Toast.LENGTH_SHORT).show();
        }
    }


    public void upload(View view) {

    }
}
