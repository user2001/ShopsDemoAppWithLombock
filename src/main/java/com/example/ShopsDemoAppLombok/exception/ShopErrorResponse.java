package com.example.ShopsDemoAppLombok.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShopErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

}