package com.intellilogics.studentsdb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.intellilogics.studentsdb.R;
import com.intellilogics.studentsdb.adapter.StudentAdapter;
import com.intellilogics.studentsdb.db.DBHelper;
import com.intellilogics.studentsdb.model.Student;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {

    TextView tvTotal;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    ArrayList<Student> students;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        tvTotal=findViewById(R.id.tvTotal);

        dbHelper = new DBHelper(this);

    }

    @Override
    protected void onStart(){
        super.onStart();
        students = dbHelper.getAllStudents();
        recyclerView = findViewById(R.id.recyclerView);
        tvTotal.setText("Total Students: " + students.size() );

        studentAdapter = new StudentAdapter(students,this);
        recyclerView.setAdapter(studentAdapter);

        LinearLayoutManager l1m = new LinearLayoutManager(this);
        l1m.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(l1m);
    }
}