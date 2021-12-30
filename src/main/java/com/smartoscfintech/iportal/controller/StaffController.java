package com.smartoscfintech.iportal.controller;

import com.smartoscfintech.iportal.controller.dto.*;
import com.smartoscfintech.iportal.controller.dto.request.*;
import com.smartoscfintech.iportal.controller.dto.response.PagingResponse;
import com.smartoscfintech.iportal.controller.dto.response.Response;
import com.smartoscfintech.iportal.controller.dto.response.StaffResponse;
import com.smartoscfintech.iportal.controller.dto.response.TransactionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/staffs")
public interface StaffController {

    @PostMapping(value = "/list")
    @Operation(description = "List user management by conditions")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Not Found Exception")
    @ApiResponse(responseCode = "405", description = "Method Not Allow")
    @ApiResponse(responseCode = "409", description = "Business Validation Exception")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    Response<PagingResponse<UserDto>> listStaff(@RequestBody @Valid UserSearchRequest userRequest);

    @GetMapping("/{id}")
    @Operation(description = "Get staff by id")
    @ApiResponse(responseCode = "200", description = "Succsess")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Not Found Exception")
    @ApiResponse(responseCode = "405", description = "Method Not Allow")
    @ApiResponse(responseCode = "409", description = "Business Validation Exception")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    Response<StaffDto> getStaff(@PathVariable Long id);

    @GetMapping("/{id}/Transactions")
    @Operation(description = "Get Transactions of staff")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Not Found Exception")
    @ApiResponse(responseCode = "405", description = "Method Not Allow")
    @ApiResponse(responseCode = "409", description = "Business Validation Exception")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    Response<List<TransactionResponse>> getTransactionByStaff(@PathVariable Long id);
}
