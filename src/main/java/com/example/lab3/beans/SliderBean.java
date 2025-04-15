package com.example.lab3.beans;


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SlideEndEvent;
//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;

@Getter
@Setter
@Named("sliderBean")
@SessionScoped
public class SliderBean implements Serializable{
    public SliderBean() {
        System.out.println("nice");
    }
    private Double number = 2.0;

    public void setNumber(Double number) {
        System.out.println("setNumber: " + number);
        this.number = number;
    }
    public Double getNumber() {
        System.out.println("getNumber: " + number);
        return number;
    }

    public void OK(SlideEndEvent event) {
        System.out.println("dfgfgdfg");
        setNumber(event.getValue());
    }
}
