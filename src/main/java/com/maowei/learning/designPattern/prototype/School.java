package com.maowei.learning.designPattern.prototype;

import java.io.Serializable;

public class School implements Serializable{
    private String name;
    private String type;

    public School(String name, String type){
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("name:");
        sb.append(this.name);
        sb.append(" type:");
        sb.append(this.type);
        return  sb.toString();
    }
}
