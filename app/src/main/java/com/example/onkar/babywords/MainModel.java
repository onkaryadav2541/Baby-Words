package com.example.onkar.babywords;

public class MainModel {
    Integer langLogo;
    String langName;
    String langDetail;

    public MainModel(Integer langLogo,String langName,String langDetail) {
        this.langLogo = langLogo;
        this.langName = langName;
        this.langDetail = langDetail;
    }

    public Integer getLangLogo() {
        return langLogo;
    }

    public String getLangName() {
        return langName;
    }

    public String getLangDetail() {
        return langDetail;
    }


}
