package cal.springbootbelajar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "pendaftaran")
public class Pendaftaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("pendaftaran_id")
    private Long pendaftaranId;
    @Column(name = "pendaftaran_kodedaftar", length = 15)
    @JsonProperty("pendaftaran_kodedaftar")
    private String pendaftaranKodedaftar;
    @Column(name = "pasien_id")
    @JsonProperty("pasien_id")
    private Long pasienId;
    @Column(name = "pendaftaranrs_id", length = 15)
    @JsonProperty("pendaftaranrs_id")
    private String pendaftaranrsId;
    @Column(name = "pendaftaran_created_at", columnDefinition = "TIMESTAMP")
    @JsonProperty("pendaftaran_created_at")
    private LocalDateTime pendaftaranCreatedAt;
    @Column(name = "pendaftaran_updated_at", columnDefinition = "TIMESTAMP")
    @JsonProperty("pendaftaran_updated_at")
    private LocalDateTime pendaftaranUpdatedAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jadwaldokter_id", referencedColumnName = "jadwaldokter_id")
    private Jadwaldokter jadwaldokter;
}
