package com.example.lab3.mbeans;

import com.example.lab3.util.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.SessionScoped;

import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;


@Named("hitCounter")
@ApplicationScoped
@Getter
@Setter
public class HitCounter extends NotificationBroadcasterSupport implements Serializable, HitCounterMBean {
    private int genCounter = 0;
    private int missCounter = 0;
    private int tempCounter = 0;
    private long sequenceNumber = 1;

    public void addHit(boolean hit){
        genCounter++;
        if(hit){
            tempCounter = 0;
        }else {
            if(tempCounter>=4){
                String msg = String.format("Вы не попали уже %d раз", this.tempCounter);
                Notification notif = new Notification("com.example.lab3.hit4miss", "HIT_COUNTER", sequenceNumber++,
                        System.currentTimeMillis(),
                        msg);
                sendNotification(notif);
            }
            tempCounter++;
            missCounter++;
        }
    }
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] notifTypes = new String[] { "com.example.lab3.hit4miss" };
        String name = Notification.class.getName();
        String description = "Notification when a 4 point in row are out of the displayed area.";
        MBeanNotificationInfo info = new MBeanNotificationInfo(notifTypes, name, description);
        return new MBeanNotificationInfo[] { info };
    }
}
