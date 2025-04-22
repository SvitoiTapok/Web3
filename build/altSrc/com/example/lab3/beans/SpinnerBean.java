package com.example.lab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;

@Getter
@Setter
@Named("spinnerBean")
@SessionScoped
public class SpinnerBean implements Serializable{
    private Double number=0.0;
}