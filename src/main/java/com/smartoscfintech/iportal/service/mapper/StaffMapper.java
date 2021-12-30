package com.smartoscfintech.iportal.service.mapper;

import com.smartoscfintech.iportal.controller.dto.*;
import com.smartoscfintech.iportal.controller.dto.response.StaffResponse;
import com.smartoscfintech.iportal.entity.RoleEntity;
import com.smartoscfintech.iportal.entity.StaffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        imports = {RoleEntity.class, Collectors.class, Objects.class})


public interface StaffMapper {

    @Mapping(target = "roles", expression = "java(Objects.nonNull(entity.getUser().getRoles())?  entity.getUser().getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList()) : null)")
    @Mapping(target = "createdDate", source = "entity.createdDate")
    UserDto mapToUserDto(StaffEntity entity);

    @Mapping(target = "username", expression = "java(entity.getEmail().split(\"@\")[0])")
    @Mapping(target = "status", source = "entity.user.active")
    @Mapping(target = "uuid", source = "entity.avatar.uuid")
    @Mapping(target = "roleList", expression = "java(Objects.nonNull(roleNames) ? roleNames : null)")
    @Mapping(target = "businessUnit", source = "entity.primaryGroup")
    StaffResponse mapToResponse(StaffEntity entity, List<String> roleNames);

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
    @Named("mapStaffEntityToDto")
    StaffDto mapToDto(StaffEntity staffEntity);
    StaffEntity mapToEntity(StaffDto staffDto);
    List<StaffDto> map(List<StaffEntity> staffEntities);
}


