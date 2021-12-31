package com.smartoscfintech.iportal.controller.impl;

import com.smartoscfintech.iportal.controller.EkycTransactionController;
import com.smartoscfintech.iportal.controller.dto.EkycTransactionDto;
import com.smartoscfintech.iportal.controller.dto.response.Response;
import com.smartoscfintech.iportal.service.EkycTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class EkycTransactionControllerImpl implements EkycTransactionController {
    private final EkycTransactionService ekycTransactionService;

    @Override
    public Response<EkycTransactionDto> getEkycTransaction(Long id) {
        EkycTransactionDto ekycTransactionDto = ekycTransactionService.getEkycTransaction(id);
        return Response.ok(ekycTransactionDto);
    }
}
