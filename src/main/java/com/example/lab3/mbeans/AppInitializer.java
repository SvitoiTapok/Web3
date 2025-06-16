package com.example.lab3.mbeans;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

@WebListener
public class AppInitializer implements ServletContextListener {
    @Inject
    private HitCounterMBean hitCounter; // Ваш MBean-класс
    @Inject
    private HitPersMBean hitPersantage;
    MBeanServer mBeanServer;

    private ObjectName hitCounterName = new ObjectName("com.example.lab3.mbeans:type=HitCounter");
    private ObjectName hitPersantageName = new ObjectName("com.example.lab3.mbeans:type=HitPers");

    public AppInitializer() throws MalformedObjectNameException {
        System.out.println("app initialized");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("=== INIT STARTED ===");
        try {
            mBeanServer = ManagementFactory.getPlatformMBeanServer();
            System.out.println("Available MBean domains: " + Arrays.toString(mBeanServer.getDomains()));
            // Проверяем, не зарегистрирован ли уже MBean
            if (!mBeanServer.isRegistered(hitCounterName)) {
                mBeanServer.registerMBean(hitCounter, hitCounterName);
            }
            if (!mBeanServer.isRegistered(hitPersantageName)) {
                mBeanServer.registerMBean(hitPersantage, hitPersantageName);
            }
            System.out.println("MBean registered: " + hitPersantageName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register MBean", e);
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            mBeanServer.unregisterMBean(hitCounterName);
            mBeanServer.unregisterMBean(hitCounterName);
        } catch (InstanceNotFoundException e) {
            throw new RuntimeException(e);
        }catch (MBeanRegistrationException e) {
            throw new RuntimeException(e);
        }
    }
}
