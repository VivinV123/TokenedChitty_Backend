package com.eminence.chitty.jwt.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ChittyPost {

    private Long chitNumber;
    private Long installment;
    private Long duration;
    private Long manager;
    private Integer numberOfChittal;
    private Integer currentNumberOfChittal;
    private Long category;
    private Long totalAmount;
    private Date launchDate;
    private Date startDate;
    private String status;
}
