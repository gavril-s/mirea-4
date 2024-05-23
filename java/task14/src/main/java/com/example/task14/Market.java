package com.example.Task14;

public class Market {
    private String name;
    private String adress;

    public Market(String name, String adress){
        this.adress = adress;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
