package com.smartoscfintech.iportal.repository.specification;

import com.smartoscfintech.iportal.common.util.StringUtils;
import com.smartoscfintech.iportal.entity.StaffEntity;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StaffSpecification {
    private final List<Specification<StaffEntity>> specs = new ArrayList<>();
    private static final String FULL_NAME = "fullNameNormalize";
    private static final String USER = "user";
    private static final String ACTIVE = "active";
    private static final String CREATED_DATE = "createdDate";



    public static StaffSpecification spec() {
        return new StaffSpecification();
    }

    public Specification<StaffEntity> build() {
        return specs.stream().reduce(all(), Specification::and);
    }

    public Specification<StaffEntity> buildOrCondition() {
        Specification<StaffEntity> identity = specs.isEmpty() ? all() : none();
        return specs.stream().reduce(identity, Specification::or);
    }

    private Specification<StaffEntity> none() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.literal(1), 0);
    }

    private Specification<StaffEntity> all() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.literal(1), 1);
    }

    public StaffSpecification withFullName(String fullNameNormalize) {
        if (ObjectUtils.isEmpty(fullNameNormalize)) {
            return this;
        }
        String fullName = StringUtils.normalizeString(fullNameNormalize.toLowerCase(Locale.ROOT));

        specs.add((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.upper(root.get(FULL_NAME)), StringUtils.appendLike( fullName.toUpperCase())));
        return this;
    }


    public StaffSpecification withActive(Boolean staffStatus) {
        if (ObjectUtils.isEmpty(staffStatus)) {
            return this;
        }
        specs.add((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(ACTIVE), staffStatus));
        return this;
    }

    public StaffSpecification withCreatedDate(LocalDateTime fromDate, LocalDateTime toDate) {
        if (ObjectUtils.isEmpty(fromDate) && ObjectUtils.isEmpty(toDate)) {
            return this;
        } else if (ObjectUtils.isEmpty(fromDate)) {
            specs.add((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(CREATED_DATE), toDate));
        } else if (ObjectUtils.isEmpty(toDate)) {
            specs.add((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(CREATED_DATE), fromDate));
        } else {
            specs.add((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(CREATED_DATE), fromDate, toDate));
        }
        return this;
    }


    public StaffSpecification withRole(List<Long> withUserByIds) {
        if (ObjectUtils.isEmpty(withUserByIds)) {
            return this;
        }
        specs.add((root, query, criteriaBuilder) -> criteriaBuilder.and(root.get(USER).in(withUserByIds)));
        return this;
    }

}
