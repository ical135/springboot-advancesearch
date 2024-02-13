package cal.springbootbelajar.repository;

import cal.springbootbelajar.entity.Pendaftaran;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PendaftaranRepository extends JpaRepository<Pendaftaran, Long>, JpaSpecificationExecutor<Pendaftaran> {
}