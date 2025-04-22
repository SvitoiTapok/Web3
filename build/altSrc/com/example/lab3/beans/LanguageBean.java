package com.example.lab3.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.Locale;

@Named("languageBean")
@ApplicationScoped
public class LanguageBean {
    private Locale hehehe = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getCurrentLocale() {
        return hehehe;
    }

    public void setEnglishLocale() {
        hehehe = Locale.ENGLISH;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(hehehe);
    }

    public void setRussianLocale() {
        hehehe = new Locale("ru", "RU");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(hehehe);
    }
    public void changeLanguage() {
        if(hehehe.equals(Locale.ENGLISH)) {
            setRussianLocale();
        }
        else{
            setEnglishLocale();
        }
    }
}

