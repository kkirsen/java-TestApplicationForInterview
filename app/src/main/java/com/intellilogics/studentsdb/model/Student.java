package com.intellilogics.studentsdb.model;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name;
    String birthday;
    String gender;


    public Student(int id, String name, String birthday, String gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Student(String name, String birthday, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() { return gender; }
    public void setGender(String gender) {
        this.gender = gender;
    }


}
