package com.example.demo.entity;


import lombok.*;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
