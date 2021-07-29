package com.intellilogics.studentsdb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.intellilogics.studentsdb.R;
import com.intellilogics.studentsdb.db.DBHelper;
import com.intellilogics.studentsdb.model.Student;

public class UpdateActivity extends AppCompatActivity {
    EditText edName, edBirthday, edGender;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        Student s = (Student) getIntent().getExtras().getSerializable("STUDENT");
        id = s.getId();
        edName=findViewById(R.id.edName);
        edBirthday=findViewById(R.id.edBirthday);
        edGender=findViewById(R.id.edGender);


        edName.setText(s.getName());
        edBirthday.setText((s.getBirthday()));
        edGender.setText((s.getGender()));

    }

    public void update(View view) {
        String name = edName.getText().toString().trim();
        String birthday = edBirthday.getText().toString().trim();
        String gender = edGender.getText().toString().trim();


        Student s = new Student(id, name, birthday, gender);
        DBHelper dbHelper = new DBHelper(this);

        int result = dbHelper.updateStudent(s);

        if (result>0)
        {
            Toast.makeText(this,"Updated! " + result,Toast.LENGTH_SHORT).show();
            finish();
        }
        else
        {
            Toast.makeText(this, "Failed " + result, Toast.LENGTH_SHORT).show();
        }


    }
}