package cal.springbootbelajar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    private List<SearchCriteriaDto> searchCriteriaList;
    private String dataOption;
}
