package cal.springbootbelajar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
@Builder
public class PaginationResponseDto {
    @JsonProperty("pageable")
    private Pageable pageable;
    @JsonProperty("totalElements")
    private Long totalElements;
}
