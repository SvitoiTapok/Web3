package com.example.lab3.util;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Hit implements Serializable {
    private double x;
    private double y;
    private double r;
    private long duration;
    private boolean hit;
    private String date;

    public Hit(double x, double y, double r, long duration, boolean isHit, String date) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.duration = duration;
        this.hit = isHit;
        this.date = date;
    }

    //    public double getX() {
//        return x;
//    }
//
//    public double getY() {
//        return y;
//    }
//
//    public double getR() {
//        return r;
//    }
//
//    public long getDuration() {
//        return duration;
//    }
//
//    public boolean getisHit() {
//        return isHit;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setX(double x) {
//        this.x = x;
//    }
//
//    public void setY(double y) {
//        this.y = y;
//    }
//
//    public void setR(double r) {
//        this.r = r;
//    }
//
//    public void setDuration(long duration) {
//        this.duration = duration;
//    }
//
//    public void setHit(boolean hit) {
//        isHit = hit;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
}
