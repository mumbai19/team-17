package com.example.poojan.projectjpmc;

public class Student {

    private String name, mobile;
    private int roll, age, saving, attendance, total;

    public Student() {
    }

    public Student(String name, String mobile, int roll, int age, int saving, int attendance, int total) {
        this.name = name;
        this.mobile = mobile;
        this.roll = roll;
        this.age = age;
        this.saving = saving;
        this.attendance = attendance;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
