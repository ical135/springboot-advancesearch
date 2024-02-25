package cal.springbootbelajar.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaDto {
    @JsonProperty("key")
    private String filterKey;
    @JsonProperty("value")
    private Object value;
    @JsonProperty("operation")
    private String operation;
    @JsonIgnore
    private String dataOption;

    public SearchCriteriaDto(String filterKey, String operation,
                             Object value) {
        super();
        this.filterKey = filterKey;
        this.operation = operation;
        this.value = value;
    }
}
