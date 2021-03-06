package com.example.clair.welp.Objects;

import android.media.Image;

import com.example.clair.welp.R;

public class Tag {
    public static String[] YearsOfStudy=new String[]{"Secondary 1","Secondary 2","Secondary 3","Secondary 4","JC 1","JC 2","JC 3"};
    //Todo: add img icons to Subjects arr
    public static String[] Subjects=new String[]{"English","Chinese","Math","Geography","History","Physics","Chemistry","Biology","A-Math"};
    public static String[] MaterialTypes =new String[]{"Notes","Practice","Lesson"};

    private Integer[] img=new Integer[]{R.drawable.english,R.drawable.chinese,R.drawable.math,R.drawable.geography,R.drawable.history,R.drawable.physics,R.drawable.chemistry,R.drawable.biology,R.drawable.amath};
    private String YearOfStudy, Subject,Type,Summary;

    public Tag(){}

    public Tag(String yearOfStudy, String subject, String type, String summary) {
        YearOfStudy = yearOfStudy;
        Subject = subject;
        Type = type;
        Summary = summary;
    }

    //region properties
    public String[] getYearsOfStudy() {
        return YearsOfStudy;
    }

    public void setYearsOfStudy(String[] yearsOfStudy) {
        YearsOfStudy = yearsOfStudy;
    }

    public String[] getSubjects() {
        return Subjects;
    }

    public void setSubjects(String[] subjects) {
        Subjects = subjects;
    }

    public String getYearOfStudy() {
        return YearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        YearOfStudy = yearOfStudy;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public Integer[] getImg() {
        return img;
    }

    public void setImg(Integer[] img) {
        this.img = img;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }
    //endregion
}
