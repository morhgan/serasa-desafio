package com.br.serasa.sellers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "seller")
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "age")
    private Long age;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @OneToOne
    @JoinColumn(name = "id")
    private Operation operation;
    @Column(name = "inclusionDate")
    private LocalDate inclusionDate;
}
