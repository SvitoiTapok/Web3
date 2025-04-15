package com.example.lab3.util;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "lab3")
public class MyEntity {
    private double x;
    private double y;
    private double r;
    private boolean hit;
    private long duration;
    private String date;
    @Id
    private Long id;
}
