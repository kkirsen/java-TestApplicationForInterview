package com.intellilogics.studentsdb.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.intellilogics.studentsdb.model.Student;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "person.bd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE tbl_student (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, birthday TEXT, gender TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tbl_student");
        onCreate(sqLiteDatabase);
    }

    public long addStudent(Student s) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",s.getName());
        cv.put ("birthday",s.getBirthday());
        cv.put ("gender",s.getGender());


        return db.insert("tbl_student",null,cv);

    }

    public ArrayList<Student> getAllStudents(){

        ArrayList <Student> students = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tbl_student",null);

        if (cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String birthday = cursor.getString(2);
                String gender = cursor.getString(3);

                Student s = new Student(id,name,birthday,gender);
                students.add(s);


            }while (cursor.moveToNext());
        }

        return students;

    }

    public int updateStudent(Student s) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",s.getName());
        cv.put ("birthday",s.getBirthday());
        cv.put ("gender",s.getGender());

        return db.update ("tbl_student",cv, "id=?",new String[]{String.valueOf(s.getId())});


    }

    public int deleteStudent(int id) {
        SQLiteDatabase db = getWritableDatabase();

        return db.delete("tbl_student","id=?", new String[]{String.valueOf(id)});

    }
}
