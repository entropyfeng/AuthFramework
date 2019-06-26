package com.github.entropyfeng.rubbishauth.domain.po;

public class Student {
    protected String studentId;

    protected String studentName;

    protected String studentClassName;

    public Student(String studentId, String studentName, String studentClassName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClassName = studentClassName;
    }

    public Student() {
        super();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName == null ? null : studentClassName.trim();
    }
}