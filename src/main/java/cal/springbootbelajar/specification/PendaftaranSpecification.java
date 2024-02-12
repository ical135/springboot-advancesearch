package cal.springbootbelajar.specification;

import cal.springbootbelajar.dto.SearchCriteriaDto;
import cal.springbootbelajar.entity.Jadwaldokter;
import cal.springbootbelajar.entity.Pendaftaran;
import cal.springbootbelajar.enums.SearchOperationEnum;
import jakarta.persistence.criteria.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

public class PendaftaranSpecification implements Specification<Pendaftaran> {
    @Autowired
    SearchCriteriaDto searchCriteriaDto;

    public PendaftaranSpecification(SearchCriteriaDto searchCriteriaDto){
        super();
        this.searchCriteriaDto = searchCriteriaDto;
    }

    @Override
    public Predicate toPredicate(Root<Pendaftaran> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        String strToSearch = searchCriteriaDto.getValue()
                .toString()
                .toLowerCase();
//        switch (SearchOperationEnum.getSimpleOperation(searchCriteriaDto.getOperation())){
//            case CONTAINS :
//                if(searchCriteriaDto.getFilterKey().equals("pendaftaranKodedaftar")){
//                    return criteriaBuilder.like(criteriaBuilder.lower())
//                }
//        }
        return null;
    }

//    private Join<Pendaftaran, Jadwaldokter> pendaftaranJadwaldokterJoin
}
