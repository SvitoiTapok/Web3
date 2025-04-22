package com.example.lab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import jakarta.faces.context.FacesContext;
import jakarta.faces.component.UIComponent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.application.FacesMessage;
//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;


@Getter
@Setter
@Named("textBean")
@SessionScoped
public class TextBean implements Serializable{
    private Double input=0.0;

    public void setInput(Double input) {
        System.out.println("text:" + input);
        this.input = input;
    }
}