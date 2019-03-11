package com.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by RK
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String fullName;
    private String email;
    private String mobile;
    private String city;
    private String departmentName;



    @JsonProperty("customer_url")
    private String customerUrl;

}
