package com.d288.Vacation.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "divisions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();


}