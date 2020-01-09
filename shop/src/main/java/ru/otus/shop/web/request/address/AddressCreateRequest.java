package ru.otus.shop.web.request.address;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("Запрос добавления адресса")
public class AddressCreateRequest {

    @NotBlank
    @ApiModelProperty("Адрес 1")
    private String street1;

    @NotBlank
    @ApiModelProperty("Адрес 2")
    private String street2;

    @NotBlank
    @ApiModelProperty("Город")
    private String city;


    private String state;

    @NotBlank
    @ApiModelProperty("Почтовый индекс")
    private String zipcode;

    @NotBlank
    @ApiModelProperty("Страна")
    private String country;
}
