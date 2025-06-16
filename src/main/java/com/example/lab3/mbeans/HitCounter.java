package com.example.lab3.mbeans;

import com.example.lab3.util.*;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;


@Named("hitCounter")
@SessionScoped
@Getter
@Setter
public class HitCounter implements Serializable, HitCounterMBean {
    private int genCounter = 0;
    private int missCounter = 0;
    private int tempCounter = 0;

    public void addHit(boolean hit){
        genCounter++;
        if(hit){
            tempCounter = 0;
        }else {

            tempCounter++;
            missCounter++;
        }
    }
}
