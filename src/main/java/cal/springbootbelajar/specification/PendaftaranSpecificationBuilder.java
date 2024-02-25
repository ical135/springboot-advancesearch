package cal.springbootbelajar.specification;


import cal.springbootbelajar.dto.SearchCriteriaDto;
import cal.springbootbelajar.entity.Pendaftaran;
import cal.springbootbelajar.enums.SearchOperationEnum;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PendaftaranSpecificationBuilder {
    private final List<SearchCriteriaDto> searchCriteriaDtos;

    public PendaftaranSpecificationBuilder() {
        this.searchCriteriaDtos = new ArrayList<>();
    }

//    public final PendaftaranSpecificationBuilder with(String key, String operation, Object value) {
//        searchCriteriaDtos.add(new SearchCriteriaDto(underscoreToCamelCase(key), operation, value));
//        return this;
//    }

    public final PendaftaranSpecificationBuilder with(SearchCriteriaDto searchCriteriaDto) {
        searchCriteriaDto.setFilterKey(underscoreToCamelCase(searchCriteriaDto.getFilterKey()));
        searchCriteriaDtos.add(searchCriteriaDto);
        return this;
    }

    public Specification<Pendaftaran> build() {
        if (searchCriteriaDtos.size() == 0) {
            return null;
        }

        Specification<Pendaftaran> result = new PendaftaranSpecification(searchCriteriaDtos.get(0));
        for (int idx = 1; idx < searchCriteriaDtos.size(); idx++) {
            SearchCriteriaDto searchCriteriaDto = searchCriteriaDtos.get(idx);
            result = SearchOperationEnum.getDataOption(searchCriteriaDto.getDataOption()) == SearchOperationEnum.ALL
                    ? Specification.where(result).and(new PendaftaranSpecification(searchCriteriaDto))
                    : Specification.where(result).or(new PendaftaranSpecification(searchCriteriaDto));
        }
        return result;
    }

    public static String underscoreToCamelCase(String underscoreString) {
        StringBuilder camelCaseBuilder = new StringBuilder();

        boolean capitalizeNext = false;
        for (char c : underscoreString.toCharArray()) {
            if (c == '_') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    camelCaseBuilder.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    camelCaseBuilder.append(c);
                }
            }
        }

        return camelCaseBuilder.toString();
    }
}
