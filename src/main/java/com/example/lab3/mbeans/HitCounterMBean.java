package com.example.lab3.mbeans;

import com.example.lab3.util.Hit;

public interface HitCounterMBean {
    int getGenCounter();
    void setGenCounter(int genCounter);
    int getMissCounter();
    void setMissCounter(int missCounter);
    int getTempCounter();
    void setTempCounter(int tempCounter);
    void addHit(boolean hit);

}
