package com.example.lab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Named("timer")
@SessionScoped
@Getter
@Setter
public class Timer implements Serializable{
    private String currentTime;

    public Timer() {
        updateTime();
    }

    public void updateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        currentTime = formattedDateTime;  // просто возвращаем текущее время в миллисекундах
    }

}
