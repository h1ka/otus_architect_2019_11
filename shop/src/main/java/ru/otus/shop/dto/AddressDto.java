package ru.otus.shop.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("Адрес")
public class AddressDto implements SDto {
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
