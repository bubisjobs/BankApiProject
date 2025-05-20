package com.codewithmosh.bankapiproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsDTO {
    @NotBlank
    private String from;
    @NotBlank
    private String to;
    @NotBlank
    private double amount;

    private String timestamp;
}
