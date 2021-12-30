package com.smartoscfintech.iportal.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchRequest {
    @Schema(description = "Full name normalize of customer, exam: full_name: Nguyễn Văn Hùng -> full_name_normalize: nguyen van hung")
    private String fullNameNormalize;

    @Schema(description = "Staff status")
    private Boolean status;

    @Schema(description = "Role id")
    private Long roleId;

    @Schema(description = "Created date begin for search between")
    private Long createdDateFrom;

    @Schema(description = "Created date end for search between")
    private Long createdDateTo;

    @NotNull
    private PagingRequest paging;

}
