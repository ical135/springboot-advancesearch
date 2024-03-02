package cal.springbootbelajar.specification;

import cal.springbootbelajar.dto.SearchCriteriaDto;
import cal.springbootbelajar.entity.Pendaftaran;
import cal.springbootbelajar.enums.SearchOperationEnum;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PendaftaranSpecification implements Specification<Pendaftaran> {
    @Autowired
    SearchCriteriaDto searchCriteriaDto;

    public PendaftaranSpecification(SearchCriteriaDto searchCriteriaDto) {
        super();
        this.searchCriteriaDto = searchCriteriaDto;
    }

    @Override
    public Predicate toPredicate(Root<Pendaftaran> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        String strToSearch = searchCriteriaDto.getValue()
                .toString()
                .toLowerCase();
        switch (Objects.requireNonNull(SearchOperationEnum.getSimpleOperation(searchCriteriaDto.getOperation()))) {
            case CONTAINS:
                return criteriaBuilder.like(criteriaBuilder.lower(root.get(searchCriteriaDto.getFilterKey())), "%" + strToSearch + "%");
            case DOES_NOT_CONTAIN:
                return criteriaBuilder.notLike(criteriaBuilder.lower(root.get(searchCriteriaDto.getFilterKey())), "%" + strToSearch + "%");
            case BEGINS_WITH:
                return criteriaBuilder.like(criteriaBuilder.lower(root.get(searchCriteriaDto.getFilterKey())), strToSearch + "%");
            case DOES_NOT_BEGIN_WITH:
                return criteriaBuilder.notLike(criteriaBuilder.lower(root.get(searchCriteriaDto.getFilterKey())), strToSearch + "%");
            case ENDS_WITH:
                return criteriaBuilder.like(criteriaBuilder.lower(root.get(searchCriteriaDto.getFilterKey())), "%" + strToSearch);
            case DOES_NOT_END_WITH:
                return criteriaBuilder.notLike(criteriaBuilder.lower(root.get(searchCriteriaDto.getFilterKey())), "%" + strToSearch);
            case EQUAL:
                return criteriaBuilder.equal(root.get(searchCriteriaDto.getFilterKey()), searchCriteriaDto.getValue());
            case NOT_EQUAL:
                return criteriaBuilder.notEqual(root.get(searchCriteriaDto.getFilterKey()), searchCriteriaDto.getValue());
            case NUL:
                return criteriaBuilder.isNull(root.get(searchCriteriaDto.getFilterKey()));
            case NOT_NULL:
                return criteriaBuilder.isNotNull(root.get(searchCriteriaDto.getFilterKey()));
            case GREATER_THAN:
                switch (getAttributeType(searchCriteriaDto.getFilterKey())){
                    case "java.time.LocalDateTime":
                        return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteriaDto.getFilterKey()).as(LocalDateTime.class), LocalDateTime.parse(searchCriteriaDto.getValue().toString()));
                    case "java.time.LocalDate":
                        return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteriaDto.getFilterKey()).as(LocalDate.class), LocalDate.parse(searchCriteriaDto.getValue().toString()));
                    case "java.lang.Long":
                        return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteriaDto.getFilterKey()).as(Long.class), Long.parseLong(searchCriteriaDto.getValue().toString()));
                    default:
                        return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteriaDto.getFilterKey()), searchCriteriaDto.getValue().toString());
                }
            case LESS_THAN:
                switch (getAttributeType(searchCriteriaDto.getFilterKey())){
                    case "java.time.LocalDateTime":
                        return criteriaBuilder.lessThan(root.get(searchCriteriaDto.getFilterKey()).as(LocalDateTime.class), LocalDateTime.parse(searchCriteriaDto.getValue().toString()));
                    case "java.time.LocalDate":
                        return criteriaBuilder.lessThan(root.get(searchCriteriaDto.getFilterKey()).as(LocalDate.class), LocalDate.parse(searchCriteriaDto.getValue().toString()));
                    case "java.lang.Long":
                        return criteriaBuilder.lessThan(root.get(searchCriteriaDto.getFilterKey()).as(Long.class), Long.parseLong(searchCriteriaDto.getValue().toString()));
                    default:
                        return criteriaBuilder.lessThan(root.get(searchCriteriaDto.getFilterKey()), searchCriteriaDto.getValue().toString());
                }
            case LESS_THAN_EQUAL:
                switch (getAttributeType(searchCriteriaDto.getFilterKey())){
                    case "java.time.LocalDateTime":
                        return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteriaDto.getFilterKey()).as(LocalDateTime.class), LocalDateTime.parse(searchCriteriaDto.getValue().toString()));
                    case "java.time.LocalDate":
                        return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteriaDto.getFilterKey()).as(LocalDate.class), LocalDate.parse(searchCriteriaDto.getValue().toString()));
                    case "java.lang.Long":
                        return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteriaDto.getFilterKey()).as(Long.class), Long.parseLong(searchCriteriaDto.getValue().toString()));
                    default:
                        return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteriaDto.getFilterKey()), searchCriteriaDto.getValue().toString());
                }
        }
        return null;
    }

    private String getAttributeType(String attributeName){
        Pendaftaran pendaftaran = new Pendaftaran();

        Field[] fields = pendaftaran.getClass().getDeclaredFields();
        Map<String, String> mapPendaftaranAttrib = new HashMap<>();
        for(Field field: fields){
            Class<?> fieldType = field.getType();
            String fieldName = field.getName();

            mapPendaftaranAttrib.put(fieldName, fieldType.getName());
        }

        return mapPendaftaranAttrib.get(attributeName);
    }

}
