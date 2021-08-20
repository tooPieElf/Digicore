package com.digicore.digicore.apiResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiResponse {
    int responseCode;
    Boolean successResponse;
    String message;
}
