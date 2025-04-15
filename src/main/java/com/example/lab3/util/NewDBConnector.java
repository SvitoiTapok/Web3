package com.example.lab3.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewDBConnector {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory entityManagerFactory;
    public static EntityManager entityManager;

    public static void connect() {
        try {
            // Создание EntityManagerFactory
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            entityManager = entityManagerFactory.createEntityManager();
            System.out.println("Успешное подключение к базе данных через JPA и Hibernate!");
        } catch (Exception e) {
            System.out.println("Ошибка подключения через JPA и Hibernate: " + e.getMessage());
        }
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}