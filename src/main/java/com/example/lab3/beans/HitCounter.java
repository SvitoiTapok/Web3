package com.example.lab3.beans;

import com.example.lab3.util.*;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Named("hitCounter")
@SessionScoped
@Getter
@Setter
public class HitCounter implements Serializable {
    private int gen_counter = 0;
    private int miss_counter = 0;
    private int temp_counter = 0;

    public void add_hit(Hit hit){
        System.out.println("gen_c "+temp_counter);
        gen_counter++;
        if(hit.isHit()){
            temp_counter = 0;
        }else {

            temp_counter++;
            miss_counter++;
        }
    }
}
