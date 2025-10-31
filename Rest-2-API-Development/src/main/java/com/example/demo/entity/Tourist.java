package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="REST_TOURIST")
public class Tourist implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer tid;
    
    @Column(length = 20)
    @NonNull 
    private String name;
    
    @Column(length = 20)
    @NonNull
    private String city;
    
    @Column(length = 20)
    @NonNull
    private String packageType;
    
    @NonNull
    private Double budget;
}
