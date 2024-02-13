package cal.springbootbelajar.service;

import cal.springbootbelajar.dto.SearchCriteriaDto;
import cal.springbootbelajar.dto.SearchRequestDto;
import cal.springbootbelajar.entity.Pendaftaran;
import cal.springbootbelajar.repository.PendaftaranRepository;
import cal.springbootbelajar.specification.PendaftaranSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PendaftaranService {

    @Autowired
    PendaftaranRepository pendaftaranRepository;

    public Optional<Pendaftaran> getById(Long id) {
        return pendaftaranRepository.findById(id);
    }

    public Page<Pendaftaran> getAdvanceFilter(SearchRequestDto searchRequestDto, Pageable pageable) {
        PendaftaranSpecificationBuilder pendaftaranSpecificationBuilder = new PendaftaranSpecificationBuilder();
        List<SearchCriteriaDto> searchCriteriaDtoList = searchRequestDto.getSearchCriteriaList();
        if (searchCriteriaDtoList != null) {
            searchCriteriaDtoList.forEach(x -> {
                x.setDataOption(searchRequestDto.getDataOption());
                pendaftaranSpecificationBuilder.with(x);
            });
        }

        Page<Pendaftaran> pendaftarans = pendaftaranRepository.findAll(pendaftaranSpecificationBuilder.build(),
                pageable);
        return pendaftarans;
    }
}
