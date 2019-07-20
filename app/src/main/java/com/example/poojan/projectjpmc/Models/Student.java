package com.example.poojan.projectjpmc.Models;

public class Student {

    private String name, roll;
    private int age, saving, attendance, total;
    private long mobile;
    private int gr1,gr2,gr3,gr4,gr5;

    public Student(String name, long mobile, String roll, int age, int saving, int attendance, int total, int gr1, int gr2, int gr3, int gr4, int gr5) {
        this.name = name;
        this.roll = roll;
        this.age = age;
        this.saving = saving;
        this.attendance = attendance;
        this.total = total;
        this.mobile = mobile;
        this.gr1 = gr1;
        this.gr2 = gr2;
        this.gr3 = gr3;
        this.gr4 = gr4;
        this.gr5 = gr5;
    }

    public Student() {
    }

    public int getGr1() {
        return gr1;
    }

    public void setGr1(int gr1) {
        this.gr1 = gr1;
    }

    public int getGr2() {
        return gr2;
    }

    public void setGr2(int gr2) {
        this.gr2 = gr2;
    }

    public int getGr3() {
        return gr3;
    }

    public void setGr3(int gr3) {
        this.gr3 = gr3;
    }

    public int getGr4() {
        return gr4;
    }

    public void setGr4(int gr4) {
        this.gr4 = gr4;
    }

    public int getGr5() {
        return gr5;
    }

    public void setGr5(int gr5) {
        this.gr5 = gr5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
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
