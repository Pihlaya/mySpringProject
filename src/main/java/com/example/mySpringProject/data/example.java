package com.example.mySpringProject.data;

public class example {

      private String student;
    private String gender;
    private int grade;

    private static int count = 0;

    public example( String student, String gender ){
        this.student = student;
        this.gender = gender;
        this.grade = count++;
    }

    public example(){
        this("","");
    }

    public String getstudent(){
        return this.student;
    }

    public void setstudent(String student){
        this.student = student;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public int getgrade() {
        return grade;
    }
}

