package com.smartoscfintech.iportal.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserNewRequest {

    @Schema(description = "Full name of user")
    private String fullName;

    @Schema(description = "User name")
    private String username;

    @Schema(description = "Email")
    private String email;

    @Schema(description = "Phone")
    private String phone;

    @Schema(description = "Business unit code")
    private String businessUnit;

    @Schema(description = "Note")
    private String note;

    @Schema(description = "Role list")
    private List<String> roleList;

    @Schema(description = "Staff status")
    private Boolean status;

    @Schema(description = "Avatar image")
    MultipartFile avatar;



}
