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
                return criteriaBuilder.equal(criteriaBuilder.lower(root.get(searchCriteriaDto.getFilterKey())), searchCriteriaDto.getValue());
            case NOT_EQUAL:
                return criteriaBuilder.notEqual(criteriaBuilder.lower(root.get(searchCriteriaDto.getFilterKey())), searchCriteriaDto.getValue());
            case NUL:
                return criteriaBuilder.isNull(root.get(searchCriteriaDto.getFilterKey()));
            case NOT_NULL:
                return criteriaBuilder.isNotNull(root.get(searchCriteriaDto.getFilterKey()));
            case GREATER_THAN:
                return criteriaBuilder.greaterThan(root.<String>get(searchCriteriaDto.getFilterKey()), searchCriteriaDto.getValue().toString());
            case LESS_THAN:
                return criteriaBuilder.lessThan(root.<String>get(searchCriteriaDto.getFilterKey()), searchCriteriaDto.getValue().toString());
            case LESS_THAN_EQUAL:
                return criteriaBuilder.lessThanOrEqualTo(root.<String>get(searchCriteriaDto.getFilterKey()), searchCriteriaDto.getValue().toString());
        }
        return null;
    }

}
