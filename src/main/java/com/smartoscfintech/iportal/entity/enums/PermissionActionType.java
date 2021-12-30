package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PermissionActionType {
    VIEW("View"),
    EDIT("Edit"),
    CREATE_NEW("Create New"),
    ASSIGN_USER("Assign User"),
    REMOVE_USER("Remove User"),
    APPROVE("Approve"),
    REJECT("Reject"),
    ASSIGN("Assign"),
    ASSIGN_TO_ME("Assign To Me"),
    ASSIGN_TO_OTHER("Assign To Other"),
    RE_ASSIGN("Re-Assign"),
    VIEW_MY_TASK("View My Task"),
    VIEW_OTHER_TASK("View Other Task"),
    VIEW_DETAIL("View Detail"),
    EXPORT("Export");

    private String name;
}
