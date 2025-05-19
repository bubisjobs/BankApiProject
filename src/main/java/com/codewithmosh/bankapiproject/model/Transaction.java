package com.codewithmosh.bankapiproject.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private String from;
    private String to;
    private double amount;
    private String timestamp;

}
