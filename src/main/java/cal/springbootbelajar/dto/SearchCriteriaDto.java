package cal.springbootbelajar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaDto {
    private String filterKey;
    private Object value;
    private String operation;
    private String dataOption;

    public SearchCriteriaDto(String filterKey, String operation,
                             Object value) {
        super();
        this.filterKey = filterKey;
        this.operation = operation;
        this.value = value;
    }
}
