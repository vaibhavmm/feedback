package com.vaibhav.feedback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Column(name = "timestamp",nullable = false,updatable = false)
    private Date timestamp;
}
