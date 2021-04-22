package com.luis.transformer.constant;

public enum Team {

    D("Decepticons"),
    A("Autobots");
    
    private String description;

    private Team(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
}
