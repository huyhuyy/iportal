package com.smartoscfintech.iportal.service.mapper;

import com.smartoscfintech.iportal.controller.dto.GroupSearchDto;
import com.smartoscfintech.iportal.controller.dto.StaffDto;
import com.smartoscfintech.iportal.controller.dto.UserDto;
import com.smartoscfintech.iportal.controller.dto.response.StaffResponse;
import com.smartoscfintech.iportal.entity.DocumentEntity;
import com.smartoscfintech.iportal.entity.GroupEntity;
import com.smartoscfintech.iportal.entity.RoleEntity;
import com.smartoscfintech.iportal.entity.StaffEntity;
import com.smartoscfintech.iportal.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-30T15:49:26+0700",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class StaffMapperImpl implements StaffMapper {

    @Override
    public UserDto mapToUserDto(StaffEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setCreatedDate( entity.getCreatedDate() );
        userDto.setId( entity.getId() );
        userDto.setFullName( entity.getFullName() );
        userDto.setFullNameNormalize( entity.getFullNameNormalize() );
        userDto.setEmail( entity.getEmail() );
        userDto.setPhone( entity.getPhone() );
        userDto.setActive( entity.isActive() );

        userDto.setRoles( Objects.nonNull(entity.getUser().getRoles())?  entity.getUser().getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList()) : null );

        return userDto;
    }

    @Override
    public StaffResponse mapToResponse(StaffEntity entity, List<String> roleNames) {
        if ( entity == null && roleNames == null ) {
            return null;
        }

        StaffResponse staffResponse = new StaffResponse();

        if ( entity != null ) {
            staffResponse.setStatus( entityUserActive( entity ) );
            staffResponse.setUuid( entityAvatarUuid( entity ) );
            staffResponse.setBusinessUnit( groupEntityToGroupSearchDto( entity.getPrimaryGroup() ) );
            staffResponse.setFullName( entity.getFullName() );
            staffResponse.setEmail( entity.getEmail() );
            staffResponse.setPhone( entity.getPhone() );
            staffResponse.setNote( entity.getNote() );
        }
        staffResponse.setUsername( entity.getEmail().split("@")[0] );
        staffResponse.setRoleList( Objects.nonNull(roleNames) ? roleNames : null );

        return staffResponse;
    }

    @Override
    public StaffDto mapToDto(StaffEntity staffEntity) {
        if ( staffEntity == null ) {
            return null;
        }

        StaffDto staffDto = new StaffDto();

        staffDto.setId( staffEntity.getId() );
        staffDto.setFullName( staffEntity.getFullName() );
        staffDto.setFullNameNormalize( staffEntity.getFullNameNormalize() );
        staffDto.setEmail( staffEntity.getEmail() );

        return staffDto;
    }

    @Override
    public StaffEntity mapToEntity(StaffDto staffDto) {
        if ( staffDto == null ) {
            return null;
        }

        StaffEntity staffEntity = new StaffEntity();

        staffEntity.setId( staffDto.getId() );
        staffEntity.setFullName( staffDto.getFullName() );
        staffEntity.setFullNameNormalize( staffDto.getFullNameNormalize() );
        staffEntity.setEmail( staffDto.getEmail() );

        return staffEntity;
    }

    @Override
    public List<StaffDto> map(List<StaffEntity> staffEntities) {
        if ( staffEntities == null ) {
            return null;
        }

        List<StaffDto> list = new ArrayList<StaffDto>( staffEntities.size() );
        for ( StaffEntity staffEntity : staffEntities ) {
            list.add( staffEntityToStaffDto( staffEntity ) );
        }

        return list;
    }

    private boolean entityUserActive(StaffEntity staffEntity) {
        if ( staffEntity == null ) {
            return false;
        }
        UserEntity user = staffEntity.getUser();
        if ( user == null ) {
            return false;
        }
        boolean active = user.isActive();
        return active;
    }

    private String entityAvatarUuid(StaffEntity staffEntity) {
        if ( staffEntity == null ) {
            return null;
        }
        DocumentEntity avatar = staffEntity.getAvatar();
        if ( avatar == null ) {
            return null;
        }
        String uuid = avatar.getUuid();
        if ( uuid == null ) {
            return null;
        }
        return uuid;
    }

    protected GroupSearchDto groupEntityToGroupSearchDto(GroupEntity groupEntity) {
        if ( groupEntity == null ) {
            return null;
        }

        GroupSearchDto groupSearchDto = new GroupSearchDto();

        groupSearchDto.setId( groupEntity.getId() );
        groupSearchDto.setName( groupEntity.getName() );
        groupSearchDto.setCode( groupEntity.getCode() );

        return groupSearchDto;
    }

    protected StaffDto staffEntityToStaffDto(StaffEntity staffEntity) {
        if ( staffEntity == null ) {
            return null;
        }

        StaffDto staffDto = new StaffDto();

        staffDto.setId( staffEntity.getId() );
        staffDto.setFullName( staffEntity.getFullName() );
        staffDto.setFullNameNormalize( staffEntity.getFullNameNormalize() );
        staffDto.setEmail( staffEntity.getEmail() );

        return staffDto;
    }
}
