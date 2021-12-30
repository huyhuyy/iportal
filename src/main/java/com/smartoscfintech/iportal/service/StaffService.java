package com.smartoscfintech.iportal.service;

import com.smartoscfintech.iportal.controller.dto.*;
import com.smartoscfintech.iportal.controller.dto.request.*;
import com.smartoscfintech.iportal.controller.dto.response.PagingResponse;
import com.smartoscfintech.iportal.controller.dto.response.StaffResponse;
import com.smartoscfintech.iportal.controller.dto.response.TransactionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StaffService {
    PagingResponse<UserDto> getListStaff(UserSearchRequest userRequest);

    StaffDto getStaff(Long id);
    List<TransactionResponse> getTransactionByStaff(Long id);
}
