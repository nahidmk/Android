package com.example.login_application.Module;

public class info {

    private String Name;
    private int deposite;

    public info(String name, int deposite) {
        this.Name = name;
        this.deposite = deposite;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getDeposite() {
        return deposite;
    }

    public void setDeposite(int deposite) {
        this.deposite = deposite;
    }
}
