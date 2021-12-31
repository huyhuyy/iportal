package com.smartoscfintech.iportal.controller;

import com.smartoscfintech.iportal.controller.dto.EkycTransactionDto;
import com.smartoscfintech.iportal.controller.dto.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ekycs")
public interface EkycTransactionController {

    @GetMapping("/{id}")
    @Operation(description = "Get staff by id")
    @ApiResponse(responseCode = "200", description = "Succsess")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Not Found Exception")
    @ApiResponse(responseCode = "405", description = "Method Not Allow")
    @ApiResponse(responseCode = "409", description = "Business Validation Exception")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    Response<EkycTransactionDto> getEkycTransaction(@PathVariable Long id);
}
