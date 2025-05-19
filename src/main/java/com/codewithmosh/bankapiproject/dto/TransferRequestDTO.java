package com.codewithmosh.bankapiproject.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDTO {

    @NotBlank
    private String fromAccountId;

    @NotBlank
    private  String toAccountId;

    @Min(0)
    private double amount;
}
