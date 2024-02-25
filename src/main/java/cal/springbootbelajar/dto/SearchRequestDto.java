package cal.springbootbelajar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    @JsonProperty("criterialist")
    private List<SearchCriteriaDto> searchCriteriaList;
    @JsonProperty("data_option")
    private String dataOption;
}
