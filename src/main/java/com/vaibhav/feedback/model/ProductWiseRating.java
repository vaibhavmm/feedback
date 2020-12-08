package com.vaibhav.feedback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_wise_rating")
public class ProductWiseRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "item_id")
    private long itemId;
    @Column(name="user_id")
    private long userId;
    @Column(name = "rating")
    private int rating;
    @Column(name = "timestamp",nullable = false,updatable = false)
    private Date timestamp;

    public ProductWiseRating(long itemId, long userid, int rating) throws ParseException {
        this.itemId = itemId;
        this.userId = userid;
        this.rating = rating;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2007");
        long time = date.getTime();
        this.timestamp = new Timestamp(time);
    }
}
