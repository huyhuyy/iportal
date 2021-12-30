package com.smartoscfintech.iportal.controller.dto.response;

import com.smartoscfintech.iportal.controller.dto.GroupSearchDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffResponse {
    private String fullName;
    private String username;
    private String email;
    private String phone;
    private GroupSearchDto businessUnit;
    private String note;
    private List<String> roleList;
    private boolean status;
    private String uuid;
}
