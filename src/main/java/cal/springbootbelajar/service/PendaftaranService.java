package cal.springbootbelajar.service;

import cal.springbootbelajar.entity.Pendaftaran;
import cal.springbootbelajar.repository.PendaftaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PendaftaranService {

    @Autowired
    PendaftaranRepository pendaftaranRepository;

    public Optional<Pendaftaran>  getById(Long id) {
        return pendaftaranRepository.findById(id);
    }

}
