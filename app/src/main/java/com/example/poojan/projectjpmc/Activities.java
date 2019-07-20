package com.example.poojan.projectjpmc;

public class Activities {

    private String acttheme, actname, actdes;

    public Activities() {
    }

    public Activities(String acttheme, String actname, String actdes) {
        this.acttheme = acttheme;
        this.actname = actname;
        this.actdes = actdes;
    }

    public String getActtheme() {
        return acttheme;
    }

    public void setActtheme(String acttheme) {
        this.acttheme = acttheme;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public String getActdes() {
        return actdes;
    }

    public void setActdes(String actdes) {
        this.actdes = actdes;
    }
}
