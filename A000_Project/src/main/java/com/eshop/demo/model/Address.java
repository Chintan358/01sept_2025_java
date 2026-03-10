
package com.eshop.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String addressLine;
    private String city;
    private String state;
    private String pincode;
    private String country;

    private boolean isDefault = false;
}
