package com.smartoscfintech.iportal.controller.impl;

import com.smartoscfintech.iportal.controller.StaffController;
import com.smartoscfintech.iportal.controller.dto.*;
import com.smartoscfintech.iportal.controller.dto.request.*;
import com.smartoscfintech.iportal.controller.dto.response.PagingResponse;
import com.smartoscfintech.iportal.controller.dto.response.Response;
import com.smartoscfintech.iportal.controller.dto.response.StaffResponse;
import com.smartoscfintech.iportal.controller.dto.response.TransactionResponse;
import com.smartoscfintech.iportal.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class StaffControllerImpl implements StaffController {
    private final StaffService staffService;

    @Override
    public Response<PagingResponse<UserDto>> listStaff(@Valid UserSearchRequest userRequest) {
        PagingResponse<UserDto> data =  staffService.getListStaff(userRequest);
        return Response.ok(data);
    }

    @Override
    public Response<List<StaffDto>> getAllStaff() {
        List<StaffDto> response = staffService.getAllStaff();
        return Response.ok(response);
    }

    @Override
    public Response<StaffDto> getStaff(Long id) {
        StaffDto response = staffService.getStaff(id);
        return Response.ok(response);
    }

    @Override
    public Response<List<TransactionResponse>> getTransactionByStaff(Long id) {
        List<TransactionResponse> response = staffService.getTransactionByStaff(id);
        return Response.ok(response);
    }
}
