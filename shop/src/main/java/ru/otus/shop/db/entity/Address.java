package ru.otus.shop.db.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@Entity(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Address implements SEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String street1;

    @NotBlank
    private String street2;

    @NotBlank
    private String city;

    private String state;

    @NotBlank
    private String zipcode;

    @NotBlank
    private String country;

}
