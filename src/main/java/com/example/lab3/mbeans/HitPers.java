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

import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;


@Named("hitPers")
@ApplicationScoped
@Getter
@Setter
public class HitPers implements Serializable, HitPersMBean {
    @Inject
    private HitCounter hitCounter;
    private double pers;

    @Override
    public double getPers() {
        return pers;
    }
    public double getUpdatePers(){
        if (hitCounter.getGenCounter()!=0){
            pers = Math.ceil((1-1.0*hitCounter.getMissCounter()/hitCounter.getGenCounter())*1000)/1000;
            PrimeFaces.current().executeScript("recolor_rect("+pers+")");
            return pers;
        }
        else{
            pers = 0;
            return pers;
        }
    }
    @Override
    public void setPers(double pers) {
        this.pers = pers;
    }

}
