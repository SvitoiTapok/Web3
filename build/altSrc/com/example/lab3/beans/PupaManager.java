package com.example.lab3.beans;


//@WebServlet(name = "helloServlet", value = "/hello-servlet")

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


@Named("graphManager")
@SessionScoped
public class PupaManager implements Serializable {
    @Getter
    @Setter
    private List<Hit> hits = new ArrayList<>();

    @Inject
    private SliderBean sliderBean;
    @Inject
    private SpinnerBean spinnerBean;
    @Inject
    private TextBean textBean;

    public PupaManager(){
//        hits.add(new Hit(0,0,2,122, true, "lol"));
//        hits.add(new Hit(0,0,2,123, true, "lol"));
//        hits.add(new Hit(0,0,2,124, true, "lol"));
    }


    public void addData(double x, double y, double r, boolean hit, String date,long duration){
        try  {
            DBConnector.connect();
            DBConnector.statmt.execute("INSERT INTO lab3_results(x, y, r, hit, duration, date) VALUES ('" + x + "', '" + y + "', '" + r + "', '" + hit + "', '" + duration + "', '" + date + "');");
            PrimeFaces.current().executeScript("setMessage('" + "Данные успешно добавлены." + "');");
        } catch (SQLException e) {
            PrimeFaces.current().executeScript("setMessage('" + "Ошибка при добавлении данных в базу данных: " + e.getMessage() + "');");
        }
    }
//public void addData(double x, double y, double r, boolean hit, String date, long duration) {
//    try {
//        NewDBConnector.connect();
//        NewDBConnector.entityManager.getTransaction().begin();
//
//        MyEntity entity = new MyEntity();
//        entity.setX(x);
//        entity.setY(y);
//        entity.setR(r);
//        entity.setHit(hit);
//        entity.setDate(date);
//        entity.setDuration(duration);
//
//        NewDBConnector.entityManager.persist(entity);
//        NewDBConnector.entityManager.getTransaction().commit();
//
//        System.out.println("Данные успешно добавлены в базу данных.");
//    } catch (Exception e) {
//        NewDBConnector.entityManager.getTransaction().rollback();
//        System.out.println("Ошибка при добавлении данных в базу данных: " + e.getMessage());
//    } finally {
//        NewDBConnector.close();
//    }
//}
    public void add(){
        System.out.println("add");
        Instant now = Instant.now();
        System.out.println(spinnerBean.getNumber());
        double x = spinnerBean.getNumber();
        double y = textBean.getInput();
        double r = sliderBean.getNumber();
        boolean hit = RequestParser.hitCheck(x, y, r);
        String currentTime = RequestParser.getCurretnTime();
        long duration = RequestParser.getTime(now);


        hits.add(new Hit(x, y, r, duration, hit, currentTime));
        addData(x, y, r, hit, currentTime, duration);
        PrimeFaces.current().executeScript("drawNewDot("+ x + "," + y + "," + r + ",\"" + hit + "\")");
    }
    public List<Hit> getLastHits(){
        return  hits.subList((hits.size()>5)?hits.size()-5:0, hits.size());
    }



}