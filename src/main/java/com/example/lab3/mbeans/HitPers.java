package com.example.lab3.mbeans;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;


@Named("hitPers")
@ApplicationScoped
public class HitPers implements Serializable, HitPersMBean {
    @Inject
    private HitCounter hitCounter;
    private double pers;

    @Override
    public double getPers() {
        System.out.println(pers);
        if (hitCounter.getGenCounter()!=0){
            pers = Math.ceil((1-1.0*hitCounter.getMissCounter()/hitCounter.getGenCounter())*1000)/1000;
            PrimeFaces.current().executeScript("recolor_rect("+pers+")");
            return pers;
        }
        else
            return 0;
    }
    @Override
    public void setPers(double pers) {
        this.pers = pers;
    }

}
