package com.eminence.chitty.jwt.dto;

import lombok.Data;

@Data
public class AuctionPost {
    private Long Id;
    private Long chittyId;
    private Long userId;
    private Long currentBid;
}
