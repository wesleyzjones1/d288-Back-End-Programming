package com.d288.Vacation.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "excursions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "excursion_title")
    private String excursion_title;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "image_url")
    private String image_URL;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;
}