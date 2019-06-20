package com.njupt.mybatisintercept.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private Integer studentId;
    private String studentName;
    private Integer studentClassid;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentClassid() {
        return studentClassid;
    }

    public void setStudentClassid(Integer studentClassid) {
        this.studentClassid = studentClassid;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClassid=" + studentClassid +
                '}';
    }
}
